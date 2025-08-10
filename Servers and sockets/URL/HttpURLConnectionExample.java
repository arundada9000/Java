import java.net.*;
import java.io.*;

public class HttpURLConnectionExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method (GET, POST, etc.)
            connection.setRequestMethod("GET");

            // Set request headers
            connection.setRequestProperty("Accept", "text/html");

            // Get the response code (e.g., 200 OK)
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line); // Print the content of the web page
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
