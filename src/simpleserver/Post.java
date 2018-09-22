package simpleserver;

import com.google.gson.Gson;

public class Post implements DataInterface{
    int postid;
    String data;

    public int getId() {
        return postid;
    }

    public String getData() {
        return data;
    }

    public String convertToJson() {
        return new Gson().toJson(this);
    }

}

