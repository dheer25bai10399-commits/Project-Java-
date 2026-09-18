package thread;

import model.Student;
import service.GradeService;

import java.util.ArrayList;

public class ReportThread extends Thread {
    private final ArrayList<Student> students;
    private final GradeService service;

    public ReportThread(ArrayList<Student> students, GradeService service) {
        this.students = students;
        this.service = service;
    }

    @Override
    public synchronized void run() {
        System.out.println("\nGenerating class report...");
        System.out.println("----------------------------");

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("Number of students: " + students.size());

        Student highest = service.highestScorer(students);
        if (highest != null) {
            System.out.printf("Highest scorer: %s (%.2f)%n",
                    highest.getName(), service.calculateAverage(highest));
        }

        System.out.printf("Class average: %.2f%n",
                service.classAverage(students));

        System.out.println("\nStudent list:");
        for (Student student : students) {
            System.out.printf("%d - %s - %.2f - %s%n",
                    student.getId(),
                    student.getName(),
                    service.calculateAverage(student),
                    service.calculateGrade(service.calculateAverage(student)));
        }
    }
}
