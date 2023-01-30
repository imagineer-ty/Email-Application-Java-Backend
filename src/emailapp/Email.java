package emailapp;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	//constructor to receive first name and last name
	public Email(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
	//System.out.println("Email created: " + this.firstName + " " + this.lastName);
	
	//call a method asking for department - returns dept.
	this.department = setDepartment();
	//System.out.println("Department: " + this.department);
	//call a method that returns random password
	this.password = randomPassword(defaultPasswordLength);
	System.out.println("Your password is " + this.password);
	
	//combine elements to generate email 
	email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	System.out.println("Your email is: " + email);
 	}
	//ask for the department
	private String setDepartment() {
		System.out.print("New Employee: " + firstName + "\nDepartment Codes:\nEnter the department\n1 for sales\n2 for development\n3 for accounting\n0 for none.");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if(deptChoice == 1) {
			return "sales";
		}
		else if(deptChoice == 2) {
			return "dev";
		}
		else if(deptChoice == 3) {
			return "acct";
		}
		else {
			return " ";
		}
	}
	//generate password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
		char[] password = new char[length];
		for(int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String (password);
	}
	
	
	//set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	//set alt email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	//change password
	public void changePassword(String password) {
		this.password = password;
	}
	public int getMailboxCapacity() { 
		return mailboxCapacity;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public String getPassword() {
		return password;
	}
	public String dispInfo() {
		return "Display name: " + firstName + " " + lastName +
			   "\nCompany email: " + email +
			   "\nMailbox capacity: " + mailboxCapacity;
		
	}
}


