import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentView  extends JFrame {
    private JPanel panel;
    private JList listStudents;
    private JLabel labelFirstName;
    private JTextField inputFirstName;
    private JLabel labelLastName;
    private JTextField inputLastName;
    private JTextField inputStudentID;
    private JLabel labelStudentID;
    private JButton buttonAddStudent;
    private JButton buttonRemoveStudent;
    DefaultListModel<String> listModelStudents;

    public StudentView(){
        setContentPane(panel);
        setTitle("Student Directory");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        listModelStudents = new DefaultListModel<String>();
        listStudents.setModel(listModelStudents);


        buttonAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = inputFirstName.getText();
                String lastName = inputLastName.getText();
                String studentID = inputStudentID.getText();

                if(firstName.isBlank() || lastName.isBlank() || studentID.isBlank()){
                    JOptionPane.showMessageDialog(null, "You Must Fill Out All Fields!");
                    return;
                }

                String student = firstName + " " + lastName + " (" + studentID + ") ";
                listModelStudents.addElement(student);

                inputFirstName.setText("");
                inputLastName.setText("");
                inputStudentID.setText("");

                inputFirstName.grabFocus();
            }
        });
        buttonRemoveStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentIndex = listStudents.getSelectedIndex();
                if (studentIndex < 0){
                    JOptionPane.showMessageDialog(null, "You Must Select A Student From The List!");
                    return;
                }
                listModelStudents.removeElementAt(studentIndex);
            }
        });
    }
}
