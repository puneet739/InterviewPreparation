package com.puneet.interview.swiggy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Project {

	private String projectName;
	private Map<Skill,List<User>> skillUserMap= new HashMap<Skill, List<User>>();
	private List<Task> tasks=new LinkedList<Task>();

	

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
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
	}
	
	public void addUser(User user) {
		for (Skill skill: user.getSkills()) {
			if (skillUserMap.get(skill) !=null ) {
				skillUserMap.get(skill).add(user);
			}else {
				skillUserMap.put(skill,Arrays.asList(user));
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
