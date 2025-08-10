import java.io.*;
import java.util.StringTokenizer;

public class VowelWordCopier {
    public static void main(String[] args) {
        try {
            // Step 1: Open input file
            BufferedReader reader = new BufferedReader(new FileReader("ONE.TXT"));

            // Step 2: Open output file
            BufferedWriter writer = new BufferedWriter(new FileWriter("TWO.TXT"));

            String line;
            while ((line = reader.readLine()) != null) {
                // Split line into words
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    char firstChar = Character.toLowerCase(word.charAt(0));
                    if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' ||
                        firstChar == 'o' || firstChar == 'u') {
                        writer.write(word + " ");
                    }
                }
            }

            // Step 3: Close everything
            reader.close();
            writer.close();

            System.out.println("Words starting with vowels have been copied to TWO.TXT");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
