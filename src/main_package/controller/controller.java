package main_package.controller;

import main_package.ccBankApplication;
import main_package.service.*;

public class controller {
	static authenticationService authenticationService = new authenticationService();
	static profileService profileService = new profileService();
	public static LoginCredentials creds;
	
	@SuppressWarnings("static-access")
	public static String controlSwitch(String path) {
		switch(path) {
		case "/redirect":
			authenticationService.redirect(ccBankApplication.redirectUi());
			break;
		case "/login":
			creds = ccBankApplication.loginUi();
			authenticationService.login(creds.getPhone(), creds.getPassword());
			break;
		case "/register":
			authenticationService.createAccount();
			break;
		case "/profile":
			profileService.sighnedIn(creds.getPhone(), creds.getPassword());
			//profileService.sighnedIn();
			break;
		}
		
		return "something";
	}

}
