package com.puneet.interview.swiggy;

public class ProjectMain {

	private Project project;
	public ProjectMain() {
		
	}
	
	public static void main(String[] args) {
		ProjectMain mainClass = new ProjectMain();
		mainClass.initalizeProject();
		ProjectRealization realization = new ProjectRealicationImplimentation(mainClass.project);
		System.out.println(mainClass.project);
	}

	public void initalizeProject() {
		Project project = new Project("Puneet");
		
		Task t1 = new Task("Task1");
		t1.setSkillRequired(Skill.JAVA);
		t1.setDaysRequired(1);
		
		Task t2 = new Task("Task2");
		t2.setSkillRequired(Skill.PHP);
		t2.setDaysRequired(3);
		
		Task t3 = new Task("Task3");
		t3.setSkillRequired(Skill.PYTHON);
		t3.setDaysRequired(4);
		t3.addPredecessor(t1);
		
		
		User u1 = new User("Puneet");
		u1.addSkill(Skill.JAVA);
		u1.addSkill(Skill.PHP);
		
		User u2 = new User("Satya");
		u2.addSkill(Skill.PYTHON);
		   
		project.addTask(t1);
		project.addTask(t2);
		project.addTask(t3);
		
		project.addUser(u1);
		project.addUser(u2);
		
		this.project=project;
	}
	
	
	
}
