package main_package.service;


import java.util.Scanner;

import main_package.controller.LoginCredentials;
import main_package.controller.controller;
import main_package.repository.Create;
import main_package.repository.Delete;
import main_package.repository.Read;
import main_package.repository.Update;

public class authenticationService{

	
	
	//==============================Variables====================================================
	static 
	Scanner  scnr = new Scanner(System.in);
	//variable private to this class
	//private static String password = "";
	public static int id = 0;
	public static String name = "";
	public static int age = 0;
	public static boolean authorised = false;	
	public static String input;
	public static String option;
	public static final int maxTries = 3;
	public static int tries = 0;
	
	
	//LoginCredentials LoginCredentials = new LoginCredentials();
	static Create create = new Create();
	static Read read = new Read();
	static Update update = new Update();
	static Delete delete = new Delete();
	
	static String correctPhone;
	static String correctPassword;
	
	
	//==============================Redirect=====================================================
	//keep asking user login/ register until correct option is selected and send to controller
	public static String redirect(String option) {
		tries = 0;
		if(option.equals("1")) {
			return controller.controlSwitch("/login");
			
		}else if (option.equals("2")) {
			return controller.controlSwitch("/register");
		}
		return controller.controlSwitch("/redirect");	
	}
	
	
	/// ////
	/// ///=========login============================
	/// ///
	public static String login(String phone, String password) {
		while(tries < maxTries) {
			read.setPhone(phone);
			read.setPassword(password);

			read.readData();
			
			correctPhone = read.getPhone();
			correctPassword = read.getPassword();
	        if (read.getId() != 0) {  //user found
				if(phone.equals(correctPhone) && password.equals(correctPassword)) {
					System.out.println("Hello, " + read.getName() + ". Login was successful.");
					phone = read.getPhone();
					password =read.getPassword();
					id = read.getId();
					name = read.getName();
					age = read.getAge();
					authorised = true;
					controller.creds = new LoginCredentials(phone, password);
					return controller.controlSwitch("/profile");
					}
				}else {
					tries++;
					if(tries < maxTries) {
					System.out.println("Incorrect phone number or password. Let's try again.");
					return controller.controlSwitch("/login");
					}                
				}
	        }
		if (tries == maxTries) {
			System.out.println("Sorry you have 3 incorrent tries. \nForgot password or Phone Number!, click here.\n");
			redirect("null");
			//System.exit(0);
		}
		return controller.controlSwitch("/login");
	}
	
	/// ////
	/// ///=========create Account============================
	/// ///
	public void createAccount() {
		tries = 0;
		//Name, Age, Phone, Password
		System.out.println("-----CREATE ACCOUNT-----");
		System.out.print("Enter new name: ");
		String newName = scnr.nextLine();
		
		System.out.print("Enter your age: ");
		int newAge = scnr.nextInt();
		scnr.nextLine();
		
		System.out.print("Enter new phone: ");
		String newPhone =scnr.nextLine();
		while(read.phoneExists(newPhone)) {
		    System.out.println("phone already registered\n");
		    System.out.print("Enter new phone: ");
		    newPhone =scnr.nextLine();
		}
		
		System.out.print("Enter new password: ");
		String newPassword =scnr.nextLine();
		create.createUser(newName, newAge, newPhone, newPassword );
		authenticationService.login(newPhone, newPassword);
	}



	/// ////
	/// ///=========Load Profile============================
	/// ///
	

}
