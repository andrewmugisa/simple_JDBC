package main_package;

import java.util.Scanner;

public class signin {
	Scanner scnr = new Scanner(System.in);
	private String phoneNumber = "";
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
	
	public void createAccount() {
		//Name, Age, Phone, Password
		System.out.println("-----CREATE ACCOUNT-----");
		System.out.print("Enter new name: ");
		String newName = scnr.nextLine();
		
		System.out.print("Enter your age: ");
		int newAge = scnr.nextInt();
		scnr.nextLine();
		
		System.out.print("Enter new phone: ");
		String newPhone =scnr.nextLine();
		
		System.out.print("Enter new password: ");
		String newPassword =scnr.nextLine();
		create.createUser(newName, newAge, newPhone, newPassword );
	}
	
	
	
	/// ////JDBC1
	/// ///
	/// ///
	public void sighnOn() {
		tries = 0;
		while(tries < maxTries) {
			System.out.println("-----SIGHN ON-----");
			System.out.println("Enter phonenumber: ");
			phoneNumber = scnr.nextLine();
			read.setPhone(phoneNumber);
			
			System.out.println("Enter password: ");
			password = scnr.nextLine();
			read.setPassword(password);
			
			read.readData();
			
			correctPhone = read.getPhone();
			correctPassword = read.getPassword();
	        if (read.getId() != 0) {  //user found
				if(phoneNumber.equals(correctPhone) && password.equals(correctPassword)) {
					System.out.println("Hello, " + read.getName() + ". Login was successful.");
					phoneNumber = read.getPhone();
					password =read.getPassword();
					id = read.getId();
					name = read.getName();
					age = read.getAge();
					authorised = true;
					sighnedIn();
					break;
					}
				}else {
					tries++;
					if(tries < maxTries) {
					System.out.println("Incorrect phone number or password. Let's try again.");	
					}                
				}
	        }
		if (tries == maxTries) {
			System.out.println("Sorry you have 3 incorrent tries. \nForgot password or Phone Number!, click here.\n");
			redirect();
			//System.exit(0);
		}
	}
	
	/// ///
	/// ///
	/// ///
	/// ///
	
	public void sighnedIn() {
		tries = 0;
		System.out.printf("\nWelcome to CC Bank %s.\n", name);
		
		System.out.println("Here's your profile: " +
				"\n1. Name: " + name +
				"\n2. Phone: " + phoneNumber +
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
						phoneNumber = scnr.nextLine();
						update.setPhone(phoneNumber, id);
					System.out.println("Phone updated to: " + phoneNumber);
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
	
	public void redirect() {
		tries = 0;
        System.out.println("Please select: "
        		+ "\n1. Signin"
        		+ "\n2. Register");
        
        option = scnr.nextLine();
		if(option.equals("1")) {
			if(authorised) {
				sighnedIn();
			}else {
				sighnOn();
			}
			
		}else if (option.equals("2")) {
			createAccount();
		}else {
			redirect();
		}
	}
	/// 
	/// 
	/// 

	public static void main(String[] args) {
		
		signin signin = new signin();
		
		System.out.println("Welcome to CC Bank");

        signin.redirect();
		
	}
	
}

