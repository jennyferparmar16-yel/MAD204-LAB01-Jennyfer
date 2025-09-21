/**
 * Course: MAD204 - Lab 01
 * Student Name: YOUR NAME
 * Student ID: YOUR ID
 * Date: YYYY-MM-DD
 *
 * Description:
 * This class models a Student with an ID, name, and 5 grades.
 * It provides methods to set grades, compute averages, determine
 * letter grades, and return a formatted string representation.
 */

public class Student {
    private String name;
    private int id;
    private double[] grades;

    /**
     * Constructor to initialize a student with ID and name.
     * @param id Student ID
     * @param name Student Name
     */
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.grades = new double[5]; // fixed size of 5 grades
    }

    /**
     * Sets a grade at a given index.
     * @param index grade index (0-4)
     * @param value grade value
     */
    public void setGrade(int index, double value) {
        if (index >= 0 && index < grades.length) {
            grades[index] = value;
        }
    }

    /**
     * Calculates the average of the 5 grades.
     * @return average grade
     */
    public double average() {
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.length;
    }

    /**
     * Determines the letter grade based on average.
     * @return char letter grade
     */
    public char letterGrade() {
        double avg = average();
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else return 'F';
    }

    /**
     * Returns a formatted string with student details.
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name +
                ", Avg: " + String.format("%.2f", average()) +
                " (" + letterGrade() + ")";
    }

    public String getName() {
        return name;
    }
}