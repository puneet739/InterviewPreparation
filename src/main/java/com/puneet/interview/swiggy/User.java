package com.puneet.interview.swiggy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class User {

	private String userName;
	private List<Skill> skills = new LinkedList<Skill>();
	private Boolean[] freeUser = new Boolean[100];
	private Integer lastAvailableDay=0;
	private Map<String, String> history = new HashMap<String, String>();
	
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
		for (int i=startDay; i<=endDay ; i++)  freeUser[i]=false;
	}

	public Boolean[] getFreeUser() {
		return freeUser;
	}

	public void setFreeUser(Boolean[] freeUser) {
		this.freeUser = freeUser;
	}

	public Map<String, String> getHistory() {
		return history;
	}

	public void setHistory(Map<String, String> history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", skills=" + skills
				+ ", lastAvailableDay=" + lastAvailableDay + ", history=" + history + "]";
	}
}
