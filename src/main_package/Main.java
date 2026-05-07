package main_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import main_package.controller.controller;

import java.sql.SQLException;

public class Main {
	// Database connection details (will be loaded from .env)
	public final String DB_URL = System.getProperty("MYSQL_URL", "jdbc:mysql://localhost/");
	public final String DB_USER = System.getProperty("MYSQL_USER", "root");
	public final String DB_PASSWORD = System.getProperty("MYSQL_PASSWORD", "");
	public final String DB_NAME = System.getProperty("MYSQL_DATABASE", "JDBC_DB");

	
	
	
	
	
	
	
  
	public static void main(String[] args) {
    	//EnvLoader EnvLoader = new EnvLoader();
    	//load .env file with the loader
        EnvLoader.load(".env");
        
        //initialise main to be able to use its methods
       Main main = new Main();
       
        // Step 1: Create database if it doesn't exist
        main.createDatabase();

        // Step 2: Create tables if they don't exist
        main.createTables();
       
        System.out.println("\nWelcome to CC Bank\n"
        		+ "");
		// Step 3: Call contolswitch passing in redirect
        controller.controlSwitch("/redirect");
    
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