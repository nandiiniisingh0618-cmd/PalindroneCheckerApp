import java.util.Scanner;
import java.util.Stack; // We must import the Stack class

public class UseCase5PalindromeCheckerApp {

    public static void main(String[] args) {

        // --- UC1: Welcome Message ---
        System.out.println("=========================================");
        System.out.println("  Welcome to the PalindromeChecker App!  ");
        System.out.println("  Version: 1.0                           ");
        System.out.println("=========================================");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String originalWord = scanner.nextLine();

        // --- UC5: Stack-Based Palindrome Check ---

        // 1. Initialize the Stack Data Structure
        Stack<Character> stack = new Stack<>();

        // 2. Push Operation: Load characters into the stack
        for (int i = 0; i < originalWord.length(); i++) {
            stack.push(originalWord.charAt(i));
        }

        // 3. Pop Operation & Reversal Logic
        boolean isPalindrome = true;

        for (int i = 0; i < originalWord.length(); i++) {
            // stack.pop() automatically gives us the characters in reverse order
            char poppedChar = stack.pop();

            // Compare the original word's character with the popped character
            if (originalWord.charAt(i) != poppedChar) {
                isPalindrome = false; // Mismatch found
                break; // Exit early
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