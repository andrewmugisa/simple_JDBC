package main_package.controller;

public class LoginCredentials {

	    private String phone;
	    private String password;

	    public LoginCredentials(String phone, String password) {
	        this.phone = phone;
	        this.password = password;
	    }
	    
	    public LoginCredentials() {
			// TODO Auto-generated constructor stub
		}
	    
	    
	    public void setPhone(String phone) {
	    	this.phone = phone;
	    }
	    
		public String getPhone() {
	    	return this.phone;
	    }
		
	    
	    public void setPassword(String password) {
	    	this.password = password;
	    }
	    
	    public String getPassword() {
	    	return this.password;
	    }

}
