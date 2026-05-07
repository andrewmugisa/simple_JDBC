package main_package;

import java.util.Scanner;
import main_package.controller.LoginCredentials;


public class ccBankApplication {
	static Scanner scnr = new Scanner(System.in);
		
	public static String redirectUi() {
		String option;
        System.out.println("Please select: "
        		+ "\n1. Signin"
        		+ "\n2. Register");
        option = scnr.nextLine();
       return option; 
	}
	
	LoginCredentials LoginCredentials;
	public static LoginCredentials loginUi() {
		String phone;
		String password;
		
		System.out.println("-----LOGIN-----");
		System.out.println("Enter phonenumber: ");
		phone = scnr.nextLine();
		
		System.out.println("Enter password: ");
		password = scnr.nextLine();
		
		return new LoginCredentials(phone, password);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Welcome to CC Bank");
		//redirectUi();
	}


}
