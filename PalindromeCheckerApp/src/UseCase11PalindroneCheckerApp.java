import java.util.Scanner;

public class UseCase11PalindromeCheckerApp {

    // --- The Service Class (Business Logic) ---
    // By making this a 'static class' inside our main class, we keep everything in one file!
    static class PalindromeChecker {

        // Exposing a single, public method to the outside world
        public boolean checkPalindrome(String text) {
            // Edge case handling
            if (text == null) {
                return false;
            }

            // 1. Preprocess string (from UC10)
            String cleanedStr = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            // 2. Internal Data Structure: Array with Two-Pointer technique (from UC4)
            char[] charArray = cleanedStr.toCharArray();
            int left = 0;
            int right = charArray.length - 1;

            while (left < right) {
                if (charArray[left] != charArray[right]) {
                    return false; // Mismatch found
                }
                left++;
                right--;
            }

            return true; // It's a palindrome!
        }
    }

    public static void main(String[] args) {

        // --- UC1: Welcome Message ---
        System.out.println("=========================================");
        System.out.println("  Welcome to the PalindromeChecker App!  ");
        System.out.println("  Version: 2.0 (OOP Edition)             ");
        System.out.println("=========================================");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a phrase to check: ");
        String userInput = scanner.nextLine();

        // --- UC11: Object-Oriented Palindrome Service ---

        // 1. Instantiate the PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker();

        // 2. Call the exposed checkPalindrome() method
        boolean result = checker.checkPalindrome(userInput);

        // Output the result
        System.out.println("\nChecking: \"" + userInput + "\"");
        if (result) {
            System.out.println("Result: Yes, it is a palindrome!");
        } else {
            System.out.println("Result: No, it is not a palindrome.");
        }

        scanner.close();
    }
}