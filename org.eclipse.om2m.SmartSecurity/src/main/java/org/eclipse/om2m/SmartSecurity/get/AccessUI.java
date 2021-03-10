package org.eclipse.om2m.SmartSecurity.get;

import java.util.Scanner;

import org.eclipse.om2m.SmartSecurity.controller.AuthenticationController;

public class AccessUI {


	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter username");
		
		String user = in.nextLine();
		
	System.out.println("Please enter password");
		
		String pass = in.nextLine();
		
	System.out.println("Please enter role");
		
		String role = in.nextLine();
		
		
		AuthenticationController auth = new AuthenticationController();
		//addInfo(String Username,String password,String role, String contactinfo,String address,String healthCardNumber,String medicaliinfo) 
		
		//and all other values for database
		
	}
}
