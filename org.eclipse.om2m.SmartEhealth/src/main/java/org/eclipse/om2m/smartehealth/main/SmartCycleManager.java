
package org.eclipse.om2m.smartehealth.main;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.commons.constants.MimeMediaType;
import org.eclipse.om2m.commons.constants.ResponseStatusCode;
import org.eclipse.om2m.commons.resource.AE;
import org.eclipse.om2m.commons.resource.Container;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.eclipse.om2m.commons.resource.ResponsePrimitive;
import org.eclipse.om2m.smartehealth.gui.loginFrame;




public class SmartCycleManager {

	private static Log LOGGER = LogFactory.getLog(SmartCycleManager.class);
	private static Scanner sc;
	private static String namePatient;
	private static String loc;
	private static String treatType; 

	/**
	 * Handle the start of the plugin with the resource representation and the GUI
	 */
	public static void start(){
		
		// Create initial resources for smart health
	
		String appID = "SMART_E-HEALTH";
		createSmartResources(appID, false, SmartConstants.POA);
	
		
		//startInterface(appID);
		
		if(SmartConstants.GUI){
			loginFrame.init();
		}


	}

	/**
	 * Stop the GUI if it is present
	 */
	public static void stop(){
		
	}

	/**
	 * Creates all required resources.
	 * @param appId - Application ID
	 * @param initValue - initial lamp value
	 * @param poa - lamp Point of Access
	 */
	private static void createSmartResources(String appId, boolean initValue, String poa) {
		// Create the Application resource
		Container container = new Container();
		container.getLabels().add("smart_E-HEALTH");
		container.setMaxNrOfInstances(BigInteger.valueOf(0));
		

		AE ae = new AE();
		ae.setRequestReachability(true);
		ae.getPointOfAccess().add(poa);
		ae.setAppID(appId);
		ae.setName(appId);

		ResponsePrimitive response = RequestSender.createAE(ae);
		// Create Application sub-resources only if application not yet created
		if(response.getResponseStatusCode().equals(ResponseStatusCode.CREATED)) {
			container = new Container();
			container.setMaxNrOfInstances(BigInteger.valueOf(10));
			// Create DESCRIPTOR container sub-resource
			container.setName(SmartConstants.DESC);
			LOGGER.info(RequestSender.createContainer(response.getLocation(), container));
			// Create DETA container sub-resource
			container.setName(SmartConstants.DATA);
			LOGGER.info(RequestSender.createContainer(response.getLocation(), container));
			// Create APC container Sub-resource 
			container.setName(SmartConstants.ACP);
			LOGGER.info(RequestSender.createContainer(response.getLocation(), container));
			

			String content;
			// Create DESCRIPTION contentInstance on the DESCRIPTOR container resource
			content = ObixUtil.getDescriptorRep(SmartConstants.CSE_ID, appId, SmartConstants.DATA);
			ContentInstance contentInstance = new ContentInstance();
			contentInstance.setContent(content);
			//contentInstance.setName("Happy");
			contentInstance.setContentInfo(MimeMediaType.OBIX);
			RequestSender.createContentInstance(SmartConstants.CSE_PREFIX + "/" + appId + "/" + SmartConstants.DESC, contentInstance);
			

			// Create initial contentInstance on the STATE container resource
			
			content = ObixUtil.getStateRep(appId, initValue);
			contentInstance.setContent(content);
			//RequestSender.createContentInstance(SmartConstants.CSE_PREFIX + "/" + appId + "/" + SmartConstants.DATA, contentInstance);
		}
		
		
		
	}
	
}
