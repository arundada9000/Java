import java.util.Scanner;

public class arrayAge {
    public static void main(String[] args) {
        int[] age = new int[10];
        int sum = 0;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of person " + (i + 1) + ": ");
            age[i] = sc.nextInt();
            sum += age[i];
        }
        int average = sum / 10;
        System.out.println("The average age is: " + average + " years old.");

        System.out.println("The ages of the people between 25 and 30 are : ");
        for (int i = 0; i < 10; i++) {
            if (age[i] >= 25 && age[i] <= 30) {
                System.out.println(age[i] + " years old.");
            }

        }
        sc.close();
    }
}
