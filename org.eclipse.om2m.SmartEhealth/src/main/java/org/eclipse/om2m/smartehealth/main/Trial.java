package org.eclipse.om2m.smartehealth.main;

import org.eclipse.om2m.SmartSecurity.controller.AuthenticationController;
import org.eclipse.om2m.SmartSecurity.model.Authentication;

public class Trial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   String Username = "tinsae" ;
		   String password = "Tinsae82@" ;
		   String role = "Doctor";
		   String contactinfo = "tindebeb94@gmail.com";
		   String address = "601 Laurier" ;
		   String healthCardNumber = "101010" ;
		   String medicaliinfo = "triatment";
		
	
			Authentication encPwd = new Authentication();
			String[] returnVa;
			
			
			String medicalliinfo2 = encPwd.addInfo(Username,password,role,contactinfo,address,healthCardNumber);
			
			AuthenticationController auth = new AuthenticationController();
			System.out.println("value :" + auth.checkPassword(Username, password, medicalliinfo2));
			//System.out.println("salt :" + authoA[1]);
			//System.out.println(Password.getNextSalt());
		
	}

}