package simpleserver;

import com.google.gson.Gson;

public class Post implements DataInterface{
    private int postid;
    private String post;

    public Post(int gPostId, String gPost){
        this.postid = gPostId;
        this.post = gPost;
    }

    public int getId() {
        return postid;
    }

    public String getData() {
        return post;
    }

    public String convertToJson() {
        return new Gson().toJson(this);
    }

}

