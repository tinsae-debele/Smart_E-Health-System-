package org.eclipse.om2m.SmartSecurity.get;
import java.util.Scanner;

import org.eclipse.om2m.SmartSecurity.controller.AuthenticationController;
public class RegisterUI {
	
	public RegisterUI() {}
	
	public  String [] register(AuthenticationController auth){
		Scanner in = new Scanner(System.in);
		String [] data = new String [2];
		String user;
		while(true) {
		System.out.println("Please enter username");
		user = in.nextLine();
		
		if(auth.checkUser(user))
			break;
		else
			System.out.println("Username taken");
		}
		
		data[0] = user;
		
		System.out.println("Please enter password");
			
		String pass = in.nextLine();
			
		System.out.println("Please enter role");
			
		String role = in.nextLine();
			
		data[1] = auth.setUserNameandRole(data[0]);
			
		in.close();
		//and all other values for database
		return data;
	}

}
