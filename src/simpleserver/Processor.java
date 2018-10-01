package simpleserver;

public class Processor {

    public Processor(){}

    public int getId(){return 0;}

    public String getData() {return null;}

    public String convertToJson() {return null;}

    public static Response response(String request, Database data)
    {
        ProcessorFactory process = new ProcessorFactory();
        Request r = new Request(request);
        return process.makeProcessor(r, data);
    }
}

class ProcessorFactory {

    public static Response makeProcessor(Request rq, Database data) {
        if(!(rq.getValid())) {
            return (new Response("Error"));
        }
        switch (rq.getEndpoint()) {
            case "users":
                return UserProcess.response(rq, data);
            case "posts":
                return PostProcess.response(rq, data);
        }
        return  null;
    }
}

