package Scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStudentTable {
    private static String DB = "jdbc:sqlite:DB/school.db";

    static void main() {
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

}
