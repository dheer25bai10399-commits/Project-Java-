package service;

import exception.InvalidMarksException;
import model.Grade;
import model.Student;

import java.util.ArrayList;

public class GradeService implements GradeCalculator {

    @Override
    public Grade calculateGrade(double average) {
        if (average >= 90) return Grade.A;
        if (average >= 80) return Grade.B;
        if (average >= 70) return Grade.C;
        if (average >= 60) return Grade.D;
        if (average >= 50) return Grade.E;
        return Grade.F;
    }

    public void validateMarks(int[] marks) throws InvalidMarksException {
        if (marks == null || marks.length != 5) {
            throw new InvalidMarksException("Exactly 5 subject marks are required.");
        }

        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarksException("Marks must be between 0 and 100.");
            }
        }
    }

    public void enterMarks(Student student, int[] marks)
            throws InvalidMarksException {
        validateMarks(marks);
        student.setMarks(marks);
    }

    public int calculateTotal(Student student) {
        int total = 0;
        for (int mark : student.getMarks()) {
            total += mark;
        }
        return total;
    }

    public double calculateAverage(Student student) {
        return calculateTotal(student) / 5.0;
    }

    public boolean isPass(Student student) {
        for (int mark : student.getMarks()) {
            if (mark < 40) {
                return false;
            }
        }
        return calculateAverage(student) >= 50;
    }

    public void showResult(Student student) {
        int[] marks = student.getMarks();
        double average = calculateAverage(student);
        Grade grade = calculateGrade(average);

        System.out.println("\n----- Student Result -----");
        System.out.println("ID       : " + student.getId());
        System.out.println("Name     : " + student.getName());
        System.out.println("Type     : " + student.getStudentType());
        System.out.println("Marks    : " + marks[0] + ", " + marks[1] + ", "
                + marks[2] + ", " + marks[3] + ", " + marks[4]);
        System.out.println("Total    : " + calculateTotal(student) + "/500");
        System.out.printf("Average  : %.2f%n", average);
        System.out.println("Grade    : " + grade);
        System.out.println("Status   : " + (isPass(student) ? "PASS" : "FAIL"));
    }

    public Student findStudent(ArrayList<Student> students, int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student highestScorer(ArrayList<Student> students) {
        if (students.isEmpty()) {
            return null;
        }

        Student highest = students.get(0);
        for (Student student : students) {
            if (calculateAverage(student) > calculateAverage(highest)) {
                highest = student;
            }
        }
        return highest;
    }

    public double classAverage(ArrayList<Student> students) {
        if (students.isEmpty()) {
            return 0;
        }

        double total = 0;
        for (Student student : students) {
            total += calculateAverage(student);
        }
        return total / students.size();
    }
}
