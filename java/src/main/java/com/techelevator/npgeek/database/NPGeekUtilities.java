package com.techelevator.npgeek.database;

public class NPGeekUtilities {

public int temperatureConversion(int temperature, String degreeSymbol) {
	
    if(degreeSymbol.matches("F")) {
        return temperature;
    }
    if(degreeSymbol.matches("C")) {
        temperature = (temperature - 32) * 5/9;
        return temperature;
    }
    else return 0;
}

public String formatFee(int fee) {
    return "$" + fee + ".00";
}
}