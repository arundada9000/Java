import java.io.*;
import java.net.*;

public class TCPChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            // Thread to read messages from server
            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Main loop to send messages to server
            String message;
            while (true) {
                message = userInput.readLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                out.println(message); // Send message to server
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
