import java.util.Random;
import java.util.Scanner;

public class DiceRolling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfDice = 0;
        int sum = 0;
        while (numOfDice < 1) {
            System.out.println("Enter the number of dice: ");
            numOfDice = sc.nextInt();
            if (numOfDice < 1) {
                System.out.println("Please enter a positive number : ");
            }
        }
        for (int i = 0; i < numOfDice; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(1, 7);
            sum += randomNumber;
            showDice(randomNumber);
        }
        System.out.println("Total : " + sum );
        sc.close();
    }

    static void showDice(int randomNumber) {
        String dice = switch (randomNumber) {
            case 1 -> """
                     -------
                    |       |
                    |   ●   |
                    |       |
                     -------
                    """;
            case 2 -> """
                     -------
                    |       |
                    |  ● ●  |
                    |       |
                     -------
                    """;
            case 3 -> """
                     -------
                    |●      |
                    |   ●   |
                    |      ●|
                     -------
                    """;
            case 4 -> """
                     -------
                    |●     ●|
                    |       |
                    |●     ●|
                     -------
                    """;
            case 5 -> """
                     -------
                    |●     ●|
                    |   ●   |
                    |●     ●|
                     -------
                    """;
            case 6 -> """
                     -------
                    |●  ●  ●|
                    |       |
                    |●  ●  ●|
                     -------
                    """;
            default -> "";
        };
        System.out.println(dice);
    }
}
