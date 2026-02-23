// 1. Class
public class PalindromeCheckerApp {

    // 2. Main Method & 3. Static Keyword
    public static void main(String[] args) {

        // 4. Console Output
        System.out.println("=========================================");
        System.out.println("  Welcome to the PalindromeChecker App!  ");
        System.out.println("  Version: 1.0                           ");
        System.out.println("=========================================");

        // 5. Application Flow Control
        // The program will either prompt the user for input here (UC2)
        // or exit if there are no further instructions.
        // 1. String & String Literal
        String originalWord = "madam";
        String reversedWord = "";

        // 2. Data Structure: String Manipulation
        // We loop through the original word backwards to build the reversed version
        for (int i = originalWord.length() - 1; i >= 0; i--) {
            reversedWord += originalWord.charAt(i);
        }

        // 3. Conditional Statement (if-else) & Console Output
        System.out.println("\nChecking word: " + originalWord);

        if (originalWord.equals(reversedWord)) {
            System.out.println("Result: Yes, it is a palindrome!");
        } else {
            System.out.println("Result: No, it is not a palindrome.");
        }
    }
}

