package Sockets;
import java.io.*;
import java.net.*;

public class chatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(SERVER_ADDRESS, PORT);
        System.out.println("Connected to the chat server.");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        new Thread(new Receiver(socket)).start();

        String message;
        while ((message = reader.readLine()) != null) {
            writer.println(message);
        }

        socket.close();
    }

    private static class Receiver implements Runnable {
        private Socket socket;

        public Receiver(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
