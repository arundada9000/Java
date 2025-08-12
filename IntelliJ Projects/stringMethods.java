public class stringMethods {
    public static void main(String[] args) {
        String name = "Anonanona";
        System.out.printf("Hello %s",name);
        System.out.printf("\nReversed name is : %s",reverseString(name));
        System.out.printf("\nIs palindrome : %s",isPalindrome(name));
        int counter =0;
        char[] nameArray = name.toCharArray();
        for(char c : nameArray){
            counter++;
        }
        System.out.println("\nCounter : "+counter);
    }
    public static String reverseString(String str){
        String newStr = "";
        for(int i = str.length()-1; i >= 0; i--){
            newStr += str.charAt(i);
        }
        return newStr;
    }
    public static boolean isPalindrome(String str){
        return str.equalsIgnoreCase(reverseString(str));
    }
}
