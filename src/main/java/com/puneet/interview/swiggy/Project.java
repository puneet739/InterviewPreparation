package com.puneet.interview.swiggy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	private String projectName;
	List<User> users;
	@JsonIgnore
	private Map<Skill,List<User>> skillUserMap= new HashMap<Skill, List<User>>();
	private List<Task> tasks=new LinkedList<Task>();
	private Integer unfinishedTaskCount = tasks.size();


	/**
	 * @return the unfinishedTaskCount
	 */
	public Integer getUnfinishedTaskCount() {
		return unfinishedTaskCount;
	}
	/**
	 * @param unfinishedTaskCount the unfinishedTaskCount to set
	 */
	public void setUnfinishedTaskCount(Integer unfinishedTaskCount) {
		this.unfinishedTaskCount = unfinishedTaskCount;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * 
	 * @return last working day of the project, assuming all tasks of project are completed
	 */
	public int getLastWorkDay(){
		int maxEnd = Integer.MIN_VALUE;
		for(Task task: tasks){
			if(task.getStatus() == TaskStatus.COMPLETED)
				maxEnd = Math.max(maxEnd, task.getTaskSpan().getEnd());
		}
		return maxEnd;
	}
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
		for(User user: users){
			addUser(user);
			for (Skill skill: user.getSkills()) {
				if (skillUserMap.get(skill) !=null ) {
					skillUserMap.get(skill).add(user);
				}else {
					List<User> userList = new ArrayList<User>();
					userList.add(user);
					skillUserMap.put(skill, userList);
				}
			}
		}
	}
	public Project(String projectName) {
		this.projectName=projectName;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public void addTask(Task task) {
		tasks.add(task);
		unfinishedTaskCount++;
	}
	
	public void addUser(User user) {
		for (Skill skill: user.getSkills()) {
			if (skillUserMap.get(skill) !=null ) {
				skillUserMap.get(skill).add(user);
			}else {
				List<User> userList = new ArrayList<User>();
				userList.add(user);
				skillUserMap.put(skill, userList);
			}
		}
	}

	public Map<Skill, List<User>> getSkillUserMap() {
		return skillUserMap;
	}

	public void setSkillUserMap(Map<Skill, List<User>> skillUserMap) {
		this.skillUserMap = skillUserMap;
	}

	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", tasks=" + tasks + "]";
	}
	
}
