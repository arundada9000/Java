import java.util.Arrays;

public class ArrayMethods {
    public static void main(String args[]) {
        int array1[] = new int[5];
        Arrays.fill(array1, 100);
        for (int i : array1) {
            System.out.println(i);
        }
    }
}
