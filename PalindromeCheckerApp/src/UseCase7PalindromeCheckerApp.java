import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase7PalindromeCheckerApp {

    public static void main(String[] args) {

        // --- UC1: Welcome Message ---
        System.out.println("=========================================");
        System.out.println("  Welcome to the PalindromeChecker App!  ");
        System.out.println("  Version: 1.0                           ");
        System.out.println("=========================================");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String originalWord = scanner.nextLine();

        // --- UC7: Deque-Based Optimized Palindrome Check ---

        // 1. Initialize the Deque
        Deque<Character> deque = new ArrayDeque<>();

        // 2. Insert characters into deque
        for (int i = 0; i < originalWord.length(); i++) {
            deque.addLast(originalWord.charAt(i)); // Adds to the rear
        }

        // 3. Remove first & last, and compare until empty (or 1 char left)
        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char first = deque.removeFirst(); // Removes from the front
            char last = deque.removeLast();   // Removes from the rear

            if (first != last) {
                isPalindrome = false; // Mismatch found!
                break;
            }
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