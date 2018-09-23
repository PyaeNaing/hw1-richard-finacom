package simpleserver;

import com.google.gson.Gson;

public class Post extends Processor implements DataInterface{
    private int postid;
    private String post;

    public Post(int gPostId, String gPost){
        this.postid = gPostId;
        this.post = gPost;
    }

    public Post(String request) {
        super(request);
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

