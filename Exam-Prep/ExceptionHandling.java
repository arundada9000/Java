import java.util.Scanner;
import java.util.*;

class ExceptionHandling {
    public static void main(String args[]) {
        int array[] = { 1, 2 };
        try {
            System.out.println(array[3]);
        } catch (Exception e) {
            System.out.println("Exception !!! " + e);
        }
        System.out.println("Program ended.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word or line : ");
        String s = sc.nextLine();
        System.out.println("You entered " + s);

        Validate v = new Validate();
        v.validate(19);
        sc.close();
    }
}

class Validate {
    public void validate(int age) {
        try {
            if (age < 18) {
                throw new Exception("Invalid Age");
            } else {
                System.out.println("Valid Age.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Program ended.");
    }
}