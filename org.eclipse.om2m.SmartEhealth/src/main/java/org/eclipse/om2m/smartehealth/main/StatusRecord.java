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

public class StatusRecord {

    /**Location */
    public final static String LOCATION = "Monfort Hospital ";
    /** Toggle */
    public final static String nameOfPatient  =  "John Mark";
    /** Default type */
    public final static String typeOfTreatment = "Radiation therapy";
    /** health card number */
    public final static String HEALTHCARDNUM = "101034727";
  
    public final static String prescription = "Tramadol (Ultram)";
    
    public final static String nameOfPhysician = "Dr. bereket";
    
    
    private String healthCardNumber;
    private String location;
    private String patientName;
    private String treatmentType;
    private String physicianName;
    private String prescriptionOrder;
    
    
    
    
  
    private boolean state = false;
    /** Lamp ID */
    private String lampId;
   
    public StatusRecord() {
    	
    }
    public StatusRecord(String lampId, String HCN, String loc, String prOrder, String pName , String phName)
    {
    	this.lampId = lampId;
    	this.healthCardNumber = HCN;
    	this.setLocation(loc) ;
    	this.setPatientName(pName);
    	this.setPhysicianName(phName);
    	this.setPrescriptionOrder(prOrder);
    	
    }
    
    
    
	/**
	 * @return the state
	 */
    public void setPatientName(String pt) {
    	this.patientName = pt;
    }
    
    public String getPatientName() {
    	return patientName;
    }
    
	public String getHealthCardNum() {
		return healthCardNumber;
	}
	
	/**
	 * @param state the state to set
	 */
	
	public void setState(boolean state) {
		this.state = state;
	}

	/**
	 * @return the lampId
	 */
	public String getLampId() {
		return lampId;
	}

	/**
	 * @param lampId the lampId to set
	 */
	public void setLampId(String lampId) {
		this.lampId = lampId;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getTreatmentType() {
		return treatmentType;
	}



	public void setTreatmentType(String treatmentType) {
		this.treatmentType = treatmentType;
	}



	public String getPrescriptionOrder() {
		return prescriptionOrder;
	}



	public void setPrescriptionOrder(String prescriptionOrder) {
		this.prescriptionOrder = prescriptionOrder;
	}



	public String getPhysicianName() {
		return physicianName;
	}



	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}

	
}
