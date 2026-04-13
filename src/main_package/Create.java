package main_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Create {
	Scanner scnr = new Scanner(System.in);
	
	private int id;
	private String name;
	private int age;
	private int result;
	
	public void createUser(){
    //Create
	Main main = new Main();
		
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(main.DB_URL, main.DB_USER, main.DB_PASSWORD);
            Statement stm = con.createStatement();
            
            
            System.out.print("Enter your id: ");
			id = scnr.nextInt();
			scnr.nextLine();
			
			System.out.print("Enter your name: ");
			name = scnr.nextLine();
			
			System.out.print("Enter your age: ");
			age = scnr.nextInt();
			
			System.out.printf("Your id is: %d ,\n Your name is: %s \n Your age is %d \n",id, name , age);
			
			
			
			String query = "INSERT INTO customer values("+id+" , '"+name+"' , "+age+")";
		    
		    result = stm.executeUpdate(query);
		    if(result ==1) {
		    	System.out.println("Use account Created Successfully");
		    }else {
		    	System.out.println("Error!! Please input valid data");
		    }
		            
            //con.close();
            scnr.close();
        }catch(Exception e){
            System.out.println(e);
         
        }
		
		
    
	} 
	/*
	//getters
	public int getID() {
		return this.id = id;
	}
	
	public String getName() {
		return this.name = name;
	}
	
	public int getAge() {
		return this.age = age;
	}
	
	//setters
	public void setID(int id) {
		this.id = id;
	}
	
	public void  setName() {
		this.name = name;
	}
	
	public void setAge() {
		this.age = age;
	} */
	
	
}
