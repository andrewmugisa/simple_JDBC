package main_package.service;


public class profileService extends authenticationService {
	//private static String password = "";
	//public static String phone = "";
	
	public void sighnedIn(String phone, String password) {
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
		System.out.println("\nWould you like to Update or delete you account! \nuse 1-4 to update or \n");
		System.out.println("Here's your profile: " +
				"\n\"del\" To DELETE Name: " + name +
				"\n\"exit\" To Exit" 
				);
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
						while(read.phoneExists(phone)) {
						    System.out.println("phone already registered\n");
						    System.out.print("Enter new phone Number: ");
							phone = scnr.nextLine();
						}
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



}
