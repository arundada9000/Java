public class primes {
    public static void main(String[] args) {
        int counter = 0;
        int num = 2;
        boolean isPrime = true;
        System.out.println("The first 50 prime numbers are: ");
        
        while (counter < 50) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                counter++;
                System.out.println(num + ",");
            }
            num++;
            isPrime = true;
        }
    }
}