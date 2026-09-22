package Controllers;

import Models.Student;
import Models.StudentData;
import Views.StudentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentController {
    private StudentData model;
    private StudentView view;
    final private int UNIQUE_ERROR = 19;

    public StudentController(StudentData model, StudentView view){
        this.model = model;
        this.view = view;

        ArrayList<Student> students = model.getStudents();
        students.forEach(s->{
            view.addStudentToList(s);
        });

        view.setAddStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = view.getFirstName();
                String lastName = view.getLastName();
                String studentID = view.getStudentID();
                String gpa = view.getGpa();

                if(firstName.isBlank() || lastName.isBlank() || studentID.isBlank()){
                    view.showError("You must fill out all fields!");
                    return;
                }
                if(gpa.isBlank()){
                    view.showMessage("you must enter GPA");
                    return;
                }

                Student student = new Student(firstName, lastName, Integer.parseInt(studentID), Double.parseDouble(gpa)); //parseInt passes a string as an int
                try{
                    model.addStudent(student);
                } catch (SQLException ex){
                    System.out.println(ex.getErrorCode());
                    if(ex.getErrorCode() == UNIQUE_ERROR){
                        view.showMessage("ID must be Unique");
                        return;
                    }
                }

                view.addStudentToList(student);
                view.resetInputs();

            }
        });
        view.setRemoveStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student= view.getSelectedStudent();

                if(student == null){
                    view.showError("You Must Select A Student!!");
                    return;
                }
                model.removeStudent(student);
                view.removeStudentFromList(student);
            }
        });
        view.setGetGpaListener(e -> {
            Student student = view.getSelectedStudent();
            view.showMessage(student.getGpaInfo());
        });

    }
}
