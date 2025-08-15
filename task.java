public class task {
    public static void main(String[] args) {
        
        
        // int[] arr = new int[] { 1, 3, 2, 5, 8, 7, 9 };
        // System.out.println("Largest number in the array is : " + Largest(arr));
        // System.out.println("Smallest number in the array is : " + Smallest(arr));
        
    }

    public static int Largest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static int Smallest(int[] arr) {
        int small = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < small) {
                small = arr[i];
            }
        }
        return small;
    }
}
