package com.puneet.interview.swiggy;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProjectMain {

	private Project project;
	public ProjectMain() {
		
	}
	
	public static void main(String[] args) {
		ProjectMain mainClass = new ProjectMain();
		mainClass.initalizeProject();
		ProjectRealization realization = new ProjectRealicationImplimentation(mainClass.project);
		System.out.println(mainClass.project);
		System.out.println("Project finish #day: "+ mainClass.project.getLastWorkDay());
		
		System.out.println(javaToJSON(mainClass.project.getUsers()));
		
		List<User> userList = mainClass.project.getUsers();
		
		// check if user free on this given day
		assert userList.get(0).isFreeThisDay(3) == false : "user availability check-1 failed";
		assert userList.get(0).isFreeThisDay(15) == true : "user availability check-2 failed";
		assert userList.get(0).isFreeThisDay(35) == true : "user availability check-3 failed";
	}

	public void initalizeProject() {
		Project project = new Project("Project Planner");
		
		Task t1 = new Task("Task1");
		t1.setSkillRequired(Skill.JAVA);
		t1.setDaysRequired(3);
		
		Task t2 = new Task("Task2");
		t2.setSkillRequired(Skill.PHP);
		t2.setDaysRequired(3);
		
		Task t3 = new Task("Task3");
		t3.setSkillRequired(Skill.PYTHON);
		t3.setDaysRequired(4);
		
		Task t4 = new Task("Task4");
		t4.setSkillRequired(Skill.NODEJS);
		t4.setDaysRequired(4);
		
		//setting some task dependencies here
		t1.addPredecessor(t2);
		t2.addPredecessor(t3);
		
		
		User u1 = new User("Puneet");
		u1.addSkill(Skill.JAVA);
		u1.addSkill(Skill.PHP);
		u1.addHoliday(2, 5);
		
		User u2 = new User("Satya");
		u2.addSkill(Skill.PYTHON);
		u2.addSkill(Skill.NODEJS);
		u2.addSkill(Skill.JAVA);
		u2.addHoliday(3, 15);
		// lets add consecutive holiday plan
		u2.addHoliday(17, 20);
		
		User u3 = new User("Taylor Jarden");
		u3.addSkill(Skill.PERL);
		u3.addSkill(Skill.TYPESCRIPT);
		
		User u4 = new User("Christopher");
		u4.addSkill(Skill.AWS);
		u4.addSkill(Skill.RUBY);
		   
		project.addTask(t1);
		project.addTask(t2);
		project.addTask(t3);
		project.addTask(t4);

		// this would also builds skill map 
		project.setUsers(Arrays.asList(u1, u2, u3, u4));
		
		this.project=project;
	}
	public static String javaToJSON(Object javaObj){
		ObjectMapper objMapper = new ObjectMapper();
		String result="None";
		try {
			result = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(javaObj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
}
