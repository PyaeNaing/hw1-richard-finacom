package simpleserver;

import com.google.gson.Gson;

public class testing {
    public static void main(String args[])
    {
        System.out.println((new Response("Error")).convertToJson());
       Request r = new Request("posts?postid=7&maxlength=14");

            if (r.getValid())
            {
                System.out.println("It is Valid");
                System.out.println("Endpoint = " + r.getEndpoint());
                System.out.println("ID = " + r.getID());
                System.out.println("Length = " + r.getLength());
                System.out.println("Return all = " + r.getReturnall());
            }
       /**/
    }
}
