package com.example.geektrust.model;

public class StationEntryDetails {

	   private String cardNo;
	    private String typeOfPassenger;
	    private String departureFrom;

	    public StationEntryDetails(String[] arguments) {
	        this.cardNo = arguments[1];
	        this.typeOfPassenger = arguments[2];
	        this.departureFrom = arguments[3];
	    }
	    
	    public String getCardNo() {
	        return cardNo;
	    }

	    public String getTypeOfPassenger() {
	        return typeOfPassenger;
	    }

	    public String getDepartureFrom() {
	        return departureFrom;
	    }
	
}
