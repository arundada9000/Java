import java.util.Scanner;

public class BankingProgram {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double balance = 0.00;
        int choice;
        boolean isRunning = true;
        boolean validChoice = true;
        while (isRunning) {
            System.out.println("--------Banking Program------");
            System.out.println("Enter your Choice : ");
            System.out.println("1.Show Balance");
            System.out.println("2.Withdraw");
            System.out.println("3.Deposit");
            System.out.println("4.Exit");

            do {
                choice = sc.nextInt();
                switch (choice) {
                    case 1 -> System.out.printf("Your Balance is: %.2f\n", balance);
                    case 2 -> {
                        double withdrawnBalance = withdraw(balance);
                        balance -= withdrawnBalance;
                    }
                    case 3 -> {
                        double depositedAmount = deposit();
                        balance += depositedAmount;
                    }
                    case 4 -> isRunning = false;
                    default -> {
                        System.out.println("Invalid Choice! Please try again");
                        validChoice = false;
                    }
                }
            } while (!validChoice);
        }

        System.out.println("Thank you for using our banking services!");
        sc.close();
    }

    public static double withdraw(double balance) {
        if (balance <= 0) {
            System.out.println("Your account is empty!");
            return 0;
        }
        System.out.println("Enter the amount to withdraw: ");
        while (true) {
            double amount = sc.nextDouble();

            if (amount > balance) {
                System.out.println("Insufficient Balance! Please try again");
            } else if (amount <= 0) {
                System.out.println("Invalid Amount! Please try again");
            } else {
                System.out.println("Amount withdrawn successfully: " + amount);
                return amount;
            }
        }
    }

    static double deposit() {
        while (true) {
            System.out.println("Enter the amount to deposit: ");
            double depositedAmount = sc.nextDouble();
            if (depositedAmount <= 0) {
                System.out.println("Invalid Amount! Please try again");
            } else {
                System.out.println("Amount deposited successfully: " + depositedAmount);
                return depositedAmount;
            }
        }
    }
}
