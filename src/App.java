import Controllers.StudentController;
import Models.StudentData;
import Views.StudentView;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    static void main() {
        if (checkDrivers()) {
            StudentData model = new StudentData();
            StudentView view = new StudentView();

            new StudentController(model, view);

            view.setVisible(true);
        }
    }
        private static boolean checkDrivers(){
            try{
                Class.forName("org.sqlite.JDBC");
                DriverManager.registerDriver(new org.sqlite.JDBC());
                return true;
            }catch (ClassNotFoundException | SQLException e){
                System.out.println("Could not start SQLite Drivers");
                System.out.println(e.getMessage());
                return false;
            }
        }
    }

