/*package main_package.service;

import java.util.Scanner;

import main_package.controller.controller;
import main_package.repository.Create;
import main_package.repository.Delete;
import main_package.repository.Read;
import main_package.repository.Update;

public class services {
	Scanner scnr = new Scanner(System.in);
	private String phone = "";
	private String password = "";
	private int id = 0;
	private String name = "";
	private int age = 0;
	private boolean authorised = false;	
	private String input;
	private static String option;
	
	Create create = new Create();
	Read read = new Read();
	Update update = new Update();
	Delete delete = new Delete();
	
	String correctPhone;
	String correctPassword;
	
	private final int maxTries = 3;
	private int tries = 0;
	
	/// ///
	/// ///
	/// ///

	
	/// ///
	/// ///
	/// ///
	/// ///
	
	public void sighnedIn() {
		tries = 0;
		System.out.printf("\nWelcome to CC Bank %s.\n", name);
		
		System.out.println("Here's your profile: " +
				"\n1. Name: " + name +
				"\n2. Phone: " + phone +
				"\n3. Age: " + age +
				"\n4. Password: " + password
				);

		boolean keepAlive = true;
		while(keepAlive) {
		System.out.println("\nWould you like to Update or delete you account! \nuse 1-4 to update or \"del\" To DELETE account");
		input = scnr.nextLine();
		
			switch(input) {
				case "1":
					System.out.print("Enter new name: ");
						name = scnr.nextLine();
						update.setName(name,id); 
					System.out.println("Name updated to: " + name);
					break;
					
				case "2":
					System.out.print("Enter new phone Number: ");
						phone = scnr.nextLine();
						update.setPhone(phone, id);
					System.out.println("Phone updated to: " + phone);
					break;
				case "3":
					System.out.print("Enter new age: ");
						age = scnr.nextInt();
						scnr.nextLine();
						update.setAge(age, id);
					System.out.println("Age updated to: " + age);					
					break;
				case "4": 
					System.out.print("Enter new password: ");
						password =scnr.nextLine();
						update.setPassword(password, id); 
					System.out.println("Password updated to: " + password);
					break;
				case "del":
					System.out.print("Enter \"y\" to confirm delete: ");
					String confirm = scnr.nextLine();
					if (confirm.equals("y")){
						System.out.println("Delete in progress");
						delete.delUser(id);
						System.exit(0);}
					break;
				case "Exit", "exit":
					System.out.print("Program closed");
					scnr.close();
					keepAlive = false;
					break;
				default:
					System.out.print("Invalid Input");
					break;
			}
		}
	}
	
	/// ///
	/// ///
	/// ///

	/// 
	/// 

	public static void main(String[] args) {
		
		services services = new services();
		
		//controller controller = new controller();
		
		System.out.println("Welcome to CC Bank");

  
		
	}
	
}*/

