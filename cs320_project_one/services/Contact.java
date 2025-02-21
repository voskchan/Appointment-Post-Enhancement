package services;


public class Contact {
	
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//Create a contact after checking that all parameters meet requirements
	//enhancement has added more checks in order to prevent edge cases 
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		if(contactId == null || contactId.length() > 10 || contactId.length() == 0 || isNumber(contactId) ) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(firstName == null || firstName.length() > 10 || firstName.length() == 0) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if(lastName == null || lastName.length() > 10 || lastName.length() == 0) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if(phone == null || phone.length() != 10 || isNumber(contactId)) {
			throw new IllegalArgumentException("Invalid phone");
		}
		if(address == null || address.length() > 30 || address.length() == 0) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	
	//Get methods for variabel within a Contact
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	//Update methods for parts of Contact that are allowed to be updated
	//enhancement has added protection for cases of zero length strings and alpha characters in numeric strings
	public void updateFirstName(String firstName) {
		if(firstName == null || firstName.length() > 10 || firstName.length() == 0) {
			throw new IllegalArgumentException("Invalid first name");
		}
		else {
			this.firstName = firstName;
		}
	}

	public void updateLastName(String lastName) {
		if(lastName == null || lastName.length() > 10 || lastName.length() == 0) {
			throw new IllegalArgumentException("Invalid last name");
		}
		else {
			this.lastName = lastName;
		}
	}
	
	public void updatePhone(String phone) {
		if(phone == null || phone.length() != 10 || isNumber(phone)) {
			throw new IllegalArgumentException("Invalid phone");
		}
		
		else {
			this.phone = phone;
		}
	}
	
	public void updateAddress(String address) {
		if(address == null || address.length() > 30 || address.length() == 0) {
			throw new IllegalArgumentException("Invalid address");
		}
		else {
			this.address = address;
		}
	}
	
	//Will check if a String is made fully of number characters
	private static boolean isNumber(String idCheck) {
		try {
			Double.parseDouble(idCheck);
			return false;
		} catch(NumberFormatException e) {
			return true;
		}
	}
}
