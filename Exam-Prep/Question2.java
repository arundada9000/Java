
/*
 An array with an odd number of elements is said to be centered if all elements (except the middle one) are strictly greater than the value of the middle element. Note that only arrays with an odd number of elements have a middle element. Write a function that accepts an integer array and returns 1 if it is a centered array, otherwise it returns 0.
 */
public class Question2 {
    public static void main(String args[]) {
        int array[] = { 1, 0, 1 };
        Question2 q2 = new Question2();
        System.out.println(q2.checkCenteredArray(array));
    }

    int checkCenteredArray(int array[]) {
        if (array.length % 2 == 0) {
            return 0;
        }
        int center = array.length / 2;
        int centerElement = array[center];
        for (int i = 0; i < array.length; i++) {
            if (i != center && array[i] <= centerElement) {
                return 0;
            }
        }
        return 1;
    }
}
