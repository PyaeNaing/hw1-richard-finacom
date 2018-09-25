package simpleserver;

public class Request {

    private String endpoint;
    private String request;
    private int id = -1;
    private int length = 0;
    private boolean valid = false;
    private boolean returnall = false;
    public String errorr = "";

    public Request(String request)
    {
        parse(request);
    }

    public void parse(String request)
    {
        if(request.equals("user"))
        {
            returnall = valid = true;
            return;
        }

        try {
            String[] Split = request.split("\\?");
            endpoint = Split[0];

            if (endpoint.equals("user") || endpoint.equals("posts")) {
                Split = Split[1].split("&");
                if (Split.length == 1) {
                    Split = Split[0].split("=");
                    if (Split[0].equals("userid") || Split[0].equals("postid")) {
                        id = Integer.valueOf(Split[1]);
                    }
                } else if (Split.length == 2) {
                    String[] temp1, temp2;
                    temp1 = Split[0].split("=");
                    temp2 = Split[1].split("=");
                    if (temp1[0].equals("postid") && temp2[0].equals("maxlength")) {
                        id = Integer.valueOf(temp1[1]);
                        length = Integer.valueOf(temp2[1]);
                    } else if (temp2[0].equals("postid") && temp1[0].equals("maxlength")) {
                        id = Integer.valueOf(temp2[1]);
                        length = Integer.valueOf(temp1[1]);
                    } else
                        throw new Exception();
                }
            }
            else
                throw new Exception();

        }catch(Exception e)
        {

            errorr = e.toString();
            valid = false;
        }
    }

    // *** Getters ***
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
    public boolean getReturnall()
    {
        return this.returnall;
    }
}

