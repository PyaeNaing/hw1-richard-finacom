package simpleserver;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.String;

class SimpleServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ding;
        Socket dong = null;
        //String resource = null;
        try {
            ding = new ServerSocket(1299);
            System.out.println("Opened socket " + 1299);
            Database database = Database.getInstance();
<<<<<<< HEAD
=======
            Request rq = null;
            String printer = null;
>>>>>>> 957be8ba7c65061c8464317f1e8f7af9a496c2ee
            while (true) {

                String parceString[];
                String request = null;
                // keeps listening for new clients, one at a time
                try {
                    dong = ding.accept(); // waits for client here
                } catch (IOException e) {
                    System.out.println("Error opening socket");
                    System.exit(1);
                }

                InputStream stream = dong.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                try {

                    // read the first line to get the request method, URI and HTTP version
                    String line = in.readLine();

                    System.out.println("----------REQUEST START---------");

                    //Cut string here
                    parceString = line.split(" ");
                    //Taking only the necessary URL;
                    request = parceString[1].substring(1);
                    rq = new Request(request);
                    printer = ProcessorFactory.makeProcessor(rq, database);

                    System.out.println(line);
                    // read only headers
                    line = in.readLine();
                    while (line != null && line.trim().length() > 0) {
                        int index = line.indexOf(": ");
                        if (index > 0) {
                            System.out.println(line);
                        } else {
                            break;
                        }
                        line = in.readLine();
                    }
                    System.out.println("----------REQUEST END---------\n\n");
                } catch (IOException e) {
                    System.out.println("Error reading");
                    System.exit(1);
                }

                BufferedOutputStream out = new BufferedOutputStream(dong.getOutputStream());
                PrintWriter writer = new PrintWriter(out, true);  // char output to the client

                // every response will always have the status-line, date, and server name
                writer.println("HTTP/1.1 200 OK");
                writer.println("Server: TEST");
                writer.println("Connection: close");
<<<<<<< HEAD
                writer.println("Content-type: application/json");
                writer.println("");

                // Body of our response
                Processor r = new Processor();
                writer.println(r.response(request,database));
=======
                writer.println("Content-type: json/html");
                writer.println("");

                // Body of our response
                    writer.println(printer);
                if (request.equals("hello"))
                    writer.println("<h1>Hello World</h1>");
                else
                writer.println("<h1>Try sending \"hello\" request </h1>");
>>>>>>> 957be8ba7c65061c8464317f1e8f7af9a496c2ee

                dong.close();
            }
        } catch (IOException e) {
            System.out.println("Error opening socket");
            System.exit(1);
        }
    }
}