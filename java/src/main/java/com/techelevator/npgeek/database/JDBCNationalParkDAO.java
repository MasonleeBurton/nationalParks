package com.techelevator.npgeek.database;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.NationalPark;

@Component
public class JDBCNationalParkDAO implements NationalParkDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCNationalParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<NationalPark> getAllParks() {
		List<NationalPark> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			allParks.add(mapToRowPark(results));
		}
		return allParks;
	}

	@Override
	public NationalPark getParkByParkCode(String parkCode) {

		NationalPark park = null;
		String sqlSelectParkByParkCode = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkByParkCode, parkCode);
		if (results.next()) {
			park = mapToRowPark(results);
		}
		return park;

	}

	@Override
	public Queue<NationalPark> listOfParksOrderedBySurveyCount() {
		Queue<NationalPark> allParks = new LinkedList<>();
		String sqlSelectAllParks = "SELECT count(survey_result.parkcode) AS surveyCount, park.parkname, park.parkcode\n"
				+ "FROM survey_result\n" + "JOIN park ON park.parkcode = survey_result.parkcode\n"
				+ "GROUP BY park.parkname, park.parkcode\n" + "ORDER BY surveyCount DESC, park.parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			allParks.add(mapToRowParkWithSurvey(results));
		}
		return allParks;
	}

	private NationalPark mapToRowPark(SqlRowSet row) {
		NationalPark park = new NationalPark();
//		park.setSurveyCount(row.getInt("surveyCount"));
		park.setParkCode(row.getString("parkcode"));
		park.setParkName(row.getString("parkname"));
		park.setState(row.getString("state"));
		park.setAcreage(row.getInt("acreage"));
		park.setElevationInFeet(row.getInt("elevationinfeet"));
		park.setMilesOfTrail(row.getFloat("milesoftrail"));
		park.setNumberOfCampsites(row.getInt("numberofcampsites"));
		park.setClimate(row.getString("climate"));
		park.setYearFounded(row.getInt("yearfounded"));
		park.setAnnualVisitorCount(row.getInt("annualvisitorcount"));
		park.setInspirationalQuote(row.getString("inspirationalquote"));
		park.setInspirationalQuoteSource(row.getString("inspirationalquotesource"));
		park.setParkDescription(row.getString("parkdescription"));
		park.setEntryFee(row.getInt("entryfee"));
		park.setNumberOfAnimalSpecies(row.getInt("numberofanimalspecies"));
		park.setImageName(row.getString("parkcode"));
		park.setName(row.getString("parkname"));
		return park;
	}
	
	private NationalPark mapToRowParkWithSurvey(SqlRowSet row) {
		NationalPark park = new NationalPark();
		park.setSurveyCount(row.getInt("surveyCount"));
		park.setParkName(row.getString("parkname"));
		park.setParkCode(row.getString("parkcode"));
		park.setImageName(row.getString("parkcode"));
		park.setName(row.getString("parkname"));
		return park;
	}
}
