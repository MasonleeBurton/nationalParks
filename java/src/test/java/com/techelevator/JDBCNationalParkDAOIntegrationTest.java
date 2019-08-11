package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.database.JDBCNationalParkDAO;
import com.techelevator.npgeek.model.NationalPark;

public class JDBCNationalParkDAOIntegrationTest extends DAOIntegrationTest{
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
	private JDBCNationalParkDAO dao = new JDBCNationalParkDAO(this.getDataSource());

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
		
		String sqlCreateNewSurvey5Times = "\n" + 
				"INSERT INTO survey_result(parkCode, emailAddress, state, activityLevel) \n" + 
				"VALUES ('ABCD','ashton@hotmail.com','Idaho','inactive');\n" + 
				"INSERT INTO survey_result(parkCode, emailAddress, state, activityLevel) \n" + 
				"VALUES ('ABCD','ashton@hotmail.com','Idaho','inactive');\n" + 
				"INSERT INTO survey_result(parkCode, emailAddress, state, activityLevel) \n" + 
				"VALUES ('ABCD','ashton@hotmail.com','Idaho','inactive');\n" + 
				"INSERT INTO survey_result(parkCode, emailAddress, state, activityLevel) \n" + 
				"VALUES ('ABCD','ashton@hotmail.com','Idaho','inactive');\n" + 
				"INSERT INTO survey_result(parkCode, emailAddress, state, activityLevel) \n" + 
				"VALUES ('ABCD','ashton@hotmail.com','Idaho','inactive');";
		jdbcTemplate.update(sqlCreateNewSurvey5Times);
	}

	@Test
	public void getAllParksTest() {
		List<NationalPark> allParks = dao.getAllParks();
		
		assertNotEquals(null, allParks);
		assertEquals("ABCD", allParks.get(allParks.size()-1).getParkCode());
		
	}

	@Test
	public void getParkByParkCodeTest() {
		NationalPark park = dao.getParkByParkCode("ABCD");
		
		assertNotEquals(null, park);
		assertEquals("Test National Park", park.getParkName());
	}
	
	@Test
	public void getParksOrderedBySurveyCountTest() { //hitting issue with test when survey number increases
		
		Queue<NationalPark> parks = dao.listOfParksOrderedBySurveyCount();
		for(NationalPark park : parks) {
			System.out.println(park.getParkCode());
		}
		
		assertNotEquals(null, parks);
		assertEquals("ABCD", parks.peek().getParkCode());
	}
	
	
}
