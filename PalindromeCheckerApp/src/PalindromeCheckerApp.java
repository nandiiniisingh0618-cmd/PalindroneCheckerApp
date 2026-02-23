import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // --- UC1: Welcome Message ---
        System.out.println("=========================================");
        System.out.println("  Welcome to the PalindromeChecker App!  ");
        System.out.println("  Version: 1.0                           ");
        System.out.println("=========================================");

        // Setup Scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String originalWord = scanner.nextLine();

        // --- UC4: Character Array Based Palindrome Check ---

        // 1. Convert string to char[]
        char[] charArray = originalWord.toCharArray();

        // 2. Two-Pointer Technique Setup
        int left = 0; // Starts at the first character
        int right = charArray.length - 1; // Starts at the last character
        boolean isPalindrome = true; // Assume it is true until proven otherwise

        // 3. Compare start & end characters moving inward
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                isPalindrome = false; // Mismatch found!
                break; // Exit the loop immediately to save time
            }
            left++;  // Move left pointer forward
            right--; // Move right pointer backward
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