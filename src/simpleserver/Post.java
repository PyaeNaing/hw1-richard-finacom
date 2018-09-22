package simpleserver;

public class Post implements DataInterface{
    private int postid;
    private String data;

    public int getId() {
        return postid;
    }

    public String getData() {
        return data;
    }
}
