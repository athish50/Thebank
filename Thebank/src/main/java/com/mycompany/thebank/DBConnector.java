package com.mycompany.thebank;

import java.sql.*;

public class DBConnector {

    // Database URL
    // Example path for Firebird database
    private static final String URL =
            "jdbc:firebirdsql://localhost:3050/C:/DB/TEST.FDB";

    
    // Firebird username & password
    private static final String USER = "SYSDBA";
    private static final String PASSWORD = "athishthegoat";

    // Method to create database connection
    public static Connection getConnection() {
        Connection conn = null;

        try {
            // Load Firebird JDBC driver
            Class.forName("org.firebirdsql.jdbc.FBDriver");

            // Create connection

            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected to Firebird database!");

        } catch (ClassNotFoundException e) {
            System.out.println("Firebird JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }

        return conn;
    }

    // Optional test main method
    public static void main(String[] args) {
        Connection conn = getConnection();

        if (conn != null) {
            System.out.println("Connection successful!");
        }
    }
}
