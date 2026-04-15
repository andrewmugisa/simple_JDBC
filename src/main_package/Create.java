package main_package;

import java.sql.*;

public class Create {

	private int result;

	public void createUser(String newName, int newAge, String newPhone, String newPassword){
    
	Main main = new Main();
	signin signin = new signin();
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(main.DB_URL + main.DB_NAME, main.DB_USER, main.DB_PASSWORD);
            Statement stm = con.createStatement();

            String query = "INSERT INTO customer (Name, Age, Phone, Password) VALUES ('"
                    + newName + "', "
                    + newAge + ", '"
                    + newPhone + "', '"
                    + newPassword + "')";
		    
		    result = stm.executeUpdate(query);
		    if(result ==1) {
		    	System.out.println("Use account Created Successfully");
		    	signin.sighnOn();
		    }else {
		    	System.out.println("Error!! Please input valid data");
		    }
		            
        }catch(Exception e){
            System.out.println("Database connection error");
         
        }

	} 	
}
