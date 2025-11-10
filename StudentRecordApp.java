// StudentRecordApp.java
import java.util.*;

public class StudentRecordApp {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("\n===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number 1–3.");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Please enter a valid choice (1–3).");
            }

        } while (choice != 3);
    }

    private static void addStudent() {
        try {
            System.out.print("Enter Roll No: ");
            int roll = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter Name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter Course: ");
            String course = sc.nextLine().trim();

            System.out.print("Enter Marks (0–100): ");
            double marks = Double.parseDouble(sc.nextLine().trim());

            if (marks < 0 || marks > 100) {
                System.out.println("❌ Marks must be between 0 and 100.");
                return;
            }

            Student s = new Student(roll, name, course, marks);
            students.add(s);
            System.out.println("✅ Student added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter correct values.");
        }
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }
        System.out.println("\n===== Student Records =====");
        for (Student s : students) {
            s.displayDetails();
        }
    }
}
