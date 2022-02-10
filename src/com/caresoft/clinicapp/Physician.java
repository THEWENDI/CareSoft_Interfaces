package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	
	private ArrayList<String> patientNotes;

	public Physician(Integer id) {
		super(id);
	}

//	Pin must be exactly 4 digits, returns false if not.
//	Expected to assign the pin to the user (as a member variable)
	public boolean assignPin(int pin) {
		String stringPin = String.valueOf(pin);
		if( stringPin.length() == 4) {
			super.setPin(pin);
			return true;
		}else {
			return false;
		}
	}

//	Checks the physician's id against the given id;
//	returns true if they are a match, otherwise false.
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(super.id.equals(confirmedAuthID)) {
			return true;
		}else {			
			return false;
		}
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
	
	

}
