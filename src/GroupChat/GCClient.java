//package KnockKnock;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class KnockKnockClient {
//    public static void main(String[] args) {
//        String hostName = args[0];
//        int portNumber = Integer.parseInt(args[1]);
//
//        try (
//                Socket kkSocket = new Socket(hostName, portNumber);
//                PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
//                BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
//                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
//        ) {
//            String fromServer, fromUser;
//            while ((fromServer = in.readLine()) != null) {
//                System.out.println("Server: " + fromServer);
//                if (fromServer.equals("Bye.")) break;
//
//                fromUser = stdIn.readLine();
//                if (fromUser != null) {
//                    System.out.println("Client " + fromUser);
//                    out.println(fromUser);
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("u suck again");
//        }
//    }
//}


package GroupChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GCClient {
    public static void main(String[] args) {
        String hostName = args[0];
            int portNumber = Integer.parseInt(args[1]);

            try (
                    Socket gcSocket = new Socket(hostName, portNumber);
                    PrintWriter out = new PrintWriter(gcSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(gcSocket.getInputStream()));
                    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            ) {
                System.out.println("Successfully connected!");
                String fromServer, fromUser;
                while ((fromServer = in.readLine()) != null) {
                    System.out.println(fromServer);

                    fromUser = stdIn.readLine();
                    if (fromUser != null) {
                        out.println(fromUser);
                    }
                }
            } catch (IOException e) {
                System.out.println("u suck");
            }
    }
}
