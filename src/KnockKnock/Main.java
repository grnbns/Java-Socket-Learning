package KnockKnock;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    void main(String[] args) {

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String userInput;
            System.out.println("Client connected. Type a message: ");
            while ((userInput = in.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + stdIn.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}
