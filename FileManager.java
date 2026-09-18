package util;

import model.GraduateStudent;
import model.Student;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String FILE_NAME = "data/students.txt";

    public void saveStudents(ArrayList<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                writer.write(student.getStudentType() + "|" +
                        student.getId() + "|" +
                        student.getName().replace("|", " ") + "|" +
                        joinMarks(student.getMarks()));
                writer.newLine();
            }
            System.out.println("Records saved successfully.");
        } catch (IOException e) {
            System.out.println("Could not save records: " + e.getMessage());
        }
    }

    public ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved file found.");
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length != 8) {
                    continue;
                }

                String type = parts[0];
                int id = Integer.parseInt(parts[1]);
                String name = parts[2];

                int[] marks = new int[5];
                for (int i = 0; i < 5; i++) {
                    marks[i] = Integer.parseInt(parts[3 + i]);
                }

                if (type.equalsIgnoreCase("Graduate")) {
                    students.add(new GraduateStudent(id, name, marks));
                } else {
                    students.add(new Student(id, name, marks));
                }
            }

            System.out.println("Records loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Could not load records: " + e.getMessage());
        }

        return students;
    }

    private String joinMarks(int[] marks) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < marks.length; i++) {
            if (i > 0) {
                result.append("|");
            }
            result.append(marks[i]);
        }
        return result.toString();
    }
}
