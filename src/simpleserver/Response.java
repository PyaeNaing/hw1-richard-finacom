package simpleserver;

import com.google.gson.*;

public class Response {
    String status;
    int entries;
    DataInterface data;

    String convertToJson() {
        return new Gson().toJson(this);
    }

}
