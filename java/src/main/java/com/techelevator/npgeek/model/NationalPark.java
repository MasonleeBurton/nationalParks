package com.techelevator.npgeek.model;

public class NationalPark {

	private int surveyCount;
	private String parkCode;
	private String parkName;
	private String state;
	private int acreage;
	private int elevationInFeet;
	private float milesOfTrail;
	private int numberOfCampsites;
	private String climate;
	private int yearFounded;
	private int annualVisitorCount;
	private String inspirationalQuote;
	private String inspirationalQuoteSource;
	private String parkDescription;
	private int entryFee;
	private int numberOfAnimalSpecies;
	private String imageName;
	private String name;

	// getters and setters
	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAcreage() {
		String acreageString = String.format("%,d", this.acreage);
		return acreageString;
	}

	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}

	public String getElevationInFeet() {
		String elevationInFeetString = String.format("%,d", this.elevationInFeet);
		return elevationInFeetString;
	}

	public void setElevationInFeet(int elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}

	public float getMilesOfTrail() {
		return milesOfTrail;
	}

	public void setMilesOfTrail(float milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}

	public int getNumberOfCampsites() {
		return numberOfCampsites;
	}

	public void setNumberOfCampsites(int numberOfCampsites) {
		this.numberOfCampsites = numberOfCampsites;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public int getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}

	public String getAnnualVisitorCount() {
		
		String annualVisitorCountString = String.format("%,d", this.annualVisitorCount);
		return annualVisitorCountString;
	}

	public void setAnnualVisitorCount(int annualVisitorCount) {
		
		this.annualVisitorCount = annualVisitorCount;
	}

	public String getInspirationalQuote() {
		return inspirationalQuote;
	}

	public void setInspirationalQuote(String inspirationalQuote) {
		this.inspirationalQuote = inspirationalQuote;
	}

	public String getInspirationalQuoteSource() {
		return inspirationalQuoteSource;
	}

	public void setInspirationalQuoteSource(String inspirationalQuoteSource) {
		this.inspirationalQuoteSource = inspirationalQuoteSource;
	}

	public String getParkDescription() {
		return parkDescription;
	}

	public void setParkDescription(String parkDescription) {
		this.parkDescription = parkDescription;
	}

	public int getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}

	public int getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}

	public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		String lowCase = imageName.toLowerCase();

		this.imageName = lowCase + ".jpg";
	}

	public int getSurveyCount() {
		return surveyCount;
	}

	public void setSurveyCount(int surveyCount) {
		this.surveyCount = surveyCount;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		String[] nameArray = name.split("National");
		this.name = nameArray[0];
	}

}
