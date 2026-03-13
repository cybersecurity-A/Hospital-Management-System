package Hospital_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_Management_System";
    private static final String USER = "root";      // replace with your MySQL username
    private static final String PASS = "#c@de7038";  // replace with your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
