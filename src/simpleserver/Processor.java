package simpleserver;

public class Processor {

    public Processor(){}

    public Processor(String request) {
        ProcessorFactory.makeProcessor(request);
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

