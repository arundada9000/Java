import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Can you guess it?");

        do {
            int number = (int) (Math.random() * 100) + 1;
            int guess = 0;
            int attempts = 0;
            while (guess != number) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else if (guess > number) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println(
                            "Congratulations! You've guessed the number " + number + " in " + attempts + " attempts.");
                }
            }
            System.out.println("Do you want to play again? (1 for Yes, 2 for No)");
            choice = scanner.nextInt();
            while(true)
            {
                if (choice == 1) {
                    System.out.println("<----------New Game--------->");
                    break;
                }
                else if(choice == 2){
                    break;
                }
                else{
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    choice = scanner.nextInt();
                }
            }
        } while (choice != 2);

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }
}
// Turn switch on or off