package simpleserver;

import com.google.gson.Gson;

import java.util.*;

public class UserProcess extends Processor {

    private int userid;
    private String username;


    public UserProcess(){
        this.userid = -1;
        this.username = null;
    }

    public UserProcess(int nID, String nUName) {
        this.username = nUName;
        this.userid = nID;
    }

    public String process() {
        return null;
    }

    public int getId() {
        return userid;
    }

    public String getData() {
        return username;
    }

    public String convertToJson() {
        return new Gson().toJson(this);
    }

    public static Response response(Request rq, Database data) {
        List<Processor> userP = new ArrayList<Processor>();
        ArrayList<User> users  = User.getAllUser();
        if (rq.getReturnall()) {
            for (int i = 0; i < users.size(); i++) {
                userP.add(new UserProcess(User.getAllUser().get(i).getId(), User.getAllUser().get(i).getData()));
            }
            return new Response("OK", users.size(), userP);
        } else {
            userP.add(new UserProcess(users.get(rq.getID()).getId(),users.get(rq.getID()).getData()));
            return new Response("OK", 1, userP);
        }

    }


}
