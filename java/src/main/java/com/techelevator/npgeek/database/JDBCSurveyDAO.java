package com.techelevator.npgeek.database;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Survey;

@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveSurvey(Survey survey) {
		String sqlInsertSurvey = "INSERT INTO survey_result(parkCode, emailAddress, state, activityLevel) \n"
				+ "VALUES (?, ?, ?, ?);";
		jdbcTemplate.update(sqlInsertSurvey, survey.getParkCode(), survey.getEmailAddress(), survey.getState(),
				survey.getActivityLevel());
	}

	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> allSurveys = new ArrayList<>();
		String sqlSelectAllSurveys = "SELECT * FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while (results.next()) {
			allSurveys.add(mapToRowSurvey(results));
		}
		return allSurveys;
	}

	private Survey mapToRowSurvey(SqlRowSet row) {
		Survey survey = new Survey();

		survey.setActivityLevel(row.getString("activitylevel"));
		survey.setEmailAddress(row.getString("emailaddress"));
		survey.setParkCode(row.getString("parkcode"));
		survey.setState(row.getString("state"));

		return survey;
	}
}