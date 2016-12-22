package com.mindtree.evtmanagement.dto;

import java.util.Date;
import java.util.List;

public class EmployeeDto {

	private String mid;
	
	private String name;
	
	private Date joiningDate;
	
	private String emailId;

	private List<EventDto> events;
	
	public List<EventDto> getEvents() {
		return events;
	}

	public void setEvents(List<EventDto> events) {
		this.events = events;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
