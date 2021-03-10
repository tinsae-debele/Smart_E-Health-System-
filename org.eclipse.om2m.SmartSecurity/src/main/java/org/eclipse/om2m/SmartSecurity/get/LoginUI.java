
package org.eclipse.om2m.SmartSecurity.get;
import java.util.Scanner;

import javax.swing.*;

import org.eclipse.om2m.SmartSecurity.controller.AuthenticationController; 
public class LoginUI {

	
	
	public LoginUI() {}
	
	public String [] Login(AuthenticationController auth) {
		Scanner in = new Scanner(System.in);
		String [] data = new String [2];
		
		System.out.println("Please enter username");
		
		 data[0] = in.nextLine();
		
	    System.out.println("Please enter password");
		
		String pass = in.nextLine();	
		
		 data[1] = auth.setUserNameandRole(data[0]);
		
		return data;
		//addInfo(String Username,String password,String role, String contactinfo,String address,String healthCardNumber,String medicaliinfo) 
		
		//and all other values for database
		
	}

}
