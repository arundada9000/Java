import java.util.*;

public class newFile {
    public static void main(String[] args) {
        int[] array;
        array = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your array");
        for (int i = 0; i <= 9; i++) {
            array[i] = sc.nextInt();
        }

        sc.close();
        System.out.println("Your array is : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

}
