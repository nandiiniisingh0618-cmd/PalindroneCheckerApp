import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase12PalindroneCheckerApp {

    // --- 1. The Strategy Interface ---
    // This defines the "rule" that all algorithms must follow
    interface PalindromeStrategy {
        boolean isPalindrome(String text);
    }

    // --- 2. Concrete Strategy A: Stack-Based ---
    static class StackStrategy implements PalindromeStrategy {
        @Override
        public boolean isPalindrome(String text) {
            System.out.println("   -> (Executing Stack-Based Algorithm...)");
            String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            Stack<Character> stack = new Stack<>();

            for (char c : cleaned.toCharArray()) stack.push(c);

            for (char c : cleaned.toCharArray()) {
                if (c != stack.pop()) return false;
            }
            return true;
        }
    }

    // --- 3. Concrete Strategy B: Deque-Based ---
    static class DequeStrategy implements PalindromeStrategy {
        @Override
        public boolean isPalindrome(String text) {
            System.out.println("   -> (Executing Deque-Based Algorithm...)");
            String cleaned = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            Deque<Character> deque = new ArrayDeque<>();

            for (char c : cleaned.toCharArray()) deque.addLast(c);

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) return false;
            }
            return true;
        }
    }

    // --- 4. The Context Class ---
    // This class uses the strategy, but doesn't care WHICH strategy it is
    static class PalindromeChecker {
        private PalindromeStrategy strategy;

        // Inject the strategy at runtime
        public PalindromeChecker(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        // Allow changing the strategy dynamically
        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        // Execute the chosen strategy
        public boolean check(String text) {
            if (text == null) return false;
            return strategy.isPalindrome(text);
        }
    }

    public static void main(String[] args) {

        // --- UC1: Welcome Message ---
        System.out.println("=========================================");
        System.out.println("  Welcome to the PalindromeChecker App!  ");
        System.out.println("  Version: 3.0 (Strategy Pattern)        ");
        System.out.println("=========================================");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a phrase to check: ");
        String userInput = scanner.nextLine();

        // Let the user dynamically choose the algorithm
        System.out.println("\nChoose an Algorithm:");
        System.out.println("1. Stack-Based Strategy");
        System.out.println("2. Deque-Based Strategy");
        System.out.print("Your choice (1 or 2): ");
        String choice = scanner.nextLine();

        // --- UC12: Injecting Strategy at Runtime ---
        PalindromeChecker checker;

        if (choice.equals("1")) {
            checker = new PalindromeChecker(new StackStrategy()); // Inject Stack
        } else {
            checker = new PalindromeChecker(new DequeStrategy()); // Inject Deque
        }

        // Output the result
        System.out.println("\nChecking: \"" + userInput + "\"");
        boolean result = checker.check(userInput); // The checker doesn't know which one it's running!

        if (result) {
            System.out.println("Result: Yes, it is a palindrome!");
        } else {
            System.out.println("Result: No, it is not a palindrome.");
        }

        scanner.close();
    }
}