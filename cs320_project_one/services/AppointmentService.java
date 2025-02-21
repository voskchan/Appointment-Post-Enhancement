package services;

import java.util.ArrayList;

public class AppointmentService {
	


	ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	
	
	//ensures that Id is not already in use within the list
	public int checkArrayForId(String id) {
		
		for(int i = 0; i < appointmentList.size(); i++) {
			if (id.equals(appointmentList.get(i).getAppointmentId() )) {
				return i;
			}
		}
		return -100;
	}
	
	//Add a new appointment to the appointment list
	//checks to ensure Id is not already used in list before commiting new appointment
	public void addAppointment(Appointment newAppointment) {
		

		if(checkArrayForId(newAppointment.getAppointmentId()) == -100) {
			appointmentList.add(newAppointment);
		}
		else {
			throw new IllegalArgumentException("ID already exists");
		}
	}
	
	//Returns current number of appoinments in the list
	public int arraySize() {
		return appointmentList.size();
	}
	
	
	//Search for an appointment given it's Id and remove from list if found
	public void deleteAppointment(String id) {
		if(checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			appointmentList.remove(checkArrayForId(id));
		}
		
	}
	
	//reutrns the full appointment given an id for the appointment
	public Appointment pullAppointment(String id) {
		if (checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			return appointmentList.get(checkArrayForId(id));
		}
		
	}
}
