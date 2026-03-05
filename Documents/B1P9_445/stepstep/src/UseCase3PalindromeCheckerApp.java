public class UseCase3PalindromeCheckerApp{
    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        System.out.println(" Welcome to the Palindrome Checker Management System");
        System.out.println(" UC8 - Linked List Based Palindrome Check");
        System.out.println(" System initialized successfully");
        System.out.println("--------------------------------------------------");

        checkPalindromeUsingLinkedList("radar");
        checkPalindromeUsingLinkedList("level");
        checkPalindromeUsingLinkedList("hello");

        System.out.println("--------------------------------------------------");
        System.out.println("Program exited successfully.");
    }

    // Main function to check palindrome using Linked List
    public static void checkPalindromeUsingLinkedList(String input) {

        Node head = buildLinkedList(input);

        if (head == null || head.next == null) {
            System.out.println("Input : " + input);
            System.out.println("Is Palindrome? : true\n");
            return;
        }

        Node slow = head;
        Node fast = head;

        // Find middle using Fast & Slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverseList(slow);

        Node firstHalf = head;
        Node tempSecond = secondHalf;

        boolean isPalindrome = true;

        // Compare halves
        while (tempSecond != null) {
            if (firstHalf.data != tempSecond.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            tempSecond = tempSecond.next;
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
        System.out.println();
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

    // Reverse Linked List
    public static Node reverseList(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}