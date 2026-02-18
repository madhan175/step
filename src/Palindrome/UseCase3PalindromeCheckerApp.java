package Palindrome;
public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println(" Welcome to the Palindrome Checker Management System");
        System.out.println(" Version : 1");
        System.out.println(" System initialized successfully");
                         System.out.println("----------------------------------------");

             checkPalindrome("radar");
        checkPalindrome("madam");

        System.out.println("----------------------------------------");
        System.out.println("Program exited successfully.");
    }

    public static void checkPalindrome(String input) {

                 char[] chars = input.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                           isPalindrome = false;
                break;
            }
                 start++;
            end--;
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
                  System.out.println();
    }
}
