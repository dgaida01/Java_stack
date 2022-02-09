package com.gaida.caresoft;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser{
	

    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    public Physician (Integer id) {
    	super(id);    	
    }
    
    
    
	// TO DO: Implement HIPAACompliantUser!

	// Setting Physician's pin
	public boolean assignPin(int pinNum) {
		boolean result = false;

		if (pinNum <= 9999 && pinNum > 999) {
			this.setPin(pinNum);
			result = true;
		}
		return result;
	}
    
    //confirming authorized access
    public boolean accessAuthorized(Integer id) {
    	boolean result = false;
    	if ( this.getId() == id) {

    		result = true;
    	}
    	return result;
    }
    
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }





}
