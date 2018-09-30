package simpleserver;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Processor {

    public Processor(){}

    public Processor(String request) {
        ProcessorFactory.makeProcessor(request);
    }



    public static String startResponse(Request request) {
        Response ret = new Response();
        DataInterface process;
        if(request.getValid()) {
            if (request.getLength() != -1) {

            } else {
                if(!(request.getReturnall())) {
                    //get user by id number
                    //ret: Status = OK, Entries = 1, data = user
                    ret.setStatus(request);
                    ret.setEntries(1);
                } else {
                    //add all user into an arrayList

                }
            }
            return ret.convertToJson();
        } else {
            ret = new Response("Error", 0, null);
            return ret.convertToJson();
        }
    }

    public static void test(String s, Database w) {
        Gson x = new Gson();
        System.out.println(x.toJson(User.getAllUser()));
        ArrayList<UserProcess> v = new ArrayList<UserProcess>();
        for (int i = 0; i < User.getAllUser().size(); i++) {
            v.add(new UserProcess(User.getAllUser().get(i).getId(), User.getAllUser().get(i).getData()));
        }
        System.out.println(x.toJson(v));
    }
}

class ProcessorFactory {

    public static Processor makeProcessor(String request) {
        switch (request) {
            case "users":
                return new User(request);
            case "posts":
                return new Post(request);
        }
        return null;
    }
}

