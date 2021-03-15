
package org.eclipse.om2m.smartehealth.main;

import org.eclipse.om2m.SmartSecurity.controller.EncryptAndDecrypt;
import org.eclipse.om2m.commons.constants.MimeMediaType;
import org.eclipse.om2m.commons.constants.ShortName;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.eclipse.om2m.commons.resource.ResponsePrimitive;
import org.eclipse.om2m.core.service.CseService;


public class SmartController {
	
	public static CseService CSE;
	protected static String AE_ID;
	
	public static void setPatient(String appID, String randIdNum,String namePatient, String loc , String treatType, String preOrder, String phName , String addrs , String ref){
		// Set the value in the "real world" model
			// Send the information to the CSE
		String targetID = SmartConstants.CSE_PREFIX + "/" + appID + "/" + SmartConstants.DATA ;
		ContentInstance cin = new ContentInstance();
		//encryption 
		EncryptAndDecrypt decEnc = new EncryptAndDecrypt();
		String hcardNum = decEnc.encrypt(randIdNum);
		namePatient = decEnc.encrypt(namePatient);
		loc = decEnc.encrypt(loc);
		treatType = decEnc.encrypt(treatType);
		preOrder = decEnc.encrypt(preOrder);
		phName = decEnc.encrypt(phName);
		addrs = decEnc.encrypt(addrs);
		ref = decEnc.encrypt(ref);
		cin.setContent(ObixUtil.getStateRep(appID, hcardNum,namePatient, loc , treatType, preOrder, phName , addrs , ref));
		cin.setName(randIdNum);
		cin.setContentInfo(MimeMediaType.OBIX + ":" + MimeMediaType.ENCOD_PLAIN);
		RequestSender.createContentInstance(targetID, cin);
	}
	
	public static void addUserInfo(String appID,String firstName, String lastName , String UserName , String role , String userData ){
		// Set the value in the "real world" mode
			// Send the information to the CSE
		String targetID = SmartConstants.CSE_PREFIX + "/" + appID + "/" + SmartConstants.ACP;
		ContentInstance cin = new ContentInstance();
		//encryption 
		EncryptAndDecrypt decEnc = new EncryptAndDecrypt();
		//namePatient = decEnc.encrypt(namePatient);
		//loc = decEnc.encrypt(loc);
		//treatType = decEnc.encrypt(treatType);
		//preOrder = decEnc.encrypt(preOrder);
		//phName = decEnc.encrypt(phName);
		//addrs = decEnc.encrypt(addrs);
		 userData = decEnc.encrypt(userData);
		cin.setContent(ObixUtil.getAccessControlRep(firstName, lastName ,UserName, role , userData));
		cin.setName(UserName);
		cin.setContentInfo(MimeMediaType.OBIX + ":" + MimeMediaType.ENCOD_PLAIN);
		RequestSender.createContentInstance(targetID, cin);
	}

	
	public static ResponsePrimitive getData(String appID, String randNum) {
		String str = randNum;
		String targetId = SmartConstants.CSE_PREFIX + "/" + appID + "/" + SmartConstants.DATA +"/" + str;
		return RequestSender.getRequest(targetId);
	}
	public static ResponsePrimitive getUser(String appID, String randNum) {
		String str = randNum;
		String targetId = SmartConstants.CSE_PREFIX + "/" + appID + "/" + SmartConstants.ACP +"/" + str;
		return RequestSender.getRequest(targetId);
	}
	
	public static void addData(String randIdNum,String namePatient, String loc , String treatType, String preOrder, String phName, String addrs , String ref ){
		setPatient(SmartConstants.AE_NAME,randIdNum,namePatient, loc , treatType, preOrder, phName , addrs , ref );
	}
	public static void addUser(String firstName, String lastName , String UserName, String role , String userPwdDATA) {
		addUserInfo(SmartConstants.AE_NAME,firstName, lastName ,UserName, role , userPwdDATA);
	}

	
	public static void setCse(CseService cse){
		CSE = cse;
	}
	
	
}
