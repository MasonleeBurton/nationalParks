package com.techelevator.npgeek.model;

public class Weather {

private String parkCode;
private Integer fiveDayForecastValue;
private int low;
private int high;
private String forecast;
private String forecastMessage;
private String highLowMessage;
private String imageName;
private String indicator;

public String getParkCode() {
    return parkCode;
}
public void setParkCode(String parkCode) {
    this.parkCode = parkCode;
}
public int getFiveDayForecastValue() {
    return fiveDayForecastValue;
}
public void setFiveDayForecastValue(Integer fiveDayForecastValue) {
    this.fiveDayForecastValue = fiveDayForecastValue;
}
public int getLow() {
    return low;
}
public void setLow(int low) {
    this.low = low;
}
public int getHigh() {
    return high;
}
public void setHigh(int high) {
    this.high = high;
}
public String getForecast() {
    return forecast;
}
public void setForecast(String forecast) {
    this.forecast = forecast;
}
public String getForecastMessage() {
    return forecastMessage;
}
public void setForecastMessage(String forecastMessage) {
    this.forecastMessage = forecastMessage;
}
public String getHighLowMessage() {
    return highLowMessage;
}
public void setHighLowMessage(String highLowMessage) {
    this.highLowMessage = highLowMessage;
}
public String getImageName() {
	return imageName;
}
public void setImageName(String imageName) {
	
		String[] splitString = imageName.split(" ");
		if(splitString.length > 1) {
		char firstChar = splitString[1].charAt(0);
		String secondChar = String.valueOf(firstChar).toUpperCase();
		char fixed = secondChar.charAt(0);
		String secondWord = splitString[1].replace(firstChar, fixed);
		this.imageName = splitString[0] + secondWord + ".png";
		}
		else this.imageName = imageName + ".png";
}
public String getIndicator() {
	return "°" + indicator;
}
public void setIndicator(String indicator) {
	this.indicator = indicator;
}


}
