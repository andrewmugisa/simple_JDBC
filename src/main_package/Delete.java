package main_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {
	Main main = new Main();
	
	
	public void delUser(int id) {
		delete("DELETE FROM customer WHERE Customer_id ="+id);
	}
	
	public void delete(String query) {

		try
	    {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(main.DB_URL, main.DB_USER, main.DB_PASSWORD);
	        Statement stm = con.createStatement();

		    int result ; 
		    
		    result = stm.executeUpdate(query);
	    
		    if(result == 1){
		       System.out.println("User Delete Successfull"); 
		    }else{
		        System.out.println("User already deleted/ doesn't exist");
		    }
	    }catch(Exception e){
	        System.out.println(e);
	     
	    }
    
	}

}
