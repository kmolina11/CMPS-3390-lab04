package Controllers;

import Models.Student;
import Models.StudentData;
import Views.StudentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController {
    private StudentData model;
    private StudentView view;

    public StudentController(StudentData model, StudentView view){
        this.model = model;
        this.view = view;

        view.setAddStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = view.getFirstName();
                String lastName = view.getLastName();
                String studentID = view.getStudentID();

                if(firstName.isBlank() || lastName.isBlank() || studentID.isBlank()){
                    view.showError("You must fill out all fields!");
                    return;
                }

                Student student = new Student(firstName, lastName, Integer.parseInt(studentID)); //parseInt passes a string as an int
                model.addStudent(student);
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

    }
}
