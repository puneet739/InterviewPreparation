package com.puneet.interview.swiggy;

import java.util.LinkedList;
import java.util.List;

public class Task {
	
	public enum STATUS{
		COMPLETED,INPROGRESS,NOT_STARTED
	}
	
	private String taskName;
	private Integer taskId;
	private Integer daysRequired;
	private Skill skillRequired;
	private List<Task> predessorTask = new LinkedList<Task>();
	private STATUS status;
	private User completedUser;
	
	public Integer getDaysRequired() {
		return daysRequired;
	}

	public void setDaysRequired(Integer daysRequired) {
		this.daysRequired = daysRequired;
	}

	public List<Task> getPredessorTask() {
		return predessorTask;
	}

	public Skill getSkillRequired() {
		return skillRequired;
	}

	public void setSkillRequired(Skill skillRequired) {
		this.skillRequired = skillRequired;
	}

	public Task(String taskName) {
		super();
		this.taskName = taskName;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public void addPredecessor(Task task) {
		predessorTask.add(task);
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public User getCompletedUser() {
		return completedUser;
	}

	public void setCompletedUser(User completedUser) {
		this.completedUser = completedUser;
	}

	@Override
	public String toString() {
		return "Task [taskName=" + taskName + ", daysRequired=" + daysRequired + ", skillRequired=" + skillRequired
				+ ", predessorTask=" + predessorTask + ", status=" + status + ", completedUser=" + completedUser + "]";
	}
}
