import java.io.*;
import java.util.*;

public class onefiletoanother {
    public static void main(String[] args) {
        File myfile = new File("one.txt");
        if (!myfile.exists()) {
            System.out.println("File one.txt does not exist");
            try {
                myfile.createNewFile();
                System.out.println("File one.txt created successfully.");
            } catch (Exception e) {
                System.out.println("Problem occurred while creating one.txt file : " + e);
            }
        } else {
            System.out.println("File one.txt exists.");
        }

        myfile = new File("two.txt");
        if (myfile.exists()) {
            System.out.println("File two.txt exists");
        } else {
            System.out.println("File two.txt does not exist");
            try {
                myfile.createNewFile();
                System.out.println("File two.txt created successfully.");
            } catch (Exception e) {
                System.out.println("Problem occurred while creating two.txt : " + e);
            }
        }

        String data = "";
        try {
            FileReader fr = new FileReader("one.txt");
            Scanner sc = new Scanner(fr);
            while (sc.hasNextLine()) {
                data = data.concat(sc.nextLine());
                data = data.concat("\n");
            }
            System.out.println("Successfully read data from one.txt.");
            // System.out.println(data);
            sc.close();
        } catch (Exception e) {
            System.out.println("Problem occurred while reading data from one.txt : " + e);
        }
        try {
            FileWriter fw = new FileWriter("two.txt");
            fw.write(data);
            System.out.println("Successfully wrote data into two.txt");
            fw.close();
        } catch (Exception e) {
            System.out.println("Problem occurred while writing into two.txt : " + e);
        }
    }
}
