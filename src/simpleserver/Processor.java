package simpleserver;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Processor {

    public Processor(){}
    public int getId(){return 0;}

    public String getData() {return null;}

    public String convertToJson() {return null;}

    public static Response response(Request rq, Database data) {return null;}

}

class ProcessorFactory {

    public static String makeProcessor(String request, Request rq, Database data) {
        if(!(rq.getValid())) {
            return (new Response("Error")).convertToJson();
        }
        switch (request) {
            case "users":
                return UserProcess.response(rq, data).convertToJson();
            case "posts":
                return PostProcess.response(rq, data).convertToJson();
        }
        return  null;
    }
}

