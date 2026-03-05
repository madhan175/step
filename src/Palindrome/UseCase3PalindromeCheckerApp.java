import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class UseCase3PalindromeCheckerApp {

    // ===============================
    // Node class for UC9
    // ===============================
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node left;

    // ===============================
    // Strategy Interface (UC12)
    // ===============================
    interface PalindromeStrategy {
        boolean checkPalindrome(String input);
    }

    // ===============================
    // Stack Strategy
    // ===============================
    static class StackStrategy implements PalindromeStrategy {

        public boolean checkPalindrome(String input) {

            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray()) {
                stack.push(c);
            }

            for (char c : input.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // ===============================
    // Deque Strategy
    // ===============================
    static class DequeStrategy implements PalindromeStrategy {

        public boolean checkPalindrome(String input) {

            Deque<Character> deque = new ArrayDeque<>();

            for (char c : input.toCharArray()) {
                deque.addLast(c);
            }

            while (deque.size() > 1) {

                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }

    // ===============================
    // Palindrome Service (UC11)
    // ===============================
    static class PalindromeChecker {

        private PalindromeStrategy strategy;

        public PalindromeChecker(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean checkPalindrome(String input) {
            return strategy.checkPalindrome(input);
        }
    }

    // ===============================
    // MAIN METHOD
    // ===============================
    public static void main(String[] args) {

        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("UC9 - Recursion Based Palindrome Check");
        System.out.println("UC10 - Case-Insensitive & Space-Ignored Check");
        System.out.println("UC11 - Object-Oriented Palindrome Service");
        System.out.println("UC12 - Strategy Pattern Check");
        System.out.println("UC13 - Performance Comparison");
        System.out.println("--------------------------------------------------");

        // UC9
        checkPalindromeUsingRecursion("radar");
        checkPalindromeUsingRecursion("level");
        checkPalindromeUsingRecursion("hello");

        System.out.println("--------------------------------------------------");

        // UC10
        checkPalindromeIgnoreCase("Never Odd Or Even");
        checkPalindromeIgnoreCase("A man a plan a canal Panama");
        checkPalindromeIgnoreCase("Hello World");

        System.out.println("--------------------------------------------------");

        // UC11 & UC12
        PalindromeChecker checker = new PalindromeChecker(new StackStrategy());

        testPalindrome(checker, "madam");
        testPalindrome(checker, "racecar");
        testPalindrome(checker, "java");

        System.out.println("--------------------------------------------------");

        checker.setStrategy(new DequeStrategy());

        testPalindrome(checker, "radar");
        testPalindrome(checker, "level");
        testPalindrome(checker, "hello");

        System.out.println("--------------------------------------------------");

        // UC13 Performance Test
        performanceComparison("racecar");

        System.out.println("--------------------------------------------------");
        System.out.println("Program exited successfully.");
    }

    // ===============================
    // UC9 - Recursion Palindrome
    // ===============================

    public static void checkPalindromeUsingRecursion(String input) {

        Node head = buildLinkedList(input);

        left = head;

        boolean result = isPalindrome(head);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
        System.out.println();
    }

    public static boolean isPalindrome(Node right) {

        if (right == null) {
            return true;
        }

        boolean check = isPalindrome(right.next);

        if (!check) {
            return false;
        }

        boolean isEqual = (left.data == right.data);

        left = left.next;

        return isEqual;
    }

    public static Node buildLinkedList(String input) {

        Node head = null;
        Node tail = null;

        for (char c : input.toCharArray()) {

            Node newNode = new Node(c);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    // ===============================
    // UC10 - Ignore Case & Spaces
    // ===============================

    public static void checkPalindromeIgnoreCase(String input) {

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isSimplePalindrome(normalized);

        System.out.println("Input : " + input);
        System.out.println("Normalized : " + normalized);
        System.out.println("Is Palindrome? : " + result);
        System.out.println();
    }

    public static boolean isSimplePalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {

            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // ===============================
    // Test Method
    // ===============================

    public static void testPalindrome(PalindromeChecker checker, String input) {

        boolean result = checker.checkPalindrome(input);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
        System.out.println();
    }

    // ===============================
    // UC13 Performance Comparison
    // ===============================

    public static void performanceComparison(String input) {

        System.out.println("Performance Comparison for input: " + input);
        System.out.println();

        long startStack = System.nanoTime();
        boolean stackResult = new StackStrategy().checkPalindrome(input);
        long endStack = System.nanoTime();

        long startDeque = System.nanoTime();
        boolean dequeResult = new DequeStrategy().checkPalindrome(input);
        long endDeque = System.nanoTime();

        long stackTime = endStack - startStack;
        long dequeTime = endDeque - startDeque;

        System.out.println("Stack Result : " + stackResult);
        System.out.println("Stack Time : " + stackTime + " ns");

        System.out.println();

        System.out.println("Deque Result : " + dequeResult);
        System.out.println("Deque Time : " + dequeTime + " ns");

        System.out.println();

        if (stackTime < dequeTime) {
            System.out.println("Stack Method is Faster");
        } else if (dequeTime < stackTime) {
            System.out.println("Deque Method is Faster");
        } else {
            System.out.println("Both have similar performance");
        }
    }
}
