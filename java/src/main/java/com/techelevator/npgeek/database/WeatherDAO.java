package com.techelevator.npgeek.database;

import java.util.Queue;

import com.techelevator.npgeek.model.Weather;

public interface WeatherDAO {
	
	public Queue<Weather> getWeatherByParkCode(String parkCode);
	public Weather getDailyWeather(Integer fiveDayForecastValue, String parkCode, String indicator);
}
