package Models;

public class Student {
    private String firstName;
    private String lastName;
    private int studentID;


    public Student(String firstName, String lastName, int studentID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    public String toString(){
        return String.format("%s %s (%d)", firstName, lastName, studentID);
    }
}
