package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import services.Task;

class TaskTest {

	@Test
	void testTaskClass() {
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		assertTrue(testTask.getTaskId().equals("7548"));
		assertTrue(testTask.getTaskName().equals("Task number 1"));
		assertTrue(testTask.getTaskDesc().equals("This is the description for the task"));
	}
	
	@Test
	void testIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task(null , "Task number 1", "This is the description for the task");
		});
	}
	
	@Test
	void testIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task("123456788909876" , "Task number 1", "This is the description for the task");
		});
	}
	
	@Test
	void testIdAtTen() {
		Task testTask = new Task("1234567890", "Task number 1", "This is the description for the task");
		assertTrue(testTask.getTaskId().length() == 10);
	}
	
	@Test
	void testNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task("7548" , null, "This is the description for the task");
		});
	}
	
	@Test
	void testNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task("7548" , "Task number 1 but way too long for a name string", "This is the description for the task");
		});
	}
	
	@Test 
	void testNameAtTwenty() {
		Task testTask = new Task("7548", "nnmmffjjggkkssddlloo", "This is the description for the task");
		assertTrue(testTask.getTaskName().length() == 20);
	}
	
	@Test
	void testDescNull() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task("7548" , "Task number 1", null);
		});
	}
	
	@Test
	void testDescAtFifty() {
		Task testTask = new Task("7548", "Task number 1", "nnnnnhhhhhjjjjjkkkkkmmmmmlllllooooopppppiiiiiuuuuu");
		assertTrue(testTask.getTaskDesc().length() == 50);
	}
	
	@Test
	void testDescTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Task("7548" , "Task number 1", "This is the description for the task but I have to make it really long so that it passes 50 characters and causes the build to fail");
		});
	}
	
	@Test
	void testTaskNameUpdate() {
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		testTask.updateTaskName("Task number 5");
		
		assertTrue(testTask.getTaskName().equals("Task number 5"));
	}
	
	@Test 
	void testNullNameUpdate(){
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testTask.updateTaskName(null);
		});
	}
	
	@Test 
	void testTooLongNameUpdate() {
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			testTask.updateTaskName("This task name will be way too long for this to update");
		});
	}
	
	@Test
	void testTaskDescUpdate() {
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		testTask.updateTaskDesc("This is a new description of the task");
		
		assertTrue(testTask.getTaskDesc().equals("This is a new description of the task"));
	}
	
	@Test 
	void testNullDescUpdate(){
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testTask.updateTaskDesc(null);
		});
	}
	
	@Test 
	void testTooLongDescUpdate() {
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			testTask.updateTaskDesc("This description will be so long that i will run out of things to say to make it over 50 characters, I'm not sure if I am there yet but should be now");
		});
	}
} 
