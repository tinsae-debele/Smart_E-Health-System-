
package org.eclipse.om2m.smartehealth.main;

import org.eclipse.om2m.commons.constants.Constants;
import org.eclipse.om2m.commons.constants.ShortName;
import org.eclipse.om2m.commons.obix.Bool;
import org.eclipse.om2m.commons.obix.Contract;
import org.eclipse.om2m.commons.obix.Obj;
import org.eclipse.om2m.commons.obix.Op;
import org.eclipse.om2m.commons.obix.Str;
import org.eclipse.om2m.commons.obix.Uri;
import org.eclipse.om2m.commons.obix.io.ObixEncoder;

public class ObixUtil {
	
	/**
	 * Returns an obix XML representation describing the lamp.
	 * @param cseId - SclBase id
	 * @param appId - Application Id
	 * @param stateCont - the STATE container id
	 * @return Obix XML representation
	 */
	public static String getDescriptorRep(String cseId, String appId, String stateCont) {
		String prefix = cseId+"/"+ Constants.CSE_NAME + "/" + appId;
		// oBIX
		Obj obj = new Obj();
		obj.add(new Str("Location",StatusRecord.LOCATION));
		
		/**
		obj.add(new Str("Patient name",StatusRecord.nameOfPatient ));
		obj.add(new Str("Health Card Number",StatusRecord.HEALTHCARDNUM));
		obj.add(new Str("Physician Name",StatusRecord.nameOfPhysician));
		obj.add(new Str("Type of Treatment",StatusRecord.typeOfTreatment));
		*/
		
		obj.add(new Str("appId",appId));
		
		
		// OP GetState from SCL DataBase'
		
		Op opState = new Op();
		opState.setName("getState");
		opState.setHref(new Uri(prefix  +"/"+SmartConstants.DATA+"/"+ ShortName.LATEST));
		opState.setIs(new Contract("retrieve"));
		opState.setIn(new Contract("obix:Nil"));
		opState.setOut(new Contract("obix:Nil"));
		obj.add(opState);
		
		return ObixEncoder.toString(obj);
	}

	/**
	 * Returns an obix XML representation describing the current state.
	 * @param lampId - Application Id
	 * @param value - current lamp state
	 * @return Obix XML representation
	 */
	
	public static String getStateRep(String lampId, boolean value) {
		// oBIX
		Obj obj = new Obj();
		obj.add(new Str("Date of birth",StatusRecord.LOCATION));
		obj.add(new Str("Patient name",StatusRecord.nameOfPatient ));
		obj.add(new Str("Health Card Number",StatusRecord.HEALTHCARDNUM));
		obj.add(new Str("Physician Name",StatusRecord.nameOfPhysician));
		obj.add(new Str("Prescription",StatusRecord.prescription));
		obj.add(new Str("Type of Treatment",StatusRecord.typeOfTreatment));
		return ObixEncoder.toString(obj);
		
	}
	
	
	public static String getStateRep(String appID, String randIdNum, String namePatient, String loc , String treatType, String  preOrder, String phName , String addrs , String ref) {
		// oBIX
		String prefix = Constants.CSE_ID+"/"+ Constants.CSE_NAME + "/" + appID;
		String strID = "" + randIdNum;
		Obj obj = new Obj();
		obj.add(new Str("Date of birth",loc));
		obj.add(new Str("Patient name",namePatient));
		obj.add(new Str("Health Card Number", strID));
		obj.add(new Str("Physician Name",phName));
		obj.add(new Str("Prescription",preOrder));
		obj.add(new Str("Type of Treatment",treatType));
		obj.add(new Str("Address" , addrs));
		obj.add(new Str("Doc Referral" , ref));
		
		Op opState = new Op();
		opState.setName("getState");
		opState.setHref(new Uri(prefix  +"/"+SmartConstants.DATA+"/"+ ShortName.LATEST));
		opState.setIs(new Contract("retrieve"));
		opState.setIn(new Contract("obix:Nil"));
		opState.setOut(new Contract("obix:Nil"));
		obj.add(opState);
		return ObixEncoder.toString(obj);
		
	}
	
	public static String getAccessControlRep(String firstName, String lastName , String UserName, String role, String salt) {
		Obj obj = new Obj();
		obj.add(new Str("Username",UserName));
		obj.add(new Str("Name", firstName + " " + lastName));
		obj.add(new Str("Role",role));	
		obj.add(new Str("User Data", salt));
		return ObixEncoder.toString(obj);
	}
	
	
}
