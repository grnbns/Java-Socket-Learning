package GroupChat;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GCMultiServer {

    public static List<PrintWriter> writerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java KKMultiServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            int i = 1;
            while (listening) {
                GCMultiServerThread thread = new GCMultiServerThread(serverSocket.accept(), i);
                // writerList.add(thread.out);
                thread.start();
                i++;
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }

    public static void broadcast(String message) {
        for (PrintWriter writer : writerList) {
            writer.println(message);
        }
    }
}