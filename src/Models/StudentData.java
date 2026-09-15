package Models;

import java.util.ArrayList;
import java.util.List;

public class StudentData {          //keeps track of students
    private List<Student> students;

    public StudentData(){
        students = new ArrayList<Student>();     //initializes list
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(Student student){
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
