public class UseCase3PalindromeCheckerApp {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node left;   // pointer used in recursion

    public static void main(String[] args) {

        System.out.println(" Welcome to the Palindrome Checker Management System");
        System.out.println(" UC9 - Recursion Based Palindrome Check");
        System.out.println(" System initialized successfully");
        System.out.println("--------------------------------------------------");

        checkPalindromeUsingRecursion("radar");
        checkPalindromeUsingRecursion("level");
        checkPalindromeUsingRecursion("hello");

        System.out.println("--------------------------------------------------");
        System.out.println("Program exited successfully.");
    }

    // Main function
    public static void checkPalindromeUsingRecursion(String input) {

        Node head = buildLinkedList(input);

        left = head;

        boolean result = isPalindrome(head);

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
        System.out.println();
    }

    // Recursive function using Call Stack
    public static boolean isPalindrome(Node right) {

        // Base condition
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

    // Convert String to Linked List
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
}