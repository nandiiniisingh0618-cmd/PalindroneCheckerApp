import java.util.Scanner;

public class UseCase9PalindroneCheckerApp {

    public static void main(String[] args) {

        // --- UC1: Welcome Message ---
        System.out.println("=========================================");
        System.out.println("  Welcome to the PalindromeChecker App!  ");
        System.out.println("  Version: 1.0                           ");
        System.out.println("=========================================");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String originalWord = scanner.nextLine();

        // --- UC9: Recursive Palindrome Check ---

        // We pass the word, the starting index (0), and the ending index (length - 1)
        boolean isPalindrome = false;

        if (originalWord != null && !originalWord.isEmpty()) {
            isPalindrome = isPalindromeRecursive(originalWord, 0, originalWord.length() - 1);
        } else if (originalWord != null && originalWord.isEmpty()) {
            isPalindrome = true; // An empty string is technically a palindrome
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

    // --- The Recursive Method ---
    public static boolean isPalindromeRecursive(String str, int left, int right) {

        // 1. Base Condition (Success): Pointers have met or crossed in the middle
        if (left >= right) {
            return true;
        }

        // 2. Base Condition (Failure): Characters do not match
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        // 3. Recursive Call: Move both pointers inward and call the method again
        return isPalindromeRecursive(str, left + 1, right - 1);
    }
}