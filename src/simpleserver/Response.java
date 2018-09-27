package simpleserver;

import com.google.gson.*;
import java.util.*;

public class Response {
    private String status;
    private int entries;
    private List<Processor> data;
    private User[] users;

    public Response() {
        this.status = null;
        this.entries = -1;
    }

    public Response(String nStatus, int nEntries, List<Processor> nData) {
        this.status = nStatus;
        this.entries = nEntries;
        this.data = nData;
    }

    String convertToJson() {
        return new Gson().toJson(this);
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    public void setEntries(int newEntries) {
        this.entries = newEntries;
    }

    public void setData(List<Processor> newData) {
        this.data = newData;
    }

    public void setStatus(Request req) {
        if (req.getValid()) {
            this.status = "OK";
        } else {
            this.status = "ERROR";
        }

    }

    public void setUsers(User[] users){
        this.users = users;
    }
}
