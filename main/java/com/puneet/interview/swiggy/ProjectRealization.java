package com.puneet.interview.swiggy;

import java.util.List;

public interface ProjectRealization {

	public ProjectPlan getProjectCompletionPlan(int projectId);
	
	public List<Task> getUserTasks(int projectId, int userid);
	
}

class ProjectRealicationImplimentation implements ProjectRealization{
	
	public ProjectRealicationImplimentation(Project project) {
		for (Task task: project.getTasks()) {
			completeTask(task, project);
		}
	}

	private void completeTask(Task task, Project project) {
		for (Task t : task.getPredessorTask()) {
			if (t.getStatus()==Task.STATUS.COMPLETED) {
				//Task is completed move ahead. 
			}else {
				completeTask(t,project);
			}
		}
		Skill skill = task.getSkillRequired();
		List<User> users = project.getSkillUserMap().get(skill);
		
		int minimalCompletion = Integer.MAX_VALUE;
		User currentUser=null;
		for (User user: users) {
			int finaloutput = getLastCompletionDate(user,task.getDaysRequired());
			if (finaloutput<minimalCompletion) {minimalCompletion=finaloutput; currentUser= user;}
		}
		currentUser.getHistory().put(currentUser.getLastAvailableDay()+"-"+minimalCompletion, task.getTaskName());
		task.setStatus(Task.STATUS.COMPLETED);
		currentUser.setLastAvailableDay(minimalCompletion);
		task.setCompletedUser(currentUser);
		
	}


	private int getLastCompletionDate(User user, Integer daysRequired) {
		//TODO Have to add the leave plans here. 
		return user.getLastAvailableDay()+daysRequired;
	}


	public ProjectPlan getProjectCompletionPlan(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Task> getUserTasks(int projectId, int userid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
