import java.util.Scanner;

public class excel_column_to_number {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int result = 0;
        System.out.print("Enter a string : ");
        String input = sc.nextLine().toUpperCase();
        for(char ch: input.toCharArray()){
            result = result * 26 + (int) ch - 64;
        }
        System.out.println(result);
    }
}
