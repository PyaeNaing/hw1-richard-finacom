package simpleserver;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class PostProcess extends Processor {
    private int userid;
    private int postid;
    private String data;


    public PostProcess() {
        this.data = "";
        this.postid = -1;
        this.userid = -1;
    }
    public PostProcess(int uID, int gPostId, String gPost){
        this.postid = gPostId;
        this.data = gPost;
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
        return data;
    }

    public String convertToJson() {
        return new Gson().toJson(this);
    }

    public static Response response(Request rq, Database data) {

        List<Processor> postP = new ArrayList<Processor>();
        Post post = Post.getPost(rq.getID());

        if(rq.getOnlypost() || rq.getLength() >= post.getData().length())
        {
            postP.add(new PostProcess(post.getUserID(),post.getId(),post.getData()));
        }

        else
        {
            return new Response("OK", 0, postP);
        }
            return new Response("OK", 1, postP);
    }

}
