import java.util.Scanner;

public class Vowel {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word : ");
        String word = sc.nextLine().toLowerCase();
        int vowelCount = 0;
        for (char ch : word.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vowelCount++;
            }
        }
        System.out.println("Total vowels in " + word +" = " + vowelCount);
    }
}
