package Palindrome;

import java.util.Stack;

import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase3PalindromeCheckerApp {



        public static void main(String[] args) {

            System.out.println(" Welcome to the Palindrome Checker Management System");
            System.out.println(" Combined Version : Stack + Deque");
            System.out.println(" System initialized successfully");
            System.out.println("--------------------------------------------------");

            System.out.println("UC3 - Stack Based Palindrome Check");
            checkPalindromeUsingStack("radar");
            checkPalindromeUsingStack("madam");
            checkPalindromeUsingStack("hello");



            System.out.println("UC7 - Deque Based Optimized Palindrome Check");
            checkPalindromeUsingDeque("refer");
            checkPalindromeUsingDeque("level");
            checkPalindromeUsingDeque("world");

            System.out.println("--------------------------------------------------");
            System.out.println("Program exited successfully.");
        }


        //  Stack Based Implementation

        public static void checkPalindromeUsingStack(String input) {

            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray()) {
                stack.push(c);
            }

            boolean isPalindrome = true;

            for (char c : input.toCharArray()) {
                if (c != stack.pop()) {
                    isPalindrome = false;
                    break;
                }
            }

            System.out.println("Input : " + input);
            System.out.println("Is Palindrome? : " + isPalindrome);
            System.out.println();
        }

        //  - Deque Based Implementation

        public static void checkPalindromeUsingDeque(String input) {

            Deque<Character> deque = new ArrayDeque<>();

            for (char c : input.toCharArray()) {
                deque.addLast(c);
            }

            boolean isPalindrome = true;

            while (deque.size() > 1) {

                char front = deque.removeFirst();
                char rear = deque.removeLast();

                if (front != rear) {
                    isPalindrome = false;
                    break;
                }
            }

            System.out.println("Input : " + input);
            System.out.println("Is Palindrome? : " + isPalindrome);
            System.out.println();
        }
    }
