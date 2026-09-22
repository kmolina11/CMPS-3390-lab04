package Models;

public class Student {
    private String firstName;
    private String lastName;
    private int studentID;
    private double gpa;


    public Student(String firstName, String lastName, int studentID, double gpa){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.gpa = gpa;
    }

    public String toString(){
        return String.format("%s %s (%d)", firstName, lastName, studentID);
    }

    public String getGpaInfo(){
        return String.format("%s %s: %f", firstName, lastName, gpa);
    }

    public String getFirstName() {
        return firstName;
    }

    public double getGpa() {
        return gpa;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getLastName() {
        return lastName;
    }
}
