package simpleserver;

import com.google.gson.Gson;

class User extends Processor implements DataInterface {
    private int userid;
    private String username;

    public User() {
        this.userid = -1;
        this.username = "";
    }

    public User(int gUserId, String gUsername){
        this.userid = gUserId;
        this.username = gUsername;
    }

    public User(String request) {
        super(request);
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