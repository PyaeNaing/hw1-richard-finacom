package simpleserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class SimpleServer2 {

    public static void main(String[] args) throws IOException {
        ServerSocket ding;
        Socket dong = null;
        String resource = null;
        try {
            ding = new ServerSocket(1299);
            System.out.println("Opened socket " + 1299);
            while (true) {
                // keeps listening for new clients, one at a time
                int count = 0;
                boolean test = true;
                String use = "abc";
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
                    System.out.println(line);
                    // read only headers
                    line = in.readLine();
                    while (line != null && line.trim().length() > 0) {
                        System.out.println(test);
                        int index = line.indexOf(": ");
                        if (index > 0) {
                            System.out.println(line);
                            if (count == 6) {
                                String array1[] = line.split("/");
                                for (String temp : array1) {
                                    System.out.println(temp);
                                    test = temp.equals("hello");
                                    System.out.println(test);
                                    if (test == true) {
                                        use = temp;
                                        break;
                                    }
                                }
                            }
                            count++;
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
                writer.println("Content-type: text/html");
                writer.println("");

                // Body of our response
                System.out.println(count);
                writer.println(test);
                System.out.println(test);
                System.out.println(use);
                if (!use.equals("hello")) {
                    writer.println(use);
                    writer.println(test);
                    writer.println(count);
                    writer.println("<h1>Hi</h1>");
                }
                writer.println("<h2>Some cool response!</h2>");

                dong.close();
            }
        } catch (IOException e) {
            System.out.println("Error opening socket");
            System.exit(1);
        }
    }
}
