import java.util.Scanner;
public class sumOfPrimes
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int num = 5;
        int value;
        while(num>0)
        {
            System.out.println("Please enter " + num + " prime numbers : ");
            value = sc.nextInt();
            if(value>1 )
            {
                boolean isPrime = true;
                for(int i=2; i<Math.sqrt(value); i++)
                {
                    if(value%i==0){
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime)
                {
                    sum += value;
                    num--;
                }
                else{
                    System.out.println("Please enter a prime number : ");
                }
            }
        }
        System.out.println("The sum of the prime numbers is : " + sum);
        sc.close();
    }
}
