package com.techelevator.npgeek.database;

import java.util.List;

import com.techelevator.npgeek.model.Survey;

public interface SurveyDAO {

	public void saveSurvey(Survey survey);
	
	public List<Survey> getAllSurveys();
}