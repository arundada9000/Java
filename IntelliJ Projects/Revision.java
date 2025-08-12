import java.util.Scanner;
public class Revision {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(Add(5,7));
//        System.out.print("Enter your Name : ");
//        String name = sc.nextLine();
//        System.out.print("Enter your age : ");
//        int age = sc.nextInt();
//        System.out.print("Enter your gayness : ");
//        boolean isGay = sc.nextBoolean();
//        System.out.print("Enter your grade : ");
//        char grade = sc.next().charAt(0);
//        System.out.print("Enter your salary : ");
//        double salary = sc.nextDouble();
//
//        System.out.println("Name : "+name+"\nAge : "+ age + "\nSalary : " + salary + "\nisGay : "+ isGay + "\nGrade : " + grade);
//        if(salary>1000){
//            System.out.println("Rich kid " + salary);
//        }else{
//            System.out.println("Poor kid " + salary);
//        }
    }
    public static int Add(int a, int b){
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                System.out.print(i + "-" + j + " ");
            }
            System.out.println(" ");
        }
        return a+b;
    }
}
