/**
 * Course: MAD204 - Lab01
 * Student Name: Jennyfer Rajubhai Parmar
 * Student ID: A00201240
 * Date: 2025-09-21
 *
 * Description:
 * This program depicts a Gradebook & Utilities console app.
 * Users can add students, enter grades, compute averages/letter grades,
 * and run utility demos (operator precedence, type casting, recursion).
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // List to store student objects
    private static ArrayList<Student> students = new ArrayList<>();
    // Scanner for user input private
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        // Main menu loop (while)
        while (running) {
            System.out.println("\n--- Gradebook & Utilities ---");
            System.out.println("1. Add Student");
            System.out.println("2. Enter Grades");
            System.out.println("3. Show All Students");
            System.out.println("4. Utilities");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            //get user input
            int choice = safeIntInput();
        //handle menu selection
            switch (choice) {
                case 1:
                    addStudent(); //add student
                    break;
                case 2:
                    enterGrades(); //add grades for students
                    break;
                case 3:
                    showAllStudents(); // display students
                    break;
                case 4:
                    utilitiesMenu(); //use utility menu
                    break;
                case 5:
                    running = false; //exit program
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Adds a new student with do-while loop for multiple enteries.
    private static void addStudent() {
        String again;
        do {
            System.out.print("Enter student ID: ");
            int id = safeIntInput();
            System.out.print("Enter student name: ");
            String name = sc.next();
        //create and add new students to the list
            students.add(new Student(id, name));
            System.out.println("Student added!");
        //ask if user wants to add another student
            System.out.print("Add another student? (y/n): ");
            again = sc.next();
        } while (again.equalsIgnoreCase("y"));
    }

    // Enter grades for a student specific student
    private static void enterGrades() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.print("Enter student name to add grades: ");
        String name = sc.next();

        for (Student s : students) {
            if (s.getName().equals(name)) {
                // for loop to input 5 grades
                for (int i = 0; i < 5; i++) {
                    System.out.print("Enter grade " + (i + 1) + ": ");
                    double g = safeDoubleInput();
                    s.setGrade(i, g);
                }
                System.out.println("Grades updated for " + name);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // display all students using a for-each loop
    private static void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println(s); //assumes student class has a toString()
        }
    }

    //Displays the utilities submenu and handles user selection
    private static void utilitiesMenu() {
        System.out.println("\n--- Utilities ---");
        System.out.println("1. Operator Demo");
        System.out.println("2. Type Casting");
        System.out.println("3. Recursion Countdown");
        System.out.print("Choose option: ");

        int choice = safeIntInput();

        switch (choice) {
            case 1:
                operatorDemo(); //show operator precedence
                break;
            case 2:
                typeCastingDemo(); // show type casting examples
                break;
            case 3:
                System.out.print("Enter number to countdown: ");
                int n = safeIntInput();
                if (n >= 0) countdown(n); //start countdown if non-negative
                else System.out.println("Negative not allowed.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    // Operator precedence with examples
    private static void operatorDemo() {
        int result1 = 2 + 3 * 4;       // multiplication before addition
        int result2 = (2 + 3) * 4;     // parentheses change precendence
        System.out.println("2 + 3 * 4 = " + result1);
        System.out.println("(2 + 3) * 4 = " + result2);
        System.out.println("Explanation: Multiplication has higher precedence than addition.");
    }

    // Type casting example: widening and narrowing
    private static void typeCastingDemo() {
        int x = 7;
        double y = x; // widening (int to double)
        double z = 9.8;
        int w = (int) z; // narrowing (double to int)
        System.out.println("Widening int->double: " + x + " -> " + y);
        System.out.println("Narrowing double->int: " + z + " -> " + w);
    }

    /** Recursive countdown  from given number to zero*/
    private static void countdown(int n) {
        if (n < 0) return;
        if (n == 0) {
            System.out.println("0... Done!");
        } else {
            System.out.println(n);
            countdown(n - 1); // recursive call
        }
    }

    // Safely reads an integer from user input with exception handling
    private static int safeIntInput() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Enter an integer: ");
                sc.next(); // clear invalid input
            }
        }
    }

    // Safely reads a double from user input with exception handling
    private static double safeDoubleInput() {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Enter a number: ");
                sc.next(); // clear invalid input
            }
        }
    }
}