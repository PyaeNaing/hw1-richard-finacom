package simpleserver;

import com.google.gson.Gson;

public class testing {
    public static void main(String args[])
    {
        DataInterface user1 = new User(0,"JJ");
        System.out.println(new Gson().toJson(user1));
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
