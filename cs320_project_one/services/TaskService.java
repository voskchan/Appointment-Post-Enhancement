package services;

import java.util.ArrayList;

public class TaskService {

	ArrayList<Task> taskList = new ArrayList<Task>();
	
	public int checkArrayForId(String Id) {
		
		for(int i = 0; i < taskList.size(); i++) {
			if (Id.equals(taskList.get(i).getTaskId())) {
				return i;
			}
		}
		return -100;
	}
	
	public Task pullTask(String id) {
		if (checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			return taskList.get(checkArrayForId(id));
		}
		
	}
	
	public void addTask(Task newTask) {
		if(checkArrayForId(newTask.getTaskId()) == -100) {
			taskList.add(newTask);
		}
		else {
			throw new IllegalArgumentException("ID already exists");
		}
	}
	
	public int arraySize() {
		return taskList.size();
	}
	
	public void deleteTask(String id) {
		if(checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			taskList.remove(checkArrayForId(id));
		}
		
	}
	
	public void updateTaskName(String id, String taskName) {
		if(checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			taskList.get(checkArrayForId(id)).updateTaskName(taskName);
		}
	}
	
	public void updateTaskDesc(String id, String taskDesc) {
		if(checkArrayForId(id) == -100) {
			throw new IllegalArgumentException("ID does not exist");
		}
		else {
			taskList.get(checkArrayForId(id)).updateTaskDesc(taskDesc);
		}
	}
	
}
