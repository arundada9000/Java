import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendData;

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while (true) {
                System.out.print("Enter message to send to server: ");
                message = userInput.readLine();
                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }
                sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
                clientSocket.send(sendPacket);  // Send the packet to server

                // Receive the server response
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);  // Receive response from server
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server response: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
