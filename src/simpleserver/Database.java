package simpleserver;


import com.google.gson.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Database {
    private static Database instance = null;

    private Database () {
        getUser();
        getPost();
    }

    public static void getUser() {
        Gson gson = new Gson();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("src/data.jason"));
            JsonParser jsonParser = new JsonParser();
            JsonObject obj = jsonParser.parse(br).getAsJsonObject();

            User[] users;
            users = gson.fromJson(obj.get("users"), User[].class);
            User.loadAll();

            Response response = new Response();
            response.setUsers(users);
            //String jsonString = gson.toJson(User.getUser(6));
            //String jjCool = gson.toJson(User.getAllUser());

            //System.out.println(jsonString);
            //System.out.println(jjCool);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void getPost() {
        Gson gson = new Gson();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("src/data.jason"));
            JsonParser jsonParser = new JsonParser();
            JsonObject obj = jsonParser.parse(br).getAsJsonObject();

            Post[] posts;
            posts = gson.fromJson(obj.get("posts"), Post[].class);
            Post.loadAll();

            Response response = new Response();
            response.setPosts(posts);

        } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}
