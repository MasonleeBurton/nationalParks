package com.techelevator.npgeek.database;

import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

import com.techelevator.npgeek.model.NationalPark;

public interface NationalParkDAO {

public List<NationalPark> getAllParks();
public NationalPark getParkByParkCode(String parkCode);
public Queue<NationalPark> listOfParksOrderedBySurveyCount();

}