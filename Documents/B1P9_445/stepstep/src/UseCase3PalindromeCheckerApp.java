public class UseCase11PalindromeCheckerApp {

        // ===============================
        // Node class for UC9 (Linked List)
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
        // UC11 - Palindrome Service Class
        // ===============================
        static class PalindromeChecker {

            public boolean checkPalindrome(String input) {

                if (input == null) {
                    return false;
                }

                String normalized = input.toLowerCase();

                int start = 0;
                int end = normalized.length() - 1;

                while (start < end) {

                    if (normalized.charAt(start) != normalized.charAt(end)) {
                        return false;
                    }

                    start++;
                    end--;
                }

                return true;
            }
        }

        // ===============================
        // MAIN METHOD
        // ===============================
        public static void main(String[] args) {

            System.out.println(" Welcome to the Palindrome Checker Management System");
            System.out.println(" UC9 - Recursion Based Palindrome Check");
            System.out.println(" UC10 - Case-Insensitive & Space-Ignored Palindrome Check");
            System.out.println(" UC11 - Object-Oriented Palindrome Service");
            System.out.println(" System initialized successfully");
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

            // UC11
            PalindromeChecker checker = new PalindromeChecker();
            testPalindrome(checker, "madam");
            testPalindrome(checker, "racecar");
            testPalindrome(checker, "java");

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
                }
                else {
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
        // UC11 - OOP Palindrome Service
        // ===============================

        public static void testPalindrome(PalindromeChecker checker, String input) {

            boolean result = checker.checkPalindrome(input);

            System.out.println("Input : " + input);
            System.out.println("Is Palindrome? : " + result);
            System.out.println();
        }
    }}