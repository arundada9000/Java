import java.io.*;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int count = 0;

        try {
            FileReader fr = new FileReader("magic.txt");
            Scanner sc = new Scanner(fr);

            for (int i = 0; i < 3 && sc.hasNextLine(); i++) {
                String line = sc.nextLine();
                String[] numbers = line.trim().split("\\s+");

                for (int j = 0; j < 3 && j < numbers.length; j++) {
                    matrix[i][j] = Integer.parseInt(numbers[j]);
                    count++;
                }
            }

            sc.close();

            // Check if we read exactly 9 numbers
            if (count != 9) {
                System.out.println("File does not contain 9 integers.");
                return;
            }

            // Calculate the target sum (sum of first row)
            int targetSum = matrix[0][0] + matrix[0][1] + matrix[0][2];

            boolean isMagic = true;

            // Check all rows
            for (int i = 0; i < 3; i++) {
                int rowSum = 0;
                for (int j = 0; j < 3; j++) {
                    rowSum += matrix[i][j];
                }
                if (rowSum != targetSum) {
                    isMagic = false;
                    break;
                }
            }

            // Check all columns
            if (isMagic) {
                for (int j = 0; j < 3; j++) {
                    int colSum = 0;
                    for (int i = 0; i < 3; i++) {
                        colSum += matrix[i][j];
                    }
                    if (colSum != targetSum) {
                        isMagic = false;
                        break;
                    }
                }
            }

            // Check main diagonal
            if (isMagic) {
                int diag1 = matrix[0][0] + matrix[1][1] + matrix[2][2];
                if (diag1 != targetSum) {
                    isMagic = false;
                }
            }

            // Check other diagonal
            if (isMagic) {
                int diag2 = matrix[0][2] + matrix[1][1] + matrix[2][0];
                if (diag2 != targetSum) {
                    isMagic = false;
                }
            }

            // Final result
            if (isMagic) {
                System.out.println("It is a magic square.");
            } else {
                System.out.println("It is NOT a magic square.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not read file.");
            e.printStackTrace();
        }
    }
}
