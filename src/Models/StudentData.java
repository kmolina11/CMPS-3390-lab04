package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentData {          //keeps track of students
    private static String DB = "jdbc:sqlite:DB/school.db";

    public StudentData(){                    //initializes list
        String sql = """                            
                CREATE TABLE IF NOT EXISTS Student (
                    id INTEGER UNIQUE NOT NULL,
                    firstName VARCHAR(50) NOT NULL,
                    lastName VARCHAR(50) NOT NULL,
                    gpa DECIMAL(3,2) NOT NULL
                );
                """;

        try(Connection conn = DriverManager.getConnection(DB)) {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Student table created successfully!");
        }catch (SQLException e){            //e variable contains all errors created during the try
            System.out.println("Database error: " + e.getMessage());
        }
    }
    public void addStudent(Student student) throws SQLException {
       Connection conn = DriverManager.getConnection(DB);
       String query = "insert into Student (id, firstName, lastName, gpa) values (?, ?, ?, ?);";
       PreparedStatement ps = conn.prepareStatement(query);     // checks if query is valid agaisnt the format of database

       ps.setInt(1, student.getStudentID());
       ps.setString(2, student.getFirstName());
       ps.setString(3, student.getLastName());
       ps.setDouble(4, student.getGpa());

       ps.execute();
       ps.close();
    }
    public void removeStudent(Student student){
        try(Connection conn = DriverManager.getConnection(DB)) {
            String query = "DELETE FROM Student WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, student.getStudentID());
            ps.execute();
            ps.close();
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students;
        try(Connection conn = DriverManager.getConnection(DB)){
            String query = "SELECT id, firstName, lastName, gpa from Student";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(query);

            students = new ArrayList<Student>();
            while(set.next()){
                Student s = new Student(
                        set.getString("firstName"),
                        set.getString("lastName"),
                        set.getInt("id"),
                        set.getDouble("gpa")
                );
                students.add(s);
                stmt.close();
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
            return students;
    }
}
