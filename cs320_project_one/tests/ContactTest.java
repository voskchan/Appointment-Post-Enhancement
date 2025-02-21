package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import services.Contact;

class ContactTest {

	@Test
	void testContactClass() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		assertTrue(testContact.getContactId().equals("5432"));
		assertTrue(testContact.getFirstName().equals("Chance"));
		assertTrue(testContact.getLastName().equals("Vosk"));
		assertTrue(testContact.getPhone().equals("2085230956"));
		assertTrue(testContact.getAddress().equals("765 Vista pkwy"));
	}

	@Test
	void testIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact(null, "Chance","Vosk","2085230956","765 Vista pkwy");
		});
	}
	
	@Test
	void testIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("12345678901", "Chance","Vosk","2085230956","765 Vista pkwy");
		});
	}
	
	@Test
	void testIdAtTen() {
		Contact testContact = new Contact("1234567890", "Chance", "Vosk", "2095230956","765 Vista pkwy");
		assertTrue(testContact.getContactId().length() == 10);
	}
	
	@Test
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", null ,"Vosk","2085230956","765 Vista pkwy");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "Chanceoverten","Vosk","2085230956","765 Vista pkwy");
		});
	}
	
	@Test 
	void testFirstNameAtTen() {
		Contact testContact = new Contact("5432", "Chancevhis","Vosk","2085230956","765 Vista pkwy");
		assertTrue(testContact.getFirstName().length() == 10);
	}
	
	@Test
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "Chance",null,"2085230956","765 Vista pkwy");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "Chance","Voskoverten","2085230956","765 Vista pkwy");
		});
	}
	
	@Test
	void testLastNameAtTen() {
		Contact testContact = new Contact("5432", "Chance","Voskchance","2085230956","765 Vista pkwy");
		assertTrue(testContact.getLastName().length() == 10);
	}
	
	@Test
	void testPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "Chance","Vosk",null,"765 Vista pkwy");
		});
	}
	
	@Test
	void testPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "Chance","Vosk","2085230956989","765 Vista pkwy");
		});
	}
	
	@Test 
	void testPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "Chance", "Vosk","654", "765 Vista pkwy");
		});
	}
	
	@Test
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "Chance","Vosk","2085230956",null);
		});
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy this address is way too long for this test to pass");
		});
	}
	
	@Test 
	void testAddressAtThirty() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","nnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		assertTrue(testContact.getAddress().length() == 30);
	}
	
	@Test
	void testFirstNameUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		testContact.updateFirstName("Ben");
		
		assertTrue(testContact.getFirstName().equals("Ben"));
	}
	
	@Test
	void testLongFirstNameUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updateFirstName("Benwaytoolong");
		});
	}
	
	@Test
	void testNullFirstNameUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updateFirstName(null);
		});
	}
	
	@Test
	void testLastNameUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		testContact.updateLastName("Ben");
		
		assertTrue(testContact.getLastName().equals("Ben"));
	}
	
	@Test
	void testLongLastNameUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updateLastName("Benwaytoolong");
		});
	}
	
	@Test
	void testNullLastNameUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updateLastName(null);
		});
	}
	
	@Test
	void testPhoneUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		testContact.updatePhone("6474839294");
		
		assertTrue(testContact.getPhone().equals("6474839294"));
	}
	
	@Test
	void testLongPhoneUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updatePhone("12345678901112");
		});
	}
	
	@Test
	void testShortPhoneUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updatePhone("1");
		});
	}
	
	@Test
	void testNullPhoneUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updatePhone(null);
		});
	}
	
	@Test
	void testAddressUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		testContact.updateAddress("1 benjamin way");
		
		assertTrue(testContact.getAddress().equals("1 benjamin way"));
	}
	
	@Test
	void testLongAddressUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updateAddress("there is no way that this address will pass this test because it is so long");
		});
	}
	
	@Test
	void testNullAddressUpdate() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updateAddress(null);
		});
	}
	
	//New test methods for enhancement
	@Test
	void TestIdAtZero(){
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("", "Chance","Vosk","2085230956","765 Vista pkwy");
		});
	}
	
	@Test
	void TestIdIsAlpha() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("bad id", "Chance","Vosk","2085230956","765 Vista pkwy");
		});
	}
	
	@Test 
	void TestPhoneAtZero() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "Chance","Vosk","","765 Vista pkwy");
		});
	}
	
	@Test
	void TestPhoneIsAlpha() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "Chance","Vosk","phone","765 Vista pkwy");
		});
	}
	
	@Test
	void TestFirstNameAtZero() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "","Vosk","2085230956","765 Vista pkwy");
		});
	}
	
	@Test
	void TestLastNameAtZero() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "Chance","","2085230956","765 Vista pkwy");
		});
	}
	
	@Test
	void TestAddressAtZero() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("5432", "Chance","Vosk","2085230956","");
		});
	}
	
	@Test
	void TestFirstNameUpdateToZero() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updateFirstName("");
		});
	}
	
	@Test
	void TestLastNameUpdateToZero() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updateLastName("");
		});
	}
	
	@Test
	void TestPhoneUpdateToZero() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updatePhone("");
		});
	}
	
	@Test
	void TestAddressUpdateToZero() {
		Contact testContact = new Contact("5432", "Chance","Vosk","2085230956","765 Vista pkwy");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
		testContact.updateAddress("");
		});
	}
}

