package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import services.Task;
import services.TaskService;

class TaskServiceTest {

	@Test
	void testAddToList() {
			TaskService taskService = new TaskService();
			
			Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
			
			taskService.addTask(testTask);
			
			assertTrue(taskService.arraySize() == 1);
		}
	
	@Test
	void testIdNotUniqueWhenAdding(){
		TaskService taskService = new TaskService();
		
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		taskService.addTask(testTask);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			taskService.addTask(testTask);
		});
	}
	
	@Test
	void TestDeleteFromList() {
		TaskService taskService = new TaskService();
		
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		taskService.addTask(testTask);
		
		taskService.deleteTask("7548");
		
		assertTrue(taskService.arraySize() == 0);
	}
	
	@Test
	void TestInvalidDeleteFromList() {
		TaskService taskService = new TaskService();
		
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		taskService.addTask(testTask);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			taskService.deleteTask("4433");
		});
	}
	
	@Test
	void TestUpdateTaskName() {
		TaskService taskService = new TaskService();
		
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		taskService.addTask(testTask);
		
		taskService.updateTaskName("7548", "Task number 6");
		
		Task checkTask = taskService.pullTask("7548");
		
		assertTrue(checkTask.getTaskName().equals("Task number 6"));
	}
	
	@Test
	void TestUpdateTaskDesc() {
		TaskService taskService = new TaskService();
		
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		taskService.addTask(testTask);
		
		taskService.updateTaskDesc("7548", "This is the new description for the task");
	
		Task checkTask = taskService.pullTask("7548");
		
		assertTrue(checkTask.getTaskDesc().equals("This is the new description for the task"));
		
	}
	
	@Test
	void TestInvalidNameUpdate() {
		TaskService taskService = new TaskService();
		
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		taskService.addTask(testTask);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			taskService.updateTaskName("8393", "This will never change");
		});
	}
	
	@Test
	void TestInvalidDescUpdate() {
		TaskService taskService = new TaskService();
		
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		taskService.addTask(testTask);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			taskService.updateTaskDesc("8393", "This will never change");
		});
	}
	
	@Test
	void TestPullTask() {
		TaskService taskService = new TaskService();
		
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task");
		
		taskService.addTask(testTask);
		
		assertTrue(taskService.pullTask("7548").equals(testTask));
	}
	
	@Test
	void TestInvalidPullContact(){
		TaskService taskService = new TaskService();
		
		Task testTask = new Task("7548", "Task number 1", "This is the description for the task" );
		
		taskService.addTask(testTask);
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			taskService.pullTask("654");
		});
	}
}
		