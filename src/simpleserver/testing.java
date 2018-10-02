package simpleserver;

import com.google.gson.Gson;

import javax.xml.crypto.Data;
import java.sql.SQLOutput;

public class testing {
    public static void main(String args[])
    {
        Gson gson = new Gson();
        Database b = Database.getInstance();
        String g = "-12";
        int c = Integer.valueOf(g);
        System.out.println(c);

        //System.out.println(gson.toJson(Post.getPost(1).getData()));

        //System.out.println((new Response("Error")).convertToJson());
        Request r = new Request("posts?postid=7&maxlength=14");
        Processor a = new Processor();
        a.response("posts?postid=7",b);
        //System.out.print(a.response("user",b));
        //System.out.print(a.response("user?userid=7",b));

        /*

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
