package simpleserver;

public class Processor {

    public Processor(){}

    public Processor(String request) {
        ProcessorFactory.makeProcessor(request);
    }
    public static String startResponse(Request request) {
        Response ret;
        if(request.getValid()) {

            return null;
        } else {
            ret = new Response("Error", 0, null);
            return ret.convertToJson();
        }
    }
}

class ProcessorFactory {

    public static Processor makeProcessor(String request) {
        switch (request) {
            case "users":
                return new User(request);
            case "posts":
                return new Post(request);
        }
        return null;
    }
}

