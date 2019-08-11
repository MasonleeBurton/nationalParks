package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.database.NPGeekUtilities;

public class NPGeekUtilitiesIntegrationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void temperatureConversionTest() {
		NPGeekUtilities utilities = new NPGeekUtilities();
		
		assertNotNull(utilities.temperatureConversion(58, "C"));
		assertEquals(76, utilities.temperatureConversion(76, "F"));
		assertEquals(-13, utilities.temperatureConversion(8, "C"));
	}

}
