package GroupChat;

import java.net.*;
import java.io.*;

public class GCMultiServerThread extends Thread {
    private Socket socket = null;
    public PrintWriter out = null;
    private int id = 0;

    public GCMultiServerThread(Socket socket, int id) {
        super("GCMultiServerThread");
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run() {

//        try (
//                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//                BufferedReader in = new BufferedReader(
//                        new InputStreamReader(
//                                socket.getInputStream()));
//        ) {
//            String inputLine, outputLine;
//            KnockKnockProtocol kkp = new KnockKnockProtocol();
//            outputLine = kkp.processInput(null);
//            out.println(outputLine);
//
//            while ((inputLine = in.readLine()) != null) {
//                outputLine = kkp.processInput(inputLine);
//                out.println(outputLine);
//                if (outputLine.equals("Bye"))
//                    break;
//            }
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            GCMultiServer.writerList.add(out);

            String inputLine, outputLine;

            while ((inputLine = in.readLine()) != null) {
                GCMultiServer.broadcast("Client " + id + ": " + inputLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}