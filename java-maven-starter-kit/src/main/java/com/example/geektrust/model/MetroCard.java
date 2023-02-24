package com.example.geektrust.model;

public class MetroCard {
	    private final String cardNo;
	    private int amount;
	    private boolean trip;

	    public MetroCard(String[] arguments) {
	        this.cardNo = arguments[1];
	        this.amount = Integer.parseInt(arguments[2]);
	        trip = false;
	    }

	    public int getAmount() {
	        return amount;
	    }

	    public boolean getTrip() {
	        return trip;
	    }

	    public void setAmount(int amount) {
	        this.amount = amount;
	    }

	    public void setTrip(boolean trip) {
	        this.trip = trip;
	    }
}
