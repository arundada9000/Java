import java.io.*;
import java.net.*;

public class TCPFileServer {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("Server is waiting for file...");

        try (ServerSocket serverSocket = new ServerSocket(PORT);
                Socket socket = serverSocket.accept()) {

            // Create input stream to receive file
            try (InputStream in = socket.getInputStream();
                    FileOutputStream fileOut = new FileOutputStream("received_file.txt")) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    fileOut.write(buffer, 0, bytesRead);
                }

                System.out.println("File received successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
