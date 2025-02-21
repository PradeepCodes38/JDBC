package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsertStatement {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/mydb"; // Change DB name
    private static final String USER = "root"; // Change as per your DB
    private static final String PASSWORD = ""; // Change as per your DB

    public static void main(String[] args) {


        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL database!");

            // Insert user
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO student (name, age,marks) VALUES ('Bob Williams', 25,50.6)";
            int rowsInserted = statement.executeUpdate(sql);

            System.out.println(rowsInserted > 0 ? "User inserted successfully!" : "Insert failed.");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error.");
            e.printStackTrace();
        }
    }
}
