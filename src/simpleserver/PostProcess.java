package simpleserver;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class PostProcess extends Processor {
    private int postid;
    private int userid;
    private String post;


    public PostProcess() {
        this.post = "";
        this.postid = -1;
        this.userid = -1;
    }
    public PostProcess(int uID, int gPostId, String gPost){
        this.postid = gPostId;
        this.post = gPost;
        this.userid = uID;
    }

    public String process() {
        return null;
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

    public static Response response(Request rq, Database data) {

        List<Processor> postP = new ArrayList<Processor>();
        Post post = Post.getPost(rq.getID());

        if(rq.getLength() == -1 || rq.getLength() > post.getData().length())
        {
            postP.add(new PostProcess(post.getUserID(),post.getId(),post.getData()));
        }

        else
        {
            String cut = post.getData().substring(0,rq.getLength());
            postP.add(new PostProcess(post.getUserID(),post.getId(),cut));
        }
            return new Response("OK", 1, postP);
    }

}
