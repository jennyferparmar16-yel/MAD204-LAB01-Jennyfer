
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
     * Sets a grade at a specific index in the grades array
     * validates that the index is within bounds(0-4)
     * @param index grade index (0-4)
     * @param value grade value to assign
     */
    public void setGrade(int index, double value) {
        if (index >= 0 && index < grades.length) {
            grades[index] = value;
        }
    }

    /**
     * Calculates the average of the 5 grades.
     * @return average grade as a double
     */
    public double average() {
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.length;
    }

    /**
     * Determines the letter grade based on average score.
     * @return letter grade as char
     */
    public char letterGrade() {
        double avg = average();
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else return 'F';
    }

    //Returns a formatted string with student details.

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name +
                ", Avg: " + String.format("%.2f", average()) +
                " (" + letterGrade() + ")";
    }
//getter method to retrieve the students name

    public String getName() {
        return name;
    }
}