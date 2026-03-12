import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase13PalindromeCheckerApp {

    // Stack-based palindrome check
    public static boolean stackPalindrome(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Deque-based palindrome check
    public static boolean dequePalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    // Recursive palindrome check
    public static boolean recursivePalindrome(String str, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return recursivePalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Stack Strategy Timing
        long start1 = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long end1 = System.nanoTime();

        // Deque Strategy Timing
        long start2 = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        long end2 = System.nanoTime();

        // Recursive Strategy Timing
        long start3 = System.nanoTime();
        boolean recursiveResult = recursivePalindrome(input, 0, input.length() - 1);
        long end3 = System.nanoTime();

        System.out.println("\nPalindrome Results:");
        System.out.println("Stack Result: " + stackResult);
        System.out.println("Deque Result: " + dequeResult);
        System.out.println("Recursive Result: " + recursiveResult);

        System.out.println("\nExecution Time (nanoseconds):");
        System.out.println("Stack Strategy Time: " + (end1 - start1));
        System.out.println("Deque Strategy Time: " + (end2 - start2));
        System.out.println("Recursive Strategy Time: " + (end3 - start3));

        scanner.close();
    }
}