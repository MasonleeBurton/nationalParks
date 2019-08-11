package com.techelevator.npgeek.database;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Weather;

@Component
public class JDBCWeatherDAO implements WeatherDAO {

private JdbcTemplate jdbcTemplate;
private NPGeekUtilities ut = new NPGeekUtilities();

@Autowired
public JDBCWeatherDAO(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
}


public Queue<Weather> getWeatherByParkCode(String parkCode) {
	Queue<Weather> weatherList = new LinkedList<>();
    String sqlSelectWeatherByParkCode = "SELECT parkcode, fivedayforecastvalue, low, high, forecast FROM weather WHERE parkcode = ?";
    SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectWeatherByParkCode, parkCode);
    while (results.next()) {
        weatherList.add(mapToRowWeather(results));
    }
    return weatherList;
}

@Override
public Weather getDailyWeather(Integer fiveDayForecastValue, String parkCode, String indicator) {
	Queue<Weather> weatherList = getWeatherByParkCode(parkCode);
	Map<Integer, Weather> weatherMap = new HashMap<>();
    for(Weather dailyWeather : weatherList) {
    	weatherMap.put(dailyWeather.getFiveDayForecastValue(), dailyWeather);
    }
    Weather newWeather = weatherMap.get(fiveDayForecastValue);
    newWeather.setHigh(ut.temperatureConversion(newWeather.getHigh(), indicator));
    newWeather.setLow(ut.temperatureConversion(newWeather.getLow(), indicator));
    newWeather.setIndicator(indicator);
    return newWeather;
}



private Weather mapToRowWeather(SqlRowSet row) {
    Weather weather = new Weather();
    weather.setParkCode(row.getString("parkcode"));
    weather.setFiveDayForecastValue(row.getInt("fivedayforecastvalue"));
    weather.setLow(row.getInt("low"));
    weather.setHigh(row.getInt("high"));
    weather.setForecast(row.getString("forecast"));
    weather.setForecastMessage(getForecastMessage(row.getString("forecast")));
    weather.setHighLowMessage(getHighLowMessage(row.getInt("low"), row.getInt("high")));
    weather.setImageName(row.getString("forecast"));
    return weather;
}

private String getForecastMessage(String forecast) {
    Map<String, String> messageMap = new HashMap<>();
    messageMap.put("snow", "Remember to pack your snow shoes!");
    messageMap.put("rain", "Remember to pack your rain gear, and don't forget to wear waterproof shoes!");
    messageMap.put("thunderstorms", "Please seek shelter and avoid hiking on exposed ridges!");
    messageMap.put("sunny", "Don't forget your sunblock!");

    if (messageMap.containsKey(forecast)) {
        return messageMap.get(forecast);
    } else
        return "";
}

private String getHighLowMessage(int low, int high) {
    int difference = high - low;
    String message = "";
    if (high > 75) {
        message = "You should probably bring an extra gallon of water! ";
        if (difference > 20) {
            message = message + "And make sure to wear breathable layers! ";
        }

    }
    if (low < 20) {
        message = message
                + "Warning: There are many dangers that result from exposure to frigid temperatures! Make sure to prepare accordingly! ";
        if (difference > 20 && high<75) {
            message = message + "Also, make sure to wear breathable layers!";
        }

    }
    return message;

}
}