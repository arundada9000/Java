import java.io.*;
import java.net.*;

public class GreatestServer {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read two integers from client
            int num1 = dis.readInt();
            int num2 = dis.readInt();
            System.out.println("Received: " + num1 + " and " + num2);

            // Find the greatest number
            int greatest = Math.max(num1, num2);

            // Send result back to client
            dos.writeInt(greatest);
            System.out.println("Sent greatest: " + greatest);

            // Close connections
            dis.close();
            dos.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
