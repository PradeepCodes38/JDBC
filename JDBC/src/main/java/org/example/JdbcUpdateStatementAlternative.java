package org.example;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdateStatementAlternative {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/mydb"; // Change DB name
    private static final String USER = "root"; // Change as per your DB
    private static final String PASSWORD = ""; // Change as per your DB

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL database!");

            // Create Statement
            statement = connection.createStatement();

            // Update student details
            int studentId = 1; // Change as per requirement
            String newName = "Alice Johnson";
            int newAge = 26;
            double newMarks = 75.5;

            String sql = "UPDATE student SET name = '" + newName + "', age = " + newAge + ", marks = " + newMarks + " WHERE id = " + studentId;

            int rowsUpdated = statement.executeUpdate(sql);
            System.out.println(rowsUpdated > 0 ? "Student updated successfully!" : "Update failed.");

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
