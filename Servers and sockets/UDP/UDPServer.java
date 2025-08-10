import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(9876)) { // Server listening on port 9876
            byte[] receiveData = new byte[1024];
            System.out.println("UDP Server is listening on port 9876...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket); // Receive a packet from the client
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client says: " + message);
                if (message.toLowerCase().equals("stop")) {
                    break;
                }

                // Respond to the client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String response = "Server received: " + message;
                DatagramPacket sendPacket = new DatagramPacket(response.getBytes(), response.length(), clientAddress,
                        clientPort);
                serverSocket.send(sendPacket); // Send response back
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
