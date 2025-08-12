import java.util.Scanner;
public class Inclass {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x ,y;
        System.out.print("Enter value of x : ");
        x = sc.nextInt();
        System.out.print("Enter value of y : ");
        y = sc.nextInt();
        int sum = x+y;
        System.out.printf("%d + %d = %d ",x,y, sum);
    }
}
