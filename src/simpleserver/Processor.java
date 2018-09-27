package simpleserver;

public class Processor {

    public Processor(){}

    public Processor(String request) {
        ProcessorFactory.makeProcessor(request);
    }

    public static String startResponse(Request request) {
        Response ret = new Response();
        DataInterface process;
        if(request.getValid()) {
            if (request.getLength() != -1) {

            } else {
                if(!(request.getReturnall())) {
                    //get user by id number
                    //ret: Status = OK, Entries = 1, data = user
                    ret.setStatus(request);
                    ret.setEntries(1);
                } else {
                    //add all user into an arrayList
                }
            }
            return ret.convertToJson();
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

