package main_package.repository;

import java.sql.*;

import main_package.Main;

public class Read { 
    //Read
	private int id;
	private String name;
	private int age;
	private String phone;
	private String password;
    private String check;
    
    Main main = new Main();
    
    /// ///
    /// ///
    /// ///
    
    public void setPhone(String phone){
    	this.phone = phone;
    }
    public void setPassword(String password){
    	this.password = password;
    }
    
    /// ///
    /// ///
    /// ///
    
    public void readData() {
	    try
	    {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(main.DB_URL + main.DB_NAME, main.DB_USER, main.DB_PASSWORD);
	        Statement stm = con.createStatement();
	    
	        check = "SELECT Customer_id, Name, Age, Phone, Password FROM customer WHERE Phone = '"+phone+"' AND Password = '"+password+"' ";
	        
	
	
	        ResultSet rs = stm.executeQuery(check);
		    	while(rs.next())
		    	{
			        this.id =rs.getInt("Customer_id");
			        this.name =rs.getString("Name");
			        this.age = rs.getInt("Age");
			        this.phone= rs.getString("Phone");
			        this.password = rs.getString("Password");
			        //System.out.println(this.id + " " + this.name + " " + this.age + " " + this.phone + " "+ " " + this.password + " ");
			    }
	    }catch(Exception e){
	        //System.out.println(e);
	     
	    }

    }
    
    public boolean phoneExists(String phone) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                main.DB_URL + main.DB_NAME,
                main.DB_USER,
                main.DB_PASSWORD
            );

            String sql = "SELECT Phone FROM customer WHERE Phone = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, phone);

            ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();

            rs.close();
            ps.close();
            con.close();

            return exists;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    
    /// ///
    /// ///
    /// ///
    
    
       //getters
	    public int getId(){
	    	return this.id;
	    }
	    
	    public String getName(){
	    	return this.name;
	    }
	    
	    public int getAge(){
	    	return this.age;
	    }
		
	    public String getPhone(){
	    	return this.phone;
	    }
	    
	    public String getPassword(){
	    	return this.password;
	    }
    
    
}
