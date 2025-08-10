import java.util.Scanner;

public class ArithmeticMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. ADD");
            System.out.println("2. SUBTRACT");
            System.out.println("3. EXIT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 1 || choice == 2) {
                System.out.print("Enter first number: ");
                int num1 = scanner.nextInt();
                System.out.print("Enter second number: ");
                int num2 = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("Sum: " + (num1 + num2));
                } else {
                    System.out.println("Difference: " + (num1 - num2));
                }
            } else if (choice == 3) {
                System.out.println("Exiting...");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 3);

        scanner.close();
    }
}
