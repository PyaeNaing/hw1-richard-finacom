package simpleserver;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class User extends Processor implements DataInterface {
    private int userid;
    private String username;
    private static Map<Integer, User> useridDict = new HashMap<>();
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(int userId, String username) {
        this.userid = userId;
        this.username = username;
        allUsers.add(this);
        useridDict.put(userid, this);
    }

    public User() {
        allUsers.add(this);
    }

    public String process() {
        return null;
    }

    public int getId() {
        return userid;
    }

    public String getData() {
        return username;
    }

    public String convertToJson() {
        return new Gson().toJson(this);
    }

    public void setUsername(String username) {
        this.username = username;
        System.out.println(username);
    }

    public void register() {
        useridDict.put(userid, this);
    }

    public static void loadAll() {
        for (int i = 0; i < allUsers.size(); i++) {
            allUsers.get(i).register();
        }
    }

    public static User getUser(int userid) {
        return useridDict.get(userid);
    }

    public void setUserid(int userid) {
        this.userid = userid;
        System.out.println(userid);
    }


    public static ArrayList<User> getAllUser() { return allUsers; }
}