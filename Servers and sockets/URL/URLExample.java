import java.net.*;
import java.io.*;

public class URLExample {
    public static void main(String[] args) {
        try {
            // Create a URL object for the website
            URL url = new URL("https://youtube.com");

            // Open a connection to the URL
            URLConnection connection = url.openConnection();

            // Get the input stream from the URL connection (read content)
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line of the webpage
            }

            reader.close(); // Close the reader when done
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
