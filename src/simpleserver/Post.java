package simpleserver;

import com.google.gson.Gson;

public class Post extends Processor implements DataInterface{
    private int postid;
    private int userid;
    private String post;

    public Post() {
        this.post = "";
        this.postid = -1;
        this.userid = -1;
    }
    public Post(int uID, int gPostId, String gPost){
        this.postid = gPostId;
        this.post = gPost;
        this.userid = uID;
    }

    public Post(String request) {
        super(request);
    }

    public int getId() {
        return postid;
    }

    public int getUserID() {return userid;}

    public String getData() {
        return post;
    }

    public String convertToJson() {
        return new Gson().toJson(this);
    }

}

