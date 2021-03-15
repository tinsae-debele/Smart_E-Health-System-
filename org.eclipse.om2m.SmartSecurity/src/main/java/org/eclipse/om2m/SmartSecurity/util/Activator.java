package org.eclipse.om2m.SmartSecurity.util;

import org.eclipse.om2m.SmartSecurity.controller.AccessController;
import org.eclipse.om2m.SmartSecurity.controller.AuthenticationController;
import org.eclipse.om2m.SmartSecurity.model.AccessControl;
import org.eclipse.om2m.SmartSecurity.model.Authentication;


import java.util.*;
public class Activator {

	public static void main(String args[]) {
		
		AuthenticationController auth = new AuthenticationController();
		//AccessUI access= new AccessUI();
		System.out.println("1 For login and 2 for Signup");
		Scanner in = new Scanner(System.in);
		String set = in.nextLine();
		String [] data = new String [2];
		
		while(true) {
			if (set == "1") {
				//RegisterUI m = new RegisterUI();
				//data = m.register(auth);
				break;
			}
			else if (set == "2") {
				//LoginUI m = new LoginUI();
			//	data = m.Login(auth);
				break;
			}
		}
		
		//AccessController Accesscontroller = new AccessController(new AccessControl(data[0], data[1]), access);
		
		while(true) {
			System.out.println("would you like to access information?");
			System.out.println("if yes then 1 to seek, 2 to get, 3 to modify");
			System.out.println("0 to exit");
			String info = in.nextLine();
			if(info == "0") {}
			
		}
	}
}