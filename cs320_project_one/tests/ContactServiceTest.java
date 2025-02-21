package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import services.Contact;
import services.ContactService;

class ContactServiceTest {
	
	

	@Test
	void testAddToList() {
			ContactService contactService = new ContactService();
			
			Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
			
			contactService.addContact(testContact);
			
			assertTrue(contactService.arraySize() == 1);
		}
	
	@Test
	void TestInvalidAddToList(){
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.addContact(testContact);
		});
	}
	
	@Test
	void TestDeleteFromList() {
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		contactService.deleteContact("7465");
		
		assertTrue(contactService.arraySize() == 0);
	}
	
	@Test
	void TestInvalidDeleteFromList() {
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.deleteContact("4433");
		});
	}
	
	@Test
	void TestUpdateFirstName() {
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		contactService.updateContactFirstName("7465", "Benjamin");
		
		Contact checkContact = contactService.pullContact("7465");
		
		assertTrue(checkContact.getFirstName().equals("Benjamin"));
	}
	
	@Test
	void TestUpdateLastName() {
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		contactService.updateContactLastName("7465", "Benjamin");
		
		Contact checkContact = contactService.pullContact("7465");
		
		assertTrue(checkContact.getLastName().equals("Benjamin"));
	}
	
	@Test
	void TestUpdatePhone() {
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		contactService.updateContactPhone("7465", "2085230956");
		
		Contact checkContact = contactService.pullContact("7465");
		
		assertTrue(checkContact.getPhone().equals("2085230956"));
	}
	
	@Test
	void TestUpdateAddress() {
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		contactService.updateContactAddress("7465", "11 other address");
		
		Contact checkContact = contactService.pullContact("7465");
		
		assertTrue(checkContact.getAddress().equals("11 other address"));
	}
	
	@Test
	void TestInvalidUpdateFirstName() {
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.updateContactFirstName("384", "Benjamin");
		});

	}
	
	@Test
	void TestInvalidUpdateLastName() {
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.updateContactLastName("384", "Benjamin");
		});

	}
	
	@Test
	void TestInvalidUpdatePhone() {
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.updateContactPhone("384", "5839939393");
		});

	}
	
	@Test
	void TestInvalidUpdateAddress() {
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.updateContactAddress("384", "11 other address");
		});

	}
	
	@Test
	void TestPullContact() {
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		assertTrue(contactService.pullContact("7465").equals(testContact));
	}
	
	@Test
	void TestInvalidPullContact(){
		ContactService contactService = new ContactService();
		
		Contact testContact = new Contact("7465", "Frank", "Jones", "9028273848", "32 some address");
		
		contactService.addContact(testContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.pullContact("654");
		});
	}
}
