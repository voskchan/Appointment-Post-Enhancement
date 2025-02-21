package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import services.Appointment;
import services.AppointmentService;

class AppointmentServiceTest {

	@Test
	void testAddtoList() {
		AppointmentService appointmentService = new AppointmentService();
		
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("7888", insertDate, "This is the description for the appointment", "1234");
		
		appointmentService.addAppointment(testAppointment);
		
		assertTrue(appointmentService.arraySize() ==1);
	}
	
	//Ensures Appointment with same parameters can not be added to list
	@Test
	void testInvalidAddToList() {
		AppointmentService appointmentService = new AppointmentService();
		
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("7888", insertDate, "This is the description for the appointment", "1234");
		
		appointmentService.addAppointment(testAppointment);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			appointmentService.addAppointment(testAppointment);
		});
	}
	
	@Test
	void testDeleteFromList() {
		AppointmentService appointmentService = new AppointmentService();
		
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("7888", insertDate, "This is the description for the appointment", "1234");
		
		appointmentService.addAppointment(testAppointment);
		
		appointmentService.deleteAppointment("7888");
		
		assertTrue(appointmentService.arraySize() == 0);
		
	}
	
	@Test
	void testInvalidDeleteFromList() {
		AppointmentService appointmentService = new AppointmentService();
		
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("7888", insertDate, "This is the description for the appointment", "1234");
		
		appointmentService.addAppointment(testAppointment);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			appointmentService.deleteAppointment("9876");
		});
	}
	
	@Test
	void testPullAppointment() {
		AppointmentService appointmentService = new AppointmentService();
		
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("7888", insertDate, "This is the description for the appointment", "1234");
		
		appointmentService.addAppointment(testAppointment);
		
		assertTrue(appointmentService.pullAppointment("7888").equals(testAppointment));
	}
	
	@Test
	void testInvalidPullAppointment() {
		AppointmentService appointmentService = new AppointmentService();
		
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("7888", insertDate, "This is the description for the appointment", "1234");
		
		appointmentService.addAppointment(testAppointment);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appointmentService.pullAppointment("0987");
		});
	}
}
