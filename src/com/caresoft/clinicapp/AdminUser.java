package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	
//... imports class definition...
    
    public AdminUser(Integer id, String role) {
		super(id);
		setRole(role);
	}
	// Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
//    Pin must be 6 digits or more; returns false if not
//    Expected to assign the pin to the user (as a member variable)
    public boolean assignPin(int pin) {
    	String stringPin = String.valueOf(pin);
		if( stringPin.length() >= 6) {
			super.setPin(pin);
			return true;
		}else {
			return false;
		}
    }
//    Compares the ids, and if they are not a match,
//    creates an incident report using the  authIncident method,
//    Returns true if ids match, false if not.
    
    public boolean accessAuthorized(Integer confirmedAuthID) {
		if(super.id.equals(confirmedAuthID)) {
			return true;
		}else {			
			authIncident();
			return false;
		}
    }
    
//    Returns a list of strings (incidents reported)

    public ArrayList<String> reportSecurityIncidents() {
    	
    	return securityIncidents;
    }
    
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    // TO DO: Setters & Getters
    
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
    


}
