package com.techelevator;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.database.JDBCSurveyDAO;
import com.techelevator.npgeek.model.Survey;

public class JDBCSurveyDAOIntegrationTest extends DAOIntegrationTest {
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
	private JDBCSurveyDAO dao = new JDBCSurveyDAO(this.getDataSource());
	
	@Before
	public void setUp() throws Exception {
		String sqlCreatePark = "INSERT INTO park(parkCode, parkName, state, acreage, elevationInFeet, milesOfTrail, numberOfCampsites, "
				+ "climate, yearFounded, annualVisitorCount, inspirationalQuote, inspirationalQuoteSource, parkDescription, entryFee, "
				+ "numberOfAnimalSpecies) "
				+ "VALUES ('ABCD', 'Test National Park', 'Kentucky', 12345, 987, 5678, 2, 'Woodland', 2019, 987654, "
				+ "'This is the easiest capstone yet', 'Steve Carmichael', 'Text Script "
				+ "Text Script Text Script Text Script Text Script Text Script "
				+ "Text Script Text Script Text Script Text Script Text Script Text Script "
				+ "Text Script Text Script Text Script Text Script Text Script "
				+ "Text Script Text Script Text Script Text Script Text Script', 27, ?)";
		jdbcTemplate.update(sqlCreatePark, 3);
	}
	
	@Test
	public void getAllSurveysTest() {
		List<Survey> allSurveys = dao.getAllSurveys();
		
		assertNotEquals(null, allSurveys);
	}

	@Test
	public void saveSurveyTest() {
		
		Survey survey = new Survey();
		survey.setParkCode("ABCD");
		survey.setEmailAddress("brian@hotmail.com");
		survey.setState("Colorado");
		survey.setActivityLevel("active");
		
		dao.saveSurvey(survey);
		List<Survey> allSurveys = dao.getAllSurveys();
		
		assertNotEquals(null, survey);
		assertTrue(allSurveys.size() >=1);
	}

}
