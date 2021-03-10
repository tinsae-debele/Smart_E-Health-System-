
package org.eclipse.om2m.smartehealth.main;

import org.eclipse.om2m.commons.exceptions.BadRequestException;
/**
 * Represent a operation 
 *
 */
public enum Operations {
	
	GET_STATE("getData"),
	SET_DATA("setDATA"),
	UPDATE_DATA("updateData"),
	DELETE_DATA("delateData");
	private final String value;
	
	private Operations(final String value){
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
	
	public String getValue(){
		return value;
	}
	
	/**
	 * Return the operation from the string
	 * @param operation
	 * @return
	 */
	public static Operations getOperationFromString(String operation){
		for(Operations op : values()){
			if(op.getValue().equals(operation)){
				return op;
			}
		}
		throw new BadRequestException("Unknow Operation");
	}
}
