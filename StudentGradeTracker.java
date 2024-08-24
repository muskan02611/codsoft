import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    private ArrayList<Double> grades;

    public StudentGradeTracker() {
        grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public double findHighestGrade() {
        double highest = Double.MIN_VALUE;
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public double findLowestGrade() {
        double lowest = Double.MAX_VALUE;
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker tracker = new StudentGradeTracker();
        int studentCounter = 1;

        while (true) {
            System.out.println("Enter grade for Student " + studentCounter + " (or type 'calculate' to finish): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("calculate")) {
                break;
            }
            try {
                double grade = Double.parseDouble(input);
                tracker.addGrade(grade);
                studentCounter++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade.");
            }
        }

        if (tracker.grades.size() > 0) {
            System.out.println("Average grade: " + tracker.calculateAverage());
            System.out.println("Highest grade: " + tracker.findHighestGrade());
            System.out.println("Lowest grade: " + tracker.findLowestGrade());
        } else {
            System.out.println("No grades were entered.");
        }

        scanner.close();
    }
}
