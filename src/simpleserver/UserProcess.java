package simpleserver;

import com.google.gson.Gson;
import java.util.*;

public class UserProcess extends Processor implements DataInterface{
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


}
