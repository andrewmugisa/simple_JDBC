package main_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Update {
	Main main = new Main();
	
    public void updateData(String query) {
    	
		try
	    {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(main.DB_URL + main.DB_NAME, main.DB_USER, main.DB_PASSWORD);
	        Statement stm = con.createStatement();
	        
		    //query = "UPDATE customer SET Name ='Eva' WHERE Customer_id = 1;";
		    int updated ; 
		    
		    updated = stm.executeUpdate(query);
		    
			    if(updated == 1){
			       System.out.println("Success"); 
			    }else{
			        System.out.println("Erro!!");
			    }
	    }catch(Exception e){
	        System.out.println(e);
	     
	    }
	
    }
    
    //Name, Age, Phone, Password
    
    	public void setName(String name, int id){			
			updateData("UPDATE customer SET Name ='"+name+"' WHERE Customer_id = "+id);
		}
    	
	    public void setPhone(String phone, int id){			
			updateData("UPDATE customer SET Phone ='"+phone+"' WHERE Customer_id = "+id);
	    }
	    
	    public void setAge(int age, int id){			
			updateData("UPDATE customer SET Age ='"+age+"' WHERE Customer_id = "+id);
	    }
	    
	    public void setPassword(String password, int id){
			updateData("UPDATE customer SET Password ='"+password+"' WHERE Customer_id = "+id);
	    }
	    
}
