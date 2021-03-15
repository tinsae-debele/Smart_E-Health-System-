
package org.eclipse.om2m.smartehealth.main;

import org.eclipse.om2m.commons.constants.Constants;

public class SmartConstants {
	
	private SmartConstants(){}
	
	public static final String POA = "ehealth";
	public static final String DATA = "DATA";
	public static final String DESC = "DESCRIPTOR";
	public static final String AE_NAME = "SMART_E-HEALTH";
	public static final String ACP = "ACCESSCONTROL";
	
	public static String CSE_ID = "/" + Constants.CSE_ID;
	public static String CSE_PREFIX = CSE_ID + "/" + Constants.CSE_NAME;
	public static final boolean GUI = Boolean.valueOf(System.getProperty("org.eclipse.om2m.smartehealth", "true"));
	
}
