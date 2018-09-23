package simpleserver;

public class Request {

    private String endpoint;
    private int id = -1;
    private int length = 0;
    private boolean valid = false;

    public String getEndpoint()
    {
        return this.endpoint;
    }
    public int getID()
    {
        return this.id;
    }
    public int getLength()
    {
        return this.length;
    }
    public boolean getValid()
    {
        return this.valid;
    }

    public Request(String request)
    {
        String [] splitted = request.split(" ");
    }
}