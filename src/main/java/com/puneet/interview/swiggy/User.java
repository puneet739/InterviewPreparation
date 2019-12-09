package com.puneet.interview.swiggy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class User {

	private String userName;
	private List<Skill> skills = new LinkedList<Skill>();
	private List<Interval> userHolidayPlans = new ArrayList<Interval>();
	private Integer lastAvailableDay=0;
	private Map<Interval, String> history = new HashMap<Interval, String>();
	
	public User(String name) {
		this.userName=name;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void addSkill(Skill skill) {
		skills.add(skill);
	}
	
	public void removeSkill(Skill skill) {
		skills.remove(skill);
	}


	public Integer getLastAvailableDay() {
		return lastAvailableDay;
	}

	public void setLastAvailableDay(Integer lastAvailableDay) {
		this.lastAvailableDay = lastAvailableDay;
	}
	
	public void addHoliday(int startDay, int endDay) {
		userHolidayPlans.add(new Interval(startDay, endDay));
	}

	/**
	 * @return the userHolidayPlans
	 */
	public List<Interval> getUserHolidayPlans() {
		return userHolidayPlans;
	}

	/**
	 * @param userHolidayPlans the userHolidayPlans to set
	 */
	public void setUserHolidayPlans(List<Interval> userHolidayPlans) {
		this.userHolidayPlans = userHolidayPlans;
	}


	/**
	 * @return the history
	 */
	public Map<Interval, String> getHistory() {
		return history;
	}

	/**
	 * @param history the history to set
	 */
	public void setHistory(Map<Interval, String> history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", skills=" + skills
				+ ", lastAvailableDay=" + lastAvailableDay + ", history=" + history + "]";
	}

	/**
	 * 
	 * @param daysRequired
	 * @return true, after checking user holidayplans
	 */
	public boolean isUserFree(Integer daysRequired) {
		return false;
	}

	/**
	 * 
	 * @param daysRequired
	 * @return possible task completion duration for this user considering his leave plans
	 */
	public Interval getTaskCompletionDate(Integer daysRequired, Interval taskInterval) {
		// check for overlaps with user holiday plans
		for(Interval leave: this.getUserHolidayPlans()){
			if(taskInterval.isOverlapped(leave)){
				taskInterval.setStart(Math.max(leave.getEnd(), taskInterval.getEnd()) + 1);
				taskInterval.setEnd(taskInterval.getStart()+daysRequired-1);
			}else{
				// found a span where task can be picked by the user
				break;
			}
		}
		return taskInterval;
	}

	/**
	 * 
	 * @param i
	 * @return true, if user is free/available on this day
	 */
	public boolean isFreeThisDay(int day) {
		for(Interval i: userHolidayPlans){
			if(i.isDayOverlapped(day)){
				System.out.println(this.userName + " is on PTO this #day " +day);
				return false;
			}
		}
		for(Interval i: history.keySet()){
			if(i.isDayOverlapped(day)){
				System.out.println(this.userName + " is working on " + history.get(i) + " this #day "+day);
				return false;
			}
		}
		return true;
	}
}
