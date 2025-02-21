package services;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ServiceRunner {
	
	private static AtomicInteger CONTACT_ID = new AtomicInteger(0);
	private static AtomicInteger APPOINTMENT_ID = new AtomicInteger(0);
	
	private static void printMenu() {
		System.out.println("Please choose an option:");
		System.out.println("1: Create a Contact");
		System.out.println("2: Create an Appointment");
		System.out.println("3: Update a Contact");
		System.out.println("4: Delete a Contact");
		System.out.println("5: Delete an Appointment");
		System.out.println("0: Exit the program");
	}
	
	private static void createContact(ContactService contactService, Scanner reader) {
		System.out.println("Enter Contact First Name");
		String firstName = reader.next();
		System.out.println("Contact Last Name");
		String lastName = reader.next();
		System.out.println("Phone number (10 digit number)");
		String phone = reader.next();
		System.out.println("Address");
		String address = reader.next();
		
		int id = CONTACT_ID.incrementAndGet();
		String contId = String.valueOf(id);
		
		Contact contactToAdd = new Contact(contId, firstName, lastName, phone, address);
		contactService.addContact(contactToAdd);
		System.out.println("Contact id is " + contId);
	}
	
	private static void createAppointment(AppointmentService appointmentService, Scanner reader, String contactId) {
		System.out.println("Enter the year of appointment");
		int appointYear = reader.nextInt();
		System.out.println("Enter the number of month");
		int appointMonth = reader.nextInt();
		System.out.println("Enter the day");
		int appointDay = reader.nextInt();
		System.out.println("Enter the hour");
		int appointHour = reader.nextInt();
		System.out.println("Enter the minute");
		int appointMinute = reader.nextInt();
		System.out.println("Enter the appointment description");
		String appointDesc = reader.next();
		
		String apptId = String.valueOf(APPOINTMENT_ID.incrementAndGet());
		
		Appointment appointmentToAdd = new Appointment(apptId, LocalDateTime.of(appointYear, appointMonth, appointDay, appointHour, appointMinute), appointDesc, contactId);
		appointmentService.addAppointment(appointmentToAdd);
		System.out.println("Appointment id is " + apptId);
	}
	
	private static void updateContact(ContactService contactService, Scanner reader) {
		System.out.println("Enter the Id of the contact you would like to update");
		try {
			String contactId = String.valueOf(reader.nextInt());
			if(contactService.checkArrayForId(contactId) == -100) {
				System.out.println("Contact does not exist in system");
				reader.nextLine();
			} else {
				System.out.println("What would you like to update?");
				System.out.println("1: First name");
				System.out.println("2: Last name");
				System.out.println("3: Phone");
				System.out.println("4: Address");
				try {
					int updateChoice = reader.nextInt();
					if(updateChoice == 1) {
						System.out.println("Please enter new first name:");
						String firstName = reader.next();
						contactService.updateContactFirstName(contactId, firstName);
						System.out.println("New first name is " + contactService.pullContact(contactId).getFirstName());
						reader.nextLine();
					} else if (updateChoice == 2) {
						System.out.println("Please enter new last name:");
						String lastName = reader.next();
						contactService.updateContactLastName(contactId, lastName);
						System.out.println("New last name is " + contactService.pullContact(contactId).getLastName());
						reader.nextLine();
					} else if (updateChoice == 3) {
						System.out.println("Please enter new phone number:");
						System.out.println("New phone number is " + contactService.pullContact(contactId).getPhone());
						String phone = reader.next();
						contactService.updateContactPhone(contactId, phone);
						reader.nextLine();
					} else if (updateChoice == 4) {
						System.out.println("Please enter new address:");
						String address = reader.next();
						contactService.updateContactAddress(contactId, address);
						System.out.println("New address is " + contactService.pullContact(contactId).getAddress());
						reader.nextLine();
					} else {
						System.out.println("Invalid Choice");
					}
					
					
				}
					
					catch(InputMismatchException e) {
					System.out.println("Please enter a number");
					reader.nextLine();
				}
			}
		}catch(InputMismatchException e) {
			System.out.println("Please enter a number");
			reader.nextLine();
		}
	}
	
	private static void deleteContact(ContactService contactService, Scanner reader) {
		System.out.println("Enter Id of the Contact you would like to delete");
		try {
			String contactId = String.valueOf(reader.nextInt());
			if(contactService.checkArrayForId(contactId) == -100) {
				System.out.println("Contact does not exist in list");
				reader.nextLine();
			}else {
				contactService.deleteContact(contactId);
				reader.nextLine();
			}
		}catch(InputMismatchException e) {
			System.out.println("Please enter a number");
			reader.nextLine();
		}
	}
	
	private static void deleteAppointment(AppointmentService appointmentService, Scanner reader) {
		System.out.println("Enter Id of the appointment you would like to delete");
		try {
			String appointmentId = String.valueOf(reader.nextInt());
			if(appointmentService.checkArrayForId(appointmentId) == -100) {
				System.out.println("Appointment does not exist in list");
				reader.nextLine();
			}else {
				appointmentService.deleteAppointment(appointmentId);
				reader.nextLine();
			}
		}catch(InputMismatchException e) {
			System.out.println("Please enter a number");
			reader.nextLine();
		}
	}
	

	public static void main(String[] args) {
		
		AppointmentService appointmentService = new AppointmentService();
		ContactService contactService = new ContactService();
		Scanner reader = new Scanner(System.in);
		
		int userChoice = 9;
		
		while(userChoice != 0) {
			
			printMenu();
			
			try {
				userChoice = reader.nextInt();
			} catch(InputMismatchException e) {
				reader.nextLine();
				userChoice = 9;
				System.out.println("Please use a number for choice");
			}
			
			if(userChoice == 1) {
				createContact(contactService, reader);
				reader.nextLine();
			} else if (userChoice == 2) {
				System.out.println("Please enter Id number of contact you would like to make an appointment for: ");
				try {
					String contactId = String.valueOf(reader.nextInt());
					if (contactService.checkArrayForId(contactId) == -100) {
						System.out.println("Contact does not exist within sytem");
						reader.nextLine();
					} else {
						createAppointment(appointmentService, reader, contactId);
						reader.nextLine();
					}
				} catch(InputMismatchException e) {
					reader.nextLine();
					userChoice = 9;
					System.out.println("Please enter a number");
				}
				
			} else if (userChoice == 3) {
				updateContact(contactService, reader);
			} else if (userChoice == 4) {
				deleteContact(contactService, reader);
			} else if (userChoice == 5) {
				deleteAppointment(appointmentService, reader);
			} else if (userChoice == 0) {
				System.out.println("Thank you for using Appointment Service");
			} else {
				System.out.println("User choice was not a valid option");
			}
		}
		

	}

}
