import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class UseCase6PalindromeCheckerApp {

    public static void main(String[] args) {

        // --- UC1: Welcome Message ---
        System.out.println("=========================================");
        System.out.println("  Welcome to the PalindromeChecker App!  ");
        System.out.println("  Version: 1.0                           ");
        System.out.println("=========================================");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String originalWord = scanner.nextLine();

        // --- UC6: Queue + Stack Based Palindrome Check ---

        // 1. Initialize Stack and Queue
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // 2. Push (Stack) and Enqueue (Queue) Operations
        for (int i = 0; i < originalWord.length(); i++) {
            char c = originalWord.charAt(i);
            stack.push(c); // Stack: Last In, First Out
            queue.add(c);  // Queue: First In, First Out
        }

        // 3. Compare pop (Stack) vs dequeue (Queue)
        boolean isPalindrome = true;

        while (!stack.isEmpty() && !queue.isEmpty()) {
            char stackPop = stack.pop();     // Retrieves characters in REVERSE order
            char queueDequeue = queue.remove(); // Retrieves characters in ORIGINAL order

            if (stackPop != queueDequeue) {
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