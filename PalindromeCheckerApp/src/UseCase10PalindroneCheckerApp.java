import java.util.Scanner;

public class UseCase10PalindroneCheckerApp {

    public static void main(String[] args) {

        // --- UC1: Welcome Message ---
        System.out.println("=========================================");
        System.out.println("  Welcome to the PalindromeChecker App!  ");
        System.out.println("  Version: 1.0                           ");
        System.out.println("=========================================");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a phrase to check: ");
        String originalPhrase = scanner.nextLine();

        // --- UC10: Case-Insensitive & Space-Ignored Palindrome Check ---

        // 1. String Preprocessing using Regular Expressions (Regex)
        // This removes everything that is NOT a letter or number, and makes it lowercase
        String cleanedStr = originalPhrase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 2. Apply previous logic (We will use the efficient Two-Pointer approach from UC4)
        boolean isPalindrome = true;
        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        // Output the result
        System.out.println("\nOriginal phrase: \"" + originalPhrase + "\"");
        System.out.println("Cleaned string used for check: \"" + cleanedStr + "\"");

        if (isPalindrome) {
            System.out.println("Result: Yes, it is a palindrome!");
        } else {
            System.out.println("Result: No, it is not a palindrome.");
        }

        scanner.close();
    }
}