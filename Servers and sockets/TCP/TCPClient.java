import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) { // Connect to server on port 1234
            // Create input/output streams
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message;
            while (true) {
                System.out.print("Enter message to send to server: ");
                message = userInput.readLine();
                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }
                output.println(message); // Send message to server
                System.out.println("Server response: " + input.readLine()); // Read and print server response
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
