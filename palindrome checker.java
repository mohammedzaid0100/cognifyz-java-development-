import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }

        scanner.close();
    }

    // Function to check if a string is a palindrome
    private static boolean isPalindrome(String str) {
        // Remove spaces and convert to lowercase for case-insensitive comparison
        String cleanStr = str.replaceAll("\\s", "").toLowerCase();

        int length = cleanStr.length();
        for (int i = 0; i < length / 2; i++) {
            if (cleanStr.charAt(i) != cleanStr.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}