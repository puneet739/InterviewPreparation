package com.puneet.interview.swiggy;

import java.util.ArrayList;
import java.util.List;

public interface ProjectRealization {

	public ProjectPlan getProjectCompletionPlan(int projectId);
	
	public List<Task> getUserTasks(int projectId, int userid);
	
}

class ProjectRealicationImplimentation implements ProjectRealization{
	
	public ProjectRealicationImplimentation(Project project) {
		List<String> visitedTasks = new ArrayList<String>(); 
		// DFS in dependency order
		for (Task task: project.getTasks()) {
			if(!task.getStatus().equals(TaskStatus.COMPLETED))
				completeTask(task, project, visitedTasks);
		}
	}

	private void completeTask(Task task, Project project, List<String> visitedTasks) {
		Interval taskInterval = new Interval(0, 0);
		int lastDependentCompletionDay = 0; // incase of task dependencies, this will hold last dependent task completion day
		for (Task t : task.getPredessorTask()) {
			// if any dependent tasks not completed, can't schedule this task
			if(t.getStatus() != TaskStatus.COMPLETED){
				completeTask(t, project, visitedTasks);
			}
			lastDependentCompletionDay = Math.max(lastDependentCompletionDay, t.getTaskSpan().getEnd());
		}
		Skill skill = task.getSkillRequired();
		List<User> users = project.getSkillUserMap().get(skill);
		
		int minimalCompletion = Integer.MAX_VALUE;
		
		User currentUser=null;
		for (User user: users) {
				//offset desired task Interval as per last dependency completion day
				int lastAvailDay = (lastDependentCompletionDay != 0) ? lastDependentCompletionDay : user.getLastAvailableDay();
				taskInterval.setStart(lastAvailDay+1);
				taskInterval.setEnd(lastAvailDay+task.getDaysRequired());
				taskInterval = getLastCompletionDate(user,task.getDaysRequired(), taskInterval);
				int finaloutput = taskInterval.getEnd();
				if (finaloutput<minimalCompletion) {
					minimalCompletion=finaloutput;
					currentUser= user;
				}
		}
		//Must handle this case,where there is no user exist with task skill
		if(null != currentUser){
			currentUser.getHistory().put(taskInterval, task.getTaskName());
			task.setStatus(TaskStatus.COMPLETED);
			task.setTaskSpan(taskInterval);
			currentUser.setLastAvailableDay(minimalCompletion);
			task.setCompletedUser(currentUser);
			project.setUnfinishedTaskCount(project.getUnfinishedTaskCount()-1);
 	 	}else{
			System.out.println("Currently, There is no user/member exist with required skill of the give task: " + task);
		}
		
		
	}


	private Interval getLastCompletionDate(User user, Integer daysRequired, Interval taskInterval) {
		//TODO Have to add the leave plans here. 
		return user.getTaskCompletionDate(daysRequired, taskInterval);
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
