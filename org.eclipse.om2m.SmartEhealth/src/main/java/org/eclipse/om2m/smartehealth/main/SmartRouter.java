
package org.eclipse.om2m.smartehealth.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.commons.constants.MimeMediaType;
import org.eclipse.om2m.commons.constants.ResponseStatusCode;
import org.eclipse.om2m.commons.exceptions.BadRequestException;
import org.eclipse.om2m.commons.resource.RequestPrimitive;
import org.eclipse.om2m.commons.resource.ResponsePrimitive;
import org.eclipse.om2m.interworking.service.InterworkingService;

public class SmartRouter implements InterworkingService{

	private static Log LOGGER = LogFactory.getLog(SmartRouter.class);

	@Override
	public ResponsePrimitive doExecute(RequestPrimitive request) {
		ResponsePrimitive response = new ResponsePrimitive(request);
		if(request.getQueryStrings().containsKey("op")){
			String operation = request.getQueryStrings().get("op").get(0);
			//Operations op = Operations.getOperationFromString(operation);
			String sysID= null;
			if(request.getQueryStrings().containsKey("sysID")){
				sysID = request.getQueryStrings().get("sysID").get(0);
			}
			LOGGER.info("Received request in Smart E-healthIPE: op=" + operation + " ; sysID=" + sysID);
			
			
		response.setResponseStatusCode(ResponseStatusCode.OK);
		return response;
		}
		return response;
	}

	@Override
	public String getAPOCPath() {
		return SmartConstants.POA;
	}
	
}
