import java.io.*;
import java.net.*;
import java.util.Scanner;

public class GreatestClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port)) {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);

            // Get input from user
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            // Send the numbers to server
            dos.writeInt(num1);
            dos.writeInt(num2);

            // Receive the greatest number
            int greatest = dis.readInt();
            System.out.println("The greatest number is: " + greatest);

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
