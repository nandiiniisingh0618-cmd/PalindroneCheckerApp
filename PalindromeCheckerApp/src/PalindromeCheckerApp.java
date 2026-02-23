import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // --- UC1: Welcome Message ---
        System.out.println("=========================================");
        System.out.println("  Welcome to the PalindromeChecker App!  ");
        System.out.println("  Version: 1.0                           ");
        System.out.println("=========================================");

        // --- UC3: Palindrome Check Using String Reverse ---
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String originalWord = scanner.nextLine();

        String reversedWord = "";

        // 1. Loop (for loop) & 2. String Concatenation (+)
        for (int i = originalWord.length() - 1; i >= 0; i--) {
            reversedWord += originalWord.charAt(i);
        }

        // 3. equals() Method
        System.out.println("\nOriginal: " + originalWord);
        System.out.println("Reversed: " + reversedWord);

        if (originalWord.equals(reversedWord)) {
            System.out.println("Result: Yes, it is a palindrome!");
        } else {
            System.out.println("Result: No, it is not a palindrome.");
        }

        scanner.close();
    }
}