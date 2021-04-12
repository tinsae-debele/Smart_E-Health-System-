package org.eclipse.om2m.SmartSecurity.controller;

import org.eclipse.om2m.SmartSecurity.model.AccessControl;


public class AccessController {
	private AccessControl model;
	//private AccessUI view;
	
	String [] Title = {"technical support","Patient","Nurse","Doctor"};
	String [] Objects = {"PatientPersonalInfo","PatientMedicalInfo","StaffInfo"};
	String [] Access = {"0211","0112","2111"};
	String [] Actions = {"seek","get","modify"};
	LinkedList [] locations = new LinkedList[3];
 	public AccessController() {

		//this.view = view;
		
		for(int i = 0; i < locations.length;i++) {
			locations[i] = new LinkedList(Objects[i],Title,Access[i]);
		}
	}

	public boolean checkAccess (String requester, String obj, String action){
		for(int i = 0; i < locations.length;i++) {
			if(locations[i].listname.equalsIgnoreCase(obj)) {
				if(locations[i].GrantAccess(requester,action)) {
				System.out.println("ACCESS GRANTED");
				return true;
				}
				else {
					System.out.println("ACCESS DENIED");
					break;
				}
			}
		}
		return false;
	}
}