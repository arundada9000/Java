import java.net.*;
import java.io.*;

public class URLConnectionPOSTExample {
    public static void main(String[] args) {
        try {
            // URL to which data will be sent
            URL url = new URL("https://facebook.com/submit");

            // Open connection to the URL
            URLConnection connection = url.openConnection();

            // Set the connection for output (sending data)
            connection.setDoOutput(true);

            // Send data using OutputStreamWriter
            try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
                String data = "username=arun&password=12345"; // Data to send (form fields)
                writer.write(data); // Write data to the server
                writer.flush(); // Ensure data is sent
            }

            // Read response from the server
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String response;
                while ((response = reader.readLine()) != null) {
                    System.out.println(response); // Print server's response
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
