import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) { // Create server socket on port 1234
            System.out.println("Server is listening on port 1234...");

            // Accept client connections
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress());

            // Create input/output streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = input.readLine()) != null) {
                System.out.println("Client says: " + clientMessage);
                output.println("Server received: " + clientMessage); // Send response back to client
            }

            socket.close(); // Close the socket when done
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
