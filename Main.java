import exception.InvalidMarksException;
import model.GraduateStudent;
import model.Student;
import service.GradeService;
import thread.ReportThread;
import util.FileManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>();

    private static final GradeService gradeService = new GradeService();
    private static final FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println("  STUDENT GRADE MANAGEMENT SYSTEM");
        System.out.println("==================================");

        while (true) {
            showMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> enterMarks();
                case 6 -> calculateResult();
                case 7 -> searchStudent();
                case 8 -> generateReport();
                case 9 -> fileManager.saveStudents(students);
                case 10 -> {
                    students.clear();
                    students.addAll(fileManager.loadStudents());
                }
                case 11 -> {
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n----------- MENU -----------");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Enter Marks");
        System.out.println("6. Calculate Result");
        System.out.println("7. Search Student");
        System.out.println("8. Class Report");
        System.out.println("9. Save Records");
        System.out.println("10. Load Records");
        System.out.println("11. Exit");
    }

    private static void addStudent() {
        int id = readInt("Enter student ID: ");

        if (gradeService.findStudent(students, id) != null) {
            System.out.println("A student with this ID already exists.");
            return;
        }

        String name = readText("Enter student name: ");

        System.out.println("1. Regular Student");
        System.out.println("2. Graduate Student");
        int type = readInt("Select student type: ");

        Student student;
        if (type == 2) {
            student = new GraduateStudent(id, name);
        } else {
            student = new Student(id, name);
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--------- STUDENTS ---------");
        for (Student student : students) {
            student.display();
        }
    }

    private static void updateStudent() {
        int id = readInt("Enter student ID to update: ");
        Student student = gradeService.findStudent(students, id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String name = readText("Enter new name: ");
        student.setName(name);
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        int id = readInt("Enter student ID to delete: ");
        Student student = gradeService.findStudent(students, id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);
        System.out.println("Student deleted successfully.");
    }

    private static void enterMarks() {
        int id = readInt("Enter student ID: ");
        Student student = gradeService.findStudent(students, id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        int[] marks = new int[5];
        String[] subjects = {
                "Java", "Mathematics", "Operating Systems",
                "Database", "English"
        };

        try {
            System.out.println("Enter marks out of 100:");
            for (int i = 0; i < marks.length; i++) {
                marks[i] = readInt(subjects[i] + ": ");
            }

            gradeService.enterMarks(student, marks);
            System.out.println("Marks saved successfully.");
        } catch (InvalidMarksException e) {
            System.out.println("Invalid marks: " + e.getMessage());
        }
    }

    private static void calculateResult() {
        int id = readInt("Enter student ID: ");
        Student student = gradeService.findStudent(students, id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        gradeService.showResult(student);
    }

    private static void searchStudent() {
        int id = readInt("Enter student ID to search: ");
        Student student = gradeService.findStudent(students, id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            student.display();
            System.out.printf("Average: %.2f%n",
                    gradeService.calculateAverage(student));
        }
    }

    private static void generateReport() {
        ReportThread reportThread = new ReportThread(students, gradeService);
        reportThread.start();

        try {
            reportThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Report generation was interrupted.");
        }
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim();

            if (!text.isEmpty()) {
                return text;
            }

            System.out.println("This field cannot be empty.");
        }
    }
}
