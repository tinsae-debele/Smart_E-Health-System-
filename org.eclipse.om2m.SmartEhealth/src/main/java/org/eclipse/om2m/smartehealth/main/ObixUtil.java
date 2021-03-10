/*******************************************************************************
 * Copyright (c) 2013-2020 LAAS-CNRS (www.laas.fr)
 * 7 Colonel Roche 31077 Toulouse - France
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Initial Contributors:
 *     Thierry Monteil : Project manager, technical co-manager
 *     Mahdi Ben Alaya : Technical co-manager
 *     Samir Medjiah : Technical co-manager
 *     Khalil Drira : Strategy expert
 *     Guillaume Garzone : Developer
 *     François Aïssaoui : Developer
 *
 * New contributors :
 *******************************************************************************/
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
		/*
		 * 
		 */
		// OP GetState from SCL IPU
		Op opStateDirect = new Op();
		opStateDirect.setName("getState(Direct)");
		opStateDirect.setHref(new Uri(prefix + "?op="+ Operations.GET_STATE_DIRECT+"&lampid=" + appId));
		opStateDirect.setIs(new Contract("execute"));
		opStateDirect.setIn(new Contract("obix:Nil"));
		opStateDirect.setOut(new Contract("obix:Nil"));
		obj.add(opStateDirect);
		
		// OP SwitchON
		Op opON = new Op();
		opON.setName("switchON");
		opON.setHref(new Uri(prefix + "?op="+ Operations.SET_ON +"&lampid=" + appId));
		opON.setIs(new Contract("execute"));
		opON.setIn(new Contract("obix:Nil"));
		opON.setOut(new Contract("obix:Nil"));
		obj.add(opON);
		

		Op opOFF = new Op();
		opOFF.setName("switchOFF");
		opOFF.setHref(new Uri(prefix  + "?op=" + Operations.SET_OFF + "&lampid=" + appId));
		opOFF.setIs(new Contract("execute"));
		opOFF.setIn(new Contract("obix:Nil"));
		opOFF.setOut(new Contract("obix:Nil"));
		obj.add(opOFF);
		// OP Toggle

		Op opToggle = new Op();
		opToggle.setName("toggle");
		opToggle.setHref(new Uri(prefix + "?op="+ Operations.TOGGLE +"&lampid=" + appId));
		opToggle.setIs(new Contract("execute"));
		opToggle.setIn(new Contract("obix:Nil"));
		opToggle.setOut(new Contract("obix:Nil"));
		obj.add(opToggle);
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
	/*
	public static String createLampAllDescriptor(){
		String prefix = SmartConstants.CSE_ID +"/"+ Constants.CSE_NAME + "/" + "LAMP_ALL";
		Obj descriptor = new Obj();
		Op opSwitchOn = new Op();
		opSwitchOn.setName(Operations.SET_ON.toString());
		opSwitchOn.setHref(prefix + "?op="+ Operations.ALL_ON);
		opSwitchOn.setIs(new Contract("execute"));
		descriptor.add(opSwitchOn);

		Op opSwitchOff = new Op();
		opSwitchOff.setName(Operations.SET_OFF.toString());
		opSwitchOff.setHref(prefix + "?op=" + Operations.ALL_OFF);
		opSwitchOff.setIs(new Contract("execute"));
		descriptor.add(opSwitchOff);

		Op opToggleAll = new Op();
		opToggleAll.setName(Operations.ALL_TOGGLE.toString());
		opToggleAll.setHref(prefix + "?op=" + Operations.ALL_TOGGLE);
		opToggleAll.setIs(new Contract("execute"));
		descriptor.add(opToggleAll);
		return ObixEncoder.toString(descriptor);
	}
	*/
	
}
