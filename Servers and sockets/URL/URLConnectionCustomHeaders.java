import java.net.*;
import java.io.*;

public class URLConnectionCustomHeaders {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com");

            // Open a connection to the URL
            URLConnection connection = url.openConnection();

            // Set a custom header (for example, user-agent)
            connection.setRequestProperty("User-Agent", "Java HTTP Client");

            // Open input stream and read response
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
