package main_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Main {
//previous version is confirmed to work //Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JDBC_DB", "root", "PASSWORD");
    // Database connection details
    public final String DB_URL = "jdbc:mysql://localhost/";
    public final String DB_USER = "root";
    public final String DB_PASSWORD = "PASSWORD";
    public final String DB_NAME = "JDBC_DB";  // Desired database name

    public static void main(String[] args) {
       Main main = new Main();

        // Step 1: Create database if it doesn't exist
        main.createDatabase();

        // Step 2: Create tables if they don't exist
        main.createTables();

        // Step 3: Perform CRUD operations (as needed)
        signin signin = new signin();
        signin.main(args);
      //  Create create = new Create();
        // create.createUser(); // Uncomment to create a new user

        Read read = new Read();
        read.readData();

        //Update update = new Update();
        // update.updateData(); // Uncomment to update data
    }
    

    // Method to create the database
    public void createDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            // Check if the database exists, create it if not
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
            stmt.executeUpdate(createDatabaseSQL);
            System.out.println("Database " + DB_NAME + " is ready.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    // Method to create tables if they don't exist
    public void createTables() {
        try (Connection conn = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {

            // Example of a user table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS customer ("
                    + "Customer_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "Name VARCHAR(100) NOT NULL, "
                    + "Phone VARCHAR(15) NOT NULL, "
                    + "Password VARCHAR(100) NOT NULL, "
                    + "Age INT NOT NULL) ";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'customer' is ready.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}