import java.util.Scanner;
public class rectangleArea {
    public static void main(String[] args) {
        double length,width,area;
        System.out.println("Enter the length of the rectangle: ");
        Scanner sc = new Scanner(System.in);
        length = sc.nextDouble();
        System.out.println("Enter the width of the rectangle: ");
        width = sc.nextDouble();
        area = length*width;
        System.out.println("The area of the rectangle is: "+area);
        sc.close();
    }
}
