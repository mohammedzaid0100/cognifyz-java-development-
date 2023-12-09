import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Strength Checker");
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        if (isStrongPassword(password)) {
            System.out.println("Password is strong!");
        } else {
            System.out.println("Password is weak. Please follow the password requirements.");
        }

        scanner.close();
    }

    private static boolean isStrongPassword(String password) {
        // Check length
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        // Check for uppercase and lowercase letters
        if (!(password.matches(".*[A-Z].*") && password.matches(".*[a-z].*"))) {
            System.out.println("Password must contain both uppercase and lowercase letters.");
            return false;
        }

        // Check for at least one digit
        if (!password.matches(".*\\d.*")) {
            System.out.println("Password must contain at least one digit.");
            return false;
        }

        // Check for at least one special character
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            System.out.println("Password must contain at least one special character.");
            return false;
        }

        // If all checks pass, the password is considered strong
        return true;
    }
}