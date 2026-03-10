import java.util.Scanner;
import java.util.Stack;

public class UseCase13PalindroneCheckerApp {

    // --- Algorithm 1: Two-Pointer Approach (Primitive & Fast) ---
    public static boolean isPalindromeTwoPointer(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // --- Algorithm 2: StringBuilder Reverse (Creates new objects) ---
    public static boolean isPalindromeStringBuilder(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }

    // --- Algorithm 3: Stack-Based (Heavy overhead) ---
    public static boolean isPalindromeStack(String text) {
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) stack.push(c);

        for (char c : text.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        // --- UC1: Welcome Message ---
        System.out.println("=========================================");
        System.out.println("  Welcome to the PalindromeChecker App!  ");
        System.out.println("  Version: 4.0 (Performance Profiler)    ");
        System.out.println("=========================================");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a phrase to benchmark: ");
        String userInput = scanner.nextLine();

        // Preprocess string once so we only measure the algorithm's speed
        String cleanedStr = userInput.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int iterations = 100000; // Run 100,000 times to magnify the time differences
        System.out.println("\nRunning benchmark (" + iterations + " iterations)... Please wait.");

        // --- UC13: Capture Execution Time ---

        // Benchmark 1: Two-Pointer
        long startTime1 = System.nanoTime();
        for(int i = 0; i < iterations; i++) isPalindromeTwoPointer(cleanedStr);
        long endTime1 = System.nanoTime();
        long duration1 = (endTime1 - startTime1) / 1000000; // Convert nanoseconds to milliseconds

        // Benchmark 2: StringBuilder
        long startTime2 = System.nanoTime();
        for(int i = 0; i < iterations; i++) isPalindromeStringBuilder(cleanedStr);
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2) / 1000000;

        // Benchmark 3: Stack
        long startTime3 = System.nanoTime();
        for(int i = 0; i < iterations; i++) isPalindromeStack(cleanedStr);
        long endTime3 = System.nanoTime();
        long duration3 = (endTime3 - startTime3) / 1000000;

        // Output Results
        System.out.println("\n--- Performance Results ---");
        System.out.println("1. Two-Pointer (Array):   " + duration1 + " ms");
        System.out.println("2. StringBuilder Reverse: " + duration2 + " ms");
        System.out.println("3. Stack-Based:           " + duration3 + " ms");
        System.out.println("---------------------------");

        scanner.close();
    }
}