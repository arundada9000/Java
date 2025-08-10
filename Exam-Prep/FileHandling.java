import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {

    private Scanner sc;

    public FileHandling(Scanner scanner) {
        this.sc = scanner;
    }

    boolean checkFileExists(String userFile) {
        File myFile = new File(userFile);
        return myFile.exists();
    }

    void createAFile() {
        System.out.print("Enter a file name: ");
        String userFile = sc.nextLine();
        File myFile = new File(userFile);

        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
                System.out.println("File created successfully.");
            } catch (IOException e) {
                System.out.println("Could not create file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists.");
        }
    }

    void writeIntoFile() {
        System.out.print("Enter the file you want to write data into: ");
        String userFile = sc.nextLine();

        if (checkFileExists(userFile)) {
            System.out.println("Enter a sentence to write into the file:");
            String sentence = sc.nextLine();

            try {
                // Append mode set to true
                FileWriter fw = new FileWriter(userFile, true);
                fw.write(sentence + System.lineSeparator());
                fw.close();
                System.out.println("Successfully wrote into file.");
            } catch (IOException e) {
                System.out.println("Could not write to file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist.");
        }
    }

    void readDataFromFile() {
        System.out.print("Enter the file you want to read data from: ");
        String userFile = sc.nextLine();

        if (checkFileExists(userFile)) {
            try {
                FileReader fr = new FileReader(userFile);
                Scanner fileScanner = new Scanner(fr);
                System.out.println("Contents of file:");

                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }

                fileScanner.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("Could not read from file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist.");
        }
    }

    void checkFileExistsMethod() {
        System.out.print("Enter file name: ");
        String userFile = sc.nextLine();

        if (checkFileExists(userFile)) {
            System.out.println("File exists.");
        } else {
            System.out.println("File does not exist.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandling fh = new FileHandling(scanner);

        int choice;
        do {
            System.out.println("\nEnter your choice:");
            System.out.print(
                    "1. Create a file\n" +
                            "2. Write into a file\n" +
                            "3. Read from a file\n" +
                            "4. Check if file exists\n" +
                            "5. Exit\n" +
                            "Your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next(); // discard invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    fh.createAFile();
                    break;
                case 2:
                    fh.writeIntoFile();
                    break;
                case 3:
                    fh.readDataFromFile();
                    break;
                case 4:
                    fh.checkFileExistsMethod();
                    break;
                case 5:
                    System.out.println("Exited successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
