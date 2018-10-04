package simpleserver;

public class Processor {

    public Processor(){}

    public int getId(){return 0;}

    public String getData() {return null;}

    public String convertToJson() {return null;}

    public static String response(String request, Database data)
    {
        Request r = new Request(request);
        return ProcessorFactory.makeProcessor(r, data);
    }
    public static String badRequest() {return (new Response("Error")).convertToJson();}
}

class ProcessorFactory {

    public static String makeProcessor(Request rq, Database data) {
        if(!(rq.getValid())) {
            return (new Response("Error")).convertToJson();
        }
        switch (rq.getEndpoint()) {
                case "user":
                    return UserProcess.response(rq, data).convertToJson();
                case "posts":
                    return PostProcess.response(rq, data).convertToJson();
        }
        return  null;
    }
}

