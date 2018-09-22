package simpleserver;

class User implements DataInterface {
    private int userid;
    private String username;

    public int getId() {
        return userid;
    }

    public String getData() {
        return username;
    }
}