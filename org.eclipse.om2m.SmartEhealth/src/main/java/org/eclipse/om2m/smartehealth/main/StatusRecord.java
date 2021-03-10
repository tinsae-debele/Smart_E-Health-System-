
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
    /** app ID */
    private String appID;
   
    public StatusRecord() {
    	
    }
    public StatusRecord(String appID, String HCN, String loc, String prOrder, String pName , String phName)
    {
    	this.appID = appID;
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
	 * @return the appID
	 */
	public String getappID() {
		return appID;
	}

	/**
	 * @param appID the appID to set
	 */
	public void setappID(String appID) {
		this.appID = appID;
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
