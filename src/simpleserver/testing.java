package simpleserver;

import com.google.gson.Gson;

public class testing {
    public static void main(String args[])
    {
        DataInterface user1 = new User(0,"JJ");
        System.out.println(new Gson().toJson(user1));

    }
}
