
package main_package;

import java.sql.*;
import java.util.Scanner;


public class Java_jdbc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Driver connected successfully");
            
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JDBC_DB", "root", "PASSWORD");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JDBC_DB", "root", "PASSWORD");
           /* 
            //Create
            //System.out.println("connection established");
                    //input data
        System.out.print("Enter your id: ");
        int id = scnr.nextInt();
        scnr.nextLine();
        
        System.out.print("Enter your name: ");
        String name = scnr.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scnr.nextInt();
        
        System.out.printf("Your id is: %d ,\n Your name is: %s \n Your age is %d \n",id, name , age);
        
        scnr.close();
        
        //
            String query = "INSERT INTO customer values("+id+" , '"+name+"' , "+age+")";
            
            stm.executeUpdate(query);
         */  
           
               
            Statement stm = con.createStatement();
            
            
            //Read
            String check, chName;
            int chAge, chId;
            
            check = "SELECT Customer_id, Name, Age FROM customer";
            
        
        
        ResultSet rs = stm.executeQuery(check);
            while(rs.next()){
                chId =rs.getInt("Customer_id");
                chName =rs.getString("Name");
                chAge = rs.getInt("Age");
                System.out.println(chId + " " + chName + " " + chAge);
            }
            
          /*
          
          //Update
          String update = "UPDATE customer SET Name ='Eva' WHERE Customer_id = 1;";
          int updated ; 
          
          updated = stm.executeUpdate(update);
          
          if(updated == 1){
             System.out.println("User Update Successfull"); 
          }else{
              System.out.println("Error!! Please check id");
          }
          
          */
          
          /*
          //Delete
          String Delete = "DELETE FROM customer WHERE Customer_id = 1";
          int result ; 
          
          result = stm.executeUpdate(Delete);
          
          if(result == 1){
             System.out.println("User Delete Successfull"); 
          }else{
              System.out.println("User already deleted/ doesn't exist");
          }
          
         */  
        }catch(Exception e){
           System.out.println(e);
        }
       
        
        

        
    }
    
}
