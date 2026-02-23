import java.util.Scanner;

// Building block for our Singly Linked List
class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class UseCase8PalindromeCheckerApp {

    public static void main(String[] args) {

        // --- UC1: Welcome Message ---
        System.out.println("=========================================");
        System.out.println("  Welcome to the PalindromeChecker App!  ");
        System.out.println("  Version: 1.0                           ");
        System.out.println("=========================================");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String originalWord = scanner.nextLine();

        // Edge case: Empty string
        if (originalWord.isEmpty()) {
            System.out.println("Result: Yes, an empty string is technically a palindrome!");
            return;
        }

        // --- UC8: Linked List Based Palindrome Check ---

        // 1. Convert string to linked list
        Node head = new Node(originalWord.charAt(0));
        Node current = head;
        for (int i = 1; i < originalWord.length(); i++) {
            current.next = new Node(originalWord.charAt(i));
            current = current.next;
        }

        // 2. Fast and Slow Pointer Technique (Find the middle)
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;        // Moves 1 step
            fast = fast.next.next;   // Moves 2 steps
        }

        // 3. In-Place Reversal of the second half
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node nextTemp = curr.next; // Temporarily store the next node
            curr.next = prev;          // Reverse the pointer
            prev = curr;               // Move prev forward
            curr = nextTemp;           // Move curr forward
        }

        // 4. Compare halves
        Node firstHalf = head;
        Node secondHalf = prev; // 'prev' is now the head of the reversed second half
        boolean isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false; // Mismatch found
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Output the result
        System.out.println("\nChecking word: " + originalWord);
        if (isPalindrome) {
            System.out.println("Result: Yes, it is a palindrome!");
        } else {
            System.out.println("Result: No, it is not a palindrome.");
        }

        scanner.close();
    }
}