package simpleserver;

public class testing {
    public static void main(String args[])
    {

       Request r = new Request("posts?postid=7");
       //Request r = new Request("user");


       if (r.getValid())
           System.out.println("It is Valid");
       if (!r.getValid())
           System.out.println(r.errorr);
       System.out.println("Endpoint = " + r.getEndpoint());
       System.out.println("ID = " + r.getID());
       System.out.println("Length = " + r.getLength());
       System.out.println("Return all = " + r.getReturnall());
       /**/
    }
}
