package week11;

// Claire Francis, Week11Program3, 11/14/2025

import java.util.Scanner;

public class Week11Program3 {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many courses do you have? ");
        int n = getPositiveInt(input);

        double[] grades = new double[n];
        double[] credits = new double[n];

        // Get grades and credits from user
        for (int i = 0; i < n; i++) {
            System.out.println("\nCourse " + (i + 1) + ":");

            System.out.print("  Enter numerical grade (0.00–4.00): ");
            grades[i] = getDoubleInRange(input, 0.0, 4.0);

            System.out.print("  Enter number of credits: ");
            credits[i] = getPositiveDouble(input);
        }

        // Compute GPA using the method
        double gpa = computeGPA(grades, credits);

        System.out.printf("\nYour GPA is: %.2f\n", gpa);
        input.close();
    }

    // ---------------------------------------------------------
    // computeGPA METHOD
    // ---------------------------------------------------------
    static double computeGPA(double[] grades, double[] credits) {
        double totalQualityPoints = 0;
        double totalCredits = 0;

        for (int i = 0; i < grades.length; i++) {
            totalQualityPoints += grades[i] * credits[i];
            totalCredits += credits[i];
        }

        return totalQualityPoints / totalCredits;
    }

    // ---------------------------------------------------------
    // ERROR TRAPPING METHODS
    // ---------------------------------------------------------

    // Validates positive integer input
    public static int getPositiveInt(Scanner input) {
        while (true) {
            if (input.hasNextInt()) {
                int val = input.nextInt();
                if (val > 0) return val;
            }
            System.out.print("Invalid input. Enter a positive integer: ");
            input.next();
        }
    }

    // Validates positive double input
    public static double getPositiveDouble(Scanner input) {
        while (true) {
            if (input.hasNextDouble()) {
                double val = input.nextDouble();
                if (val > 0) return val;
            }
            System.out.print("Invalid input. Enter a positive number: ");
            input.next();
        }
    }

    // Validates double input within a range
    public static double getDoubleInRange(Scanner input, double min, double max) {
        while (true) {
            if (input.hasNextDouble()) {
                double val = input.nextDouble();
                if (val >= min && val <= max) return val;
            }
            System.out.print("Invalid input. Enter a value between " + min + " and " + max + ": ");
            input.next();
        }

	}

}
