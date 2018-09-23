package simpleserver;

import com.google.gson.*;

public class Response {
   private String status;
    private int entries;
    private DataInterface[] data;

    String convertToJson() {
        return new Gson().toJson(this);
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    public void setEntries(int newEntries) {
        this.entries = newEntries;
    }

    public void setData(DataInterface[] newData) {
        this.data = newData;
    }

    public void setStatus(Request req) {
        if (req.getValid()) {
            this.status = "OK";
        } else {
            this.status = "ERROR";
        }

    }
}
