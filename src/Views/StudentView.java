package Views;

import Models.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentView  extends JFrame {
    private JPanel panel;
    private JList<Student> listStudents;
    private JLabel labelFirstName;
    private JTextField inputFirstName;
    private JLabel labelLastName;
    private JTextField inputLastName;
    private JTextField inputStudentID;
    private JLabel labelStudentID;
    private JButton buttonAddStudent;
    private JButton buttonRemoveStudent;
    DefaultListModel<Student> listModelStudents; // generic typing tell it what type of list

    public StudentView(){
        setContentPane(panel);
        setTitle("Student Directory");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModelStudents = new DefaultListModel<Student>();
        listStudents.setModel(listModelStudents);
    }

    public String getFirstName(){
        return inputFirstName.getText();
    }
    public String getLastName(){
        return inputLastName.getText();
    }
    public String getStudentID(){   //is string because its the controllers job to validate
        return inputStudentID.getText();
    }
    public void resetInputs(){
        inputFirstName.setText("");
        inputLastName.setText("");
        inputStudentID.setText("");

        inputFirstName.grabFocus();
    }

    public Student getSelectedStudent(){
        return listStudents.getSelectedValue();
    }

    public void addStudentToList(Student student){
        listModelStudents.addElement(student);
    }

    public void removeStudentFromList(Student student){
        listModelStudents.removeElement(student);
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public void setAddStudentListener(ActionListener listener){
        buttonAddStudent.addActionListener(listener);
    }

    public void setRemoveStudentListener(ActionListener listener){
        buttonRemoveStudent.addActionListener(listener);
    }
}
