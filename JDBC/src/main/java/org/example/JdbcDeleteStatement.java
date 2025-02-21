package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDeleteStatement {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL database!");

            // Delete student record
            int studentId = 1; // Change as per requirement
            statement = connection.createStatement();
            String sql = "DELETE FROM student WHERE id = " + studentId;
            int rowsDeleted = statement.executeUpdate(sql);

            System.out.println(rowsDeleted > 0 ? "Student deleted successfully!" : "Delete failed. Student ID not found.");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error.");
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
