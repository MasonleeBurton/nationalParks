package com.techelevator.npgeek.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Survey {

	private long surveyId;
	
	
	@NotEmpty(message = "Please input a park name")
	@NotNull(message = "Please input a park name")
	@NotBlank(message = "Please input a park name")
	private String parkCode;

	@NotBlank(message = "Please input an email address")
	@Email(message = "Email must be a valid email address")
	private String emailAddress;

	@NotBlank(message = "Please input a state")
	@NotEmpty(message = "Please input a state")
	@NotNull(message = "Please input a state")
	private String state;

	
	@NotNull(message = "Please input your activity level")
	private String activityLevel;

	// getters and setters
	public long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(long surveyId) {
		this.surveyId = surveyId;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

}
