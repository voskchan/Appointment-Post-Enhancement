package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import services.Appointment;

class AppointmentTest {

	@Test
	void testAppointmentClass() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("7888" , insertDate , "This is the description for the appointment", "1234");
		assertTrue(testAppointment.getAppointmentId().equals("7888"));
		assertTrue(testAppointment.getAppointmentDate().equals(insertDate));
		assertTrue(testAppointment.getAppointmentDesc().equals("This is the description for the appointment"));
	}
	
	@Test
	void GivenNullId_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		new Appointment(null , insertDate , "This is the description for the appointment", "1234");
		});
	}
	
	@Test
	void GivenIdOverTen_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("123456789010" , insertDate , "This is the description for the appointment", "1234");
		});
	}
	
	@Test
	void GivenIdAtTen_WhenCreatingAppointment_ThenSuccessfulCreation() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("1234567890", insertDate, "This is the description for the appointment", "1234");
		assertTrue(testAppointment.getAppointmentId().equals("1234567890"));
	}
	
	
	@Test 
	void GivenNullDescription_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			new Appointment("7888", insertDate, null, "1234");
		});
	}

	@Test
	void GivenDescriptionAtFifty_WhenCreatingAppointment_ThenSuccessfulCreation() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("7888", insertDate, "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk", "1234");
		assertTrue(testAppointment.getAppointmentDesc().equals("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"));
	}
	
	@Test
	void GivenDescriptionOverFifty_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("7888", insertDate, "thissisisisisisisisisisisisisiekkknjnekekdisisksknfndasjdkngadvda", "1234");
		});
	}
	
	@Test
	void GivenDateBeforeCurrent_WhenCreatingApplication_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2022, Month.AUGUST, 25, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("7888", insertDate, "this is the description", "1234");
		});
	}
	
	//New Tests for enhancement
	@Test
	void GivenIdEmpty_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("" , insertDate , "This is the description for the appointment", "1234");
		});
	}
	
	@Test
	void GivenDescriptionAtZero_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("7888", insertDate, "", "1234");
		});
	}
	
	@Test
	void GivenNullContact_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		new Appointment("7888" , insertDate , "This is the description for the appointment", null);
		});
	}
	
	@Test
	void GivenContactOverTen_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("7888" , insertDate , "This is the description for the appointment", "12345678901");
		});
	}
	
	@Test
	void GivenContactAtTen_WhenCreatingAppointment_ThenSuccessfulCreation() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Appointment testAppointment = new Appointment("7888", insertDate, "This is the description for the appointment", "1234567890");
		assertTrue(testAppointment.getAppointmentContact().equals("1234567890"));
	}
	
	@Test
	void GivenContactEmpty_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("7888" , insertDate , "This is the description for the appointment", "");
		});
	}
	
	//Can occasionally fail during run time due to small time change
	@Test
	void GivenDateAtCurrentDate_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.now();
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("7888", insertDate, "this is the description", "1234");
		});
	}
	
	@Test
	void GivenIdAlpha_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("bad id" , insertDate , "This is the description for the appointment", "1234");
		});
	}
	
	@Test 
	void GivenContactAlpha_WhenCreatingAppointment_ThenThrowException() {
		LocalDateTime insertDate = LocalDateTime.of(2026, Month.APRIL, 10, 0, 0);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Appointment("7888" , insertDate , "This is the description for the appointment", "bad cont");
		});
	}
}
