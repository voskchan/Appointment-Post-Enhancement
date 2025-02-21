package services;

import java.time.LocalDateTime;


public class Appointment {
	

	private String appointmentId;
	private LocalDateTime appointmentDate;
	private String appointmentDesc;
	private String appointmentContact;
	
	public Appointment(String appointmentId, LocalDateTime appointmentDate, String appointmentDesc, String appointmentContact) {
		
		//Check for a valid date in future and to make sure description isn't too long
		//also a check to make sure inputted contact id is not too long
		//if all checks are passed create the appointment
		if(appointmentId == null || appointmentId.length() > 10 || appointmentId.length() == 0 || isNumber(appointmentId)) {
			throw new IllegalArgumentException("Invalid Id");
		}
		else if(appointmentDate == null || appointmentDate.isBefore(LocalDateTime.now()) || appointmentDate.equals(LocalDateTime.now())) {
			throw new IllegalArgumentException("Invalid Date");
		}
		else if(appointmentDesc == null || appointmentDesc.length() > 50 || appointmentDesc.length() == 0) {
			throw new IllegalArgumentException("Invalid Description");
		} else if(appointmentContact == null || appointmentContact.length() > 10 || appointmentContact.length() == 0 || isNumber(appointmentContact)) {
			throw new IllegalArgumentException("Invalid Contact Id");
		}
		else {
			this.appointmentId = appointmentId;
			this.appointmentDate = appointmentDate;
			this.appointmentDesc = appointmentDesc;
			this.appointmentContact = appointmentContact;
		}
		
	}
	
	//Get methods for all parameters
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}
	
	public String getAppointmentDesc() {
		return appointmentDesc;
	}
	
	public String getAppointmentContact() {
		return appointmentContact;
	}
	
	//Will check if a screen is made fully of number characters
	private static boolean isNumber(String idCheck) {
		try {
			Double.parseDouble(idCheck);
			return false;
		} catch(NumberFormatException e) {
			return true;
		}
	}
	
}
