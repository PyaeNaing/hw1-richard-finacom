package simpleserver;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Post extends Processor implements DataInterface{
    private int userid;
    private int postid;
    private String data;
    private static Map<Integer, Post> postidDict = new HashMap<>();
    private static ArrayList<Post> allPosts = new ArrayList<>();

    public Post() {
        //this.data = "";
        //this.postid = -1;
        //this.userid = -1;
        allPosts.add(this);
    }

    public Post(int ID, int PostId, String data){
        this.postid = PostId;
        this.data = data;
        this.userid = ID;
        allPosts.add(this);
        postidDict.put(postid, this);
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

    public void register() {
        postidDict.put(postid, this);
    }

    public static Post getPost(int postid) {
        return postidDict.get(postid);
    }

    public void setUserid(int userid) {
        this.userid = userid;
        System.out.println(postid);
    }

    public static void loadAll() {
        for (int i = 0; i < allPosts.size(); i++) {
            allPosts.get(i).register();
        }
    }
}

