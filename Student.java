package model;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private int[] marks;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.marks = new int[5];
    }

    public Student(int id, String name, int[] marks) {
        this.id = id;
        this.name = name;
        this.marks = Arrays.copyOf(marks, marks.length);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getMarks() {
        return Arrays.copyOf(marks, marks.length);
    }

    public void setMarks(int[] marks) {
        this.marks = Arrays.copyOf(marks, marks.length);
    }

    public String getStudentType() {
        return "Regular";
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name +
                " | Type: " + getStudentType());
    }
}
