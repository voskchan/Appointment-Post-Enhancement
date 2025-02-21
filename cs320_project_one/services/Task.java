package services;

public class Task {

	private String taskId;
	private String taskName;
	private String taskDesc;
	
	public Task(String taskId, String taskName, String taskDesc) {
		if(taskId == null || taskId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		else if(taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Name");
		}
		else if(taskDesc == null || taskDesc.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		else {
			this.taskId = taskId;
			this.taskName = taskName;
			this.taskDesc = taskDesc;
		}
		
	}
	
	public String getTaskId() {
		return taskId;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getTaskDesc() {
		return taskDesc;
	}
	
	
	
	public void updateTaskName(String taskName) {
		if(taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name");
		}
		
		else {
			this.taskName = taskName;
		}
	}
	
	public void updateTaskDesc(String taskDesc) {
		if(taskDesc == null || taskDesc.length() > 50) {
			throw new IllegalArgumentException("Invalid Task Description");
		}
		else {
			this.taskDesc = taskDesc;
		}
	}
	
}
