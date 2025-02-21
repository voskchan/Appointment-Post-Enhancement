package services;

import java.util.ArrayList;

public class ContactService {
	
	ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	public int checkArrayForId(String Id) {
		
		for(int i = 0; i < contactList.size(); i++) {
			if (Id.equals(contactList.get(i).getContactId())) {
				return i;
			}
		}
		return -100;
	}
	
	public Contact pullContact(String id) {
		if (checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			return contactList.get(checkArrayForId(id));
		}
		
	}
	
	public void addContact(Contact newContact) {
		if(checkArrayForId(newContact.getContactId()) == -100) {
			contactList.add(newContact);
		}
		else {
			throw new IllegalArgumentException("ID already exists");
		}
	}
	
	public int arraySize() {
		return contactList.size();
	}
	
	public void deleteContact(String id) {
		if(checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			contactList.remove(checkArrayForId(id));
		}
		
	}
	
	public void updateContactFirstName(String id, String firstName) {
		if(checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			contactList.get(checkArrayForId(id)).updateFirstName(firstName);
		}
	}
	
	public void updateContactLastName(String id, String lastName) {
		if(checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			contactList.get(checkArrayForId(id)).updateLastName(lastName);
		}
	}
	
	public void updateContactPhone(String id, String phone) {
		if(checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			contactList.get(checkArrayForId(id)).updatePhone(phone);
		}
	}
	
	public void updateContactAddress(String id, String address) {
		if(checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			contactList.get(checkArrayForId(id)).updateAddress(address);
		}
	}
	
}
