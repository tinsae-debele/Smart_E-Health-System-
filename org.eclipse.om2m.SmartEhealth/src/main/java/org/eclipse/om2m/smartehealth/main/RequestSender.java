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

import java.math.BigInteger;

import org.eclipse.om2m.commons.constants.Constants;
import org.eclipse.om2m.commons.constants.MimeMediaType;
import org.eclipse.om2m.commons.constants.Operation;
import org.eclipse.om2m.commons.constants.ResourceType;
import org.eclipse.om2m.commons.resource.AE;
import org.eclipse.om2m.commons.resource.Container;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.eclipse.om2m.commons.resource.RequestPrimitive;
import org.eclipse.om2m.commons.resource.Resource;
import org.eclipse.om2m.commons.resource.ResponsePrimitive;


public class RequestSender {
	
	/**
	 * Private constructor to avoid creation of this object
	 */
	private RequestSender(){}
	
	public static ResponsePrimitive createResource(String targetId, Resource resource, int resourceType){
		RequestPrimitive request = new RequestPrimitive();
		request.setFrom(Constants.ADMIN_REQUESTING_ENTITY);
		request.setTo(targetId);
		request.setResourceType(BigInteger.valueOf(resourceType));
		request.setRequestContentType(MimeMediaType.OBJ);
		request.setContent(resource);
		request.setOperation(Operation.CREATE);
		return SmartController.CSE.doRequest(request);
	}
	
	public static ResponsePrimitive createAE(AE resource){
		return createResource("/" + Constants.CSE_ID, resource, ResourceType.AE);
	}
	
	public static ResponsePrimitive createContainer(String targetId, Container resource){
		return createResource(targetId, resource, ResourceType.CONTAINER);
	}
	
	public static ResponsePrimitive createContentInstance(String targetId, ContentInstance resource){
		return createResource(targetId, resource, ResourceType.CONTENT_INSTANCE);
	}
	

	public static ResponsePrimitive getRequest(String targetId){
		RequestPrimitive request = new RequestPrimitive();
		request.setFrom(Constants.ADMIN_REQUESTING_ENTITY);
		request.setTo(targetId);
		request.setOperation(Operation.RETRIEVE);
		request.setReturnContentType(MimeMediaType.XML);
		return SmartController.CSE.doRequest(request);
	}
	
}
