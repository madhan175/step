package Palindrome;

import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println(" Welcome to the Palindrome Checker Management System");
        System.out.println(" Version : 1");
        System.out.println(" System initialized successfully");
        System.out.println("----------------------------------------");

        checkPalindrome("radar");
        checkPalindrome("madam");
        checkPalindrome("noon");
        checkPalindrome("hello");

        System.out.println("----------------------------------------");
        System.out.println("Program exited successfully.");
    }

    public static void checkPalindrome(String input) {

        // Create a stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character of the input string into the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Iterate again through the input string
        for (char c : input.toCharArray()) {
            // Pop character from stack and compare
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
        System.out.println();
    }
}
