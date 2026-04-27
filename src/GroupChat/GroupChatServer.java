package GroupChat;

import KnockKnock.KnockKnockProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GroupChatServer {
    public static void main(String[] args) {

//        int portNumber = Integer.parseInt(args[0]);
//
//        try (
//                ServerSocket serverSocket = new ServerSocket(portNumber);
//                Socket clientSocket = serverSocket.accept();
//                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//        ) {
//            String inputLine, outputLine;
//
//            KnockKnockProtocol kkp = new KnockKnockProtocol();
//            outputLine = kkp.processInput(null);
//            out.println(outputLine);
//
//            while ((inputLine = in.readLine()) != null) {
//                outputLine = kkp.processInput(inputLine);
//                out.println(outputLine);
//                if (outputLine.equals("Bye."))
//                    break;
//            }
//        } catch (IOException e) {
//            IO.println("u suck");
//        }
        int portNumber = Integer.parseInt(args[0]);
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String input
        }


    }
}
