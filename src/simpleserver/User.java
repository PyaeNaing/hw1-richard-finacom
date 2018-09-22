package simpleserver;

import com.google.gson.Gson;

class User implements DataInterface {
    int userid;
    String username;

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