public class pattern {
    public static void main(String[] args) {
        int a = 1, b = 1;
        for (int i = 1; i <= 25; i++) {
            a++;
            b += 2;

            if (i == 7) {
                continue;
            }
            System.out.println(i + ". " + a + " X " + b);

        }
    }

}
