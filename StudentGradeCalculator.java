import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        for (int i = 1; i <= numStudents; i++) {
            System.out.println("\nStudent " + i + ":");
            double totalMarks = 0;

            // Input marks for three subjects
            for (int j = 1; j <= 3; j++) {
                System.out.print("Enter marks for subject " + j + ": ");
                totalMarks += getValidMark(scanner);
            }

            // Calculate average marks
            double averageMarks = totalMarks / 3.0;

            // Determine the grade based on the average
            char grade = calculateGrade(averageMarks);

            // Display the result
            System.out.println("Average marks: " + averageMarks);
            System.out.println("Grade: " + grade);
        }

        // Close the scanner
        scanner.close();
    }

    private static double getValidMark(Scanner scanner) {
        double mark;
        while (true) {
            try {
                mark = scanner.nextDouble();
                if (mark >= 0 && mark <= 100) {
                    break;
                } else {
                    System.out.println("Please enter a valid mark between 0 and 100.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a valid numeric value.");
                scanner.next(); // Clear the invalid input
            }
        }
        return mark;
    }

    private static char calculateGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}