package com.puneet.interview.swiggy;

import java.util.LinkedList;
import java.util.List;

public class Task {
	
	private String taskName;
	private Integer taskId;
	private Integer daysRequired;
	private Skill skillRequired;
	private List<Task> predessorTask;
	private TaskStatus status;
	private User completedUser;
	private Interval taskSpan;
	
	/**
	 * @return the taskSpan
	 */
	public Interval getTaskSpan() {
		return taskSpan;
	}

	/**
	 * @param taskSpan the taskSpan to set
	 */
	public void setTaskSpan(Interval taskSpan) {
		this.taskSpan = taskSpan;
	}

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
		this.status = TaskStatus.NOT_STARTED;
		this.predessorTask = new LinkedList<Task>();
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



	/**
	 * @return the status
	 */
	public TaskStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	/**
	 * @param predessorTask the predessorTask to set
	 */
	public void setPredessorTask(List<Task> predessorTask) {
		this.predessorTask = predessorTask;
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
