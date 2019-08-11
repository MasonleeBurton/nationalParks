package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Queue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.database.JDBCWeatherDAO;
import com.techelevator.npgeek.model.Weather;

public class JDBCWeatherDAOIntegrationTest extends DAOIntegrationTest {

	JdbcTemplate jdbcTemplate = new JdbcTemplate(this.getDataSource());
	private JDBCWeatherDAO dao = new JDBCWeatherDAO(this.getDataSource());
	
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
	
		String sqlCreateWeatherConditions = "INSERT INTO weather(parkCode, fiveDayForecastValue, low, high, forecast) VALUES ('ABCD',1,27,40,'snow');\n" + 
				"INSERT INTO weather(parkCode, fiveDayForecastValue, low, high, forecast) VALUES ('ABCD',2,20,79,'sunny');\n" + 
				"INSERT INTO weather(parkCode, fiveDayForecastValue, low, high, forecast) VALUES ('ABCD',3,19,76,'partly cloudy');\n" + 
				"INSERT INTO weather(parkCode, fiveDayForecastValue, low, high, forecast) VALUES ('ABCD',4,50,76,'cloudy');\n" + 
				"INSERT INTO weather(parkCode, fiveDayForecastValue, low, high, forecast) VALUES ('ABCD',5,25,32,'thunderstorms');";
		jdbcTemplate.update(sqlCreateWeatherConditions);
		
	}

	@Test
	public void getWeatherByParkCodeTest() {
		Queue<Weather> weatherList = dao.getWeatherByParkCode("ABCD");
		Weather weatherOfTheDay = weatherList.peek();
		
		assertNotEquals(null, weatherList);
		assertNotEquals(null, weatherOfTheDay);
		assertEquals(1, weatherOfTheDay.getFiveDayForecastValue());
		assertEquals("snow", weatherOfTheDay.getForecast());
		assertEquals(40, weatherOfTheDay.getHigh());
	}
	
	@Test
	public void getForecastMessageTest() {
		Queue<Weather> weatherList = dao.getWeatherByParkCode("ABCD");
		Weather weatherOfTheDay = weatherList.poll();
		
		assertNotEquals(null, weatherList);
		assertNotEquals(null, weatherOfTheDay);
		assertEquals(1, weatherOfTheDay.getFiveDayForecastValue());
		assertEquals("Remember to pack your snow shoes!", weatherOfTheDay.getForecastMessage());
		
		weatherOfTheDay = weatherList.poll();
		assertNotEquals(null, weatherOfTheDay);
		assertEquals(2, weatherOfTheDay.getFiveDayForecastValue());
		assertEquals("Don't forget your sunblock!", weatherOfTheDay.getForecastMessage());
		
		weatherOfTheDay = weatherList.poll();
		assertNotEquals(null, weatherOfTheDay);
		assertEquals(3, weatherOfTheDay.getFiveDayForecastValue());
		assertEquals("", weatherOfTheDay.getForecastMessage());
	}
	
	@Test
	public void getHighLowMessageTest() {
		Queue<Weather> weatherList = dao.getWeatherByParkCode("ABCD");
		Weather weatherOfTheDay = weatherList.poll();
		
		assertNotEquals(null, weatherList);
		assertNotEquals(null, weatherOfTheDay);
		assertEquals(1, weatherOfTheDay.getFiveDayForecastValue());
		assertEquals(27, weatherOfTheDay.getLow());
		assertEquals(40, weatherOfTheDay.getHigh());
		assertEquals("", weatherOfTheDay.getHighLowMessage());
		
		weatherOfTheDay = weatherList.poll();
		assertEquals(2, weatherOfTheDay.getFiveDayForecastValue());
		assertEquals(20, weatherOfTheDay.getLow());
		assertEquals(79, weatherOfTheDay.getHigh());
		assertEquals("You should probably bring an extra gallon of water! And make sure to wear breathable layers! ", weatherOfTheDay.getHighLowMessage());
		
		weatherOfTheDay = weatherList.poll();
		assertEquals(3, weatherOfTheDay.getFiveDayForecastValue());
		assertEquals(19, weatherOfTheDay.getLow());
		assertEquals(76, weatherOfTheDay.getHigh());
		assertEquals("You should probably bring an extra gallon of water! And make sure to wear breathable layers! Warning: There are many dangers that result from exposure to frigid temperatures! Make sure to prepare accordingly! ", weatherOfTheDay.getHighLowMessage());
	}

}
