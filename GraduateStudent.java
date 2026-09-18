package model;

public class GraduateStudent extends Student {

    public GraduateStudent(int id, String name) {
        super(id, name);
    }

    public GraduateStudent(int id, String name, int[] marks) {
        super(id, name, marks);
    }

    @Override
    public String getStudentType() {
        return "Graduate";
    }

    @Override
    public void display() {
        System.out.println("ID: " + getId() + " | Name: " + getName()
                + " | Type: " + getStudentType());
    }
}
