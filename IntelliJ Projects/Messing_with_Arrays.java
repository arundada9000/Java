import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;

public class Messing_with_Arrays {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the size of array : ");
//        int size = sc.nextInt();
//        int[] numbers = new int[size];
//        for(int i=0; i<size; i++){
//            System.out.print("Enter "+ (i+1) + "th number : ");
//            numbers[i] = sc.nextInt();
//        }
//        System.out.print("Even numbers: ");
//        for(int num : numbers){
//            if(num%2==0){
//                System.out.print(num + " ");
//            }
//        }
        int[] arr = {1,2,3,6,9,5,8,12,91,87,65};
        System.out.print("Max element : " + max_in_array(arr));
        System.out.print("\nCount => ");
        count_odds_and_evens(arr);
        System.out.print("Sorted array : ");
        Arrays.sort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }

    }

    public static int max_in_array(int[] arr){
        int max = arr[0];
        for (int j : arr) {
            if (max < j) {
                max = j;
            }
        }
        return max;
    }
    public static void count_odds_and_evens(int[] arr){
        int odd = 0;
        int even = 0;
        for(int i: arr){
            if(i%2==0){
                even++;
            }
            else{
                odd++;
            }
        }
        System.out.println("Odd : " + odd + " Even : " + even);
    }
}
