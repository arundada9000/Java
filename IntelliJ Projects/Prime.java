import java.util.Scanner;

public class Prime {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean isPrime = true;
        System.out.print("Enter a number to check : ");
        int num = sc.nextInt();
        if (num <= 1) {
            isPrime = false;
        }

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            System.out.println(num + " is a prime number.");
        }else{
            System.out.println(num + " is a composite number.");
        }
    }
}
