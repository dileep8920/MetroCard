package com.example.geektrust.service;

import java.util.ArrayList;

import com.example.geektrust.model.StationEntryDetails;
import com.example.geektrust.model.Inputs;
import com.example.geektrust.model.MetroCard;
import com.example.geektrust.model.Airport;
import com.example.geektrust.model.Central;

public class TotalExpense {
        private final String adult = "ADULT";
        private final String seniorCitizen = "SENIOR_CITIZEN";
        private final String kid = "KID";
        private final String centrals = "CENTRAL";
        private final String airports = "AIRPORT";
	    private final Integer ac = 200;
	    private final Integer scc = 100;
	    private final Integer kc = 50;
	    private final float rf = 0.02f;
	    private final Integer two = 2;

	    private Inputs input = new Inputs();
	    private ArrayList<StationEntryDetails> checkInDetails = input.getdetailsOfCheckIn();
	    private static Central central = new Central();
	    private static Airport airport = new Airport();

	    public void totalCollection() {

	    	
	    	for(int i=0;i<checkInDetails.size();i++) {
	    		String cardNumber=checkInDetails.get(i).getCardNo();
	    		String typeOfPassenger=checkInDetails.get(i).getTypeOfPassenger();
	    		String departureFrom=checkInDetails.get(i).getDepartureFrom();
	    		
	    		   MetroCard cardObject = input.getdetailsOfCard(cardNumber);

		            updateCard(typeOfPassenger, departureFrom, cardObject);
	    	}
	    }
	    	

	    //This method recharges MetroCard balance with the required amount
	    //and returns the service charge
	    private int rechargeCard(MetroCard cardObject, int requiredAmount) {
	        int balance = cardObject.getAmount();
	        int availableBalance = requiredAmount - balance;
	        int serviceCharge = (int)(rf*availableBalance);

	        cardObject.setAmount(balance + availableBalance);

	        return serviceCharge;
	    }

	    private void updateCard(String typeOFPassenger, String departureFrom, MetroCard cardObject) {
	        if (typeOFPassenger.equals(adult)) {
	            if (departureFrom.equals(centrals)) {
	                centralAdultUpdate(cardObject);
	            }
	            else if (departureFrom.equals(airports)) {
	                airportAdultUpdate(cardObject);
	            }
	        }

	        if (typeOFPassenger.equals(seniorCitizen)) {
	            if (departureFrom.equals(centrals)) {
	                centralSeniorCitizenUpdate(cardObject);
	            }
	            else if (departureFrom.equals(airports)) {
	                airportSeniorCitizenUpdate(cardObject);
	            }
	        }

	        if (typeOFPassenger.equals(kid)) {
	            if (departureFrom.equals(centrals)) {
	                centralKidUpdate(cardObject);
	            }
	            else if (departureFrom.equals(airports)) {
	                airportKidUpdate(cardObject);
	            }
	        }
	    }

	    private void updateMetroCardObject(MetroCard cardObject, int cost) {
	        int cardBalance = cardObject.getAmount();

	        cardObject.setAmount(cardBalance - cost);

	        if (cardObject.getTrip())
	            cardObject.setTrip(false);
	        else
	            cardObject.setTrip(true);
	    }

	    private void centralAdultUpdate(MetroCard cardObject) {
	        int cardBalance = cardObject.getAmount();
	        int serviceCharge = 0;
	        if (!cardObject.getTrip()) {
	            if (cardBalance < ac) {
	                serviceCharge = rechargeCard(cardObject, ac);
	            }
	            central.setbalance(ac + serviceCharge);
	            updateMetroCardObject(cardObject, ac);
	        }
	        else {
	            if (cardBalance < ac/two) {
	                serviceCharge = rechargeCard(cardObject, ac/two);
	            }
	            central.setbalance(ac/two + serviceCharge);
	            central.setDiscount(ac/two);
	            updateMetroCardObject(cardObject, ac/two);
	        }
	        central.incAdult();

	    }

	    private void airportAdultUpdate(MetroCard cardObject) {
	        int cardBalance = cardObject.getAmount();
	        int cost = 0;
	        if (!cardObject.getTrip()) {
	            if (cardBalance < ac) {
	                cost = rechargeCard(cardObject, ac);
	            }
	            airport.setbalance(ac + cost);
	            updateMetroCardObject(cardObject, ac);
	        }
	        else {
	            if (cardBalance < ac/two) {
	                cost = rechargeCard(cardObject, ac/two);
	            }
	            airport.setbalance(ac/two + cost);
	            airport.setDiscount(ac/two);
	            updateMetroCardObject(cardObject, ac/two);
	        }
	        airport.incAirportAdult();
	    }

	    private void centralSeniorCitizenUpdate(MetroCard cardObject) {
	        int cardBalance = cardObject.getAmount();
	        int cost = 0;
	        if (!cardObject.getTrip()) {
	            if (cardBalance < scc) {
	                cost = rechargeCard(cardObject, scc);
	            }
	            central.setbalance(scc + cost);
	            updateMetroCardObject(cardObject, scc);
	        }
	        else {
	            if (cardBalance < scc/two) {
	                cost = rechargeCard(cardObject, scc/ two);
	            }
	            central.setbalance(scc/two + cost);
	            central.setDiscount(scc/two);
	            updateMetroCardObject(cardObject, scc/two);
	        }
	        central.incSeniorCitizen();
	    }

	    private void airportSeniorCitizenUpdate(MetroCard cardObject) {
	        int cardBalance = cardObject.getAmount();
	        int cost = 0;
	        if (!cardObject.getTrip()) {
	            if (cardBalance < scc) {
	                cost = rechargeCard(cardObject, scc);
	            }
	            airport.setbalance(scc + cost);
	            updateMetroCardObject(cardObject, scc);
	        }
	        else {
	            if (cardBalance < scc/two) {
	                cost = rechargeCard(cardObject, scc/two);
	            }
	            airport.setbalance(scc/two + cost);
	            airport.setDiscount(scc/two);
	            updateMetroCardObject(cardObject, scc/two);
	        }
	        airport.incAirportSenior();
	    }

	    private void centralKidUpdate(MetroCard cardObject) {
	        int cardBalance = cardObject.getAmount();
	        int cost = 0;
	        if (!cardObject.getTrip()) {
	            if (cardBalance < kc) {
	                cost = rechargeCard(cardObject, kc);
	            }
	            central.setbalance(kc + cost);
	            updateMetroCardObject(cardObject, kc);
	        }
	        else {
	            if (cardBalance < kc/two) {
	                cost = rechargeCard(cardObject, kc/two);
	            }
	            central.setbalance(kc/two + cost);
	            central.setDiscount(kc/two);
	            updateMetroCardObject(cardObject, kc/two);
	        }
	        central.incKid();
	    }

	    private void airportKidUpdate(MetroCard cardObject) {
	        int cardBalance = cardObject.getAmount();
	        int cost = 0;
	        if (!cardObject.getTrip()) {
	            if (cardBalance < kc) {
	                cost = rechargeCard(cardObject, kc);
	            }
	            airport.setbalance(kc + cost);
	            updateMetroCardObject(cardObject, kc);
	        }
	        else {
	            if (cardBalance < kc/two) {
	                cost = rechargeCard(cardObject, kc/two);
	            }
	            airport.setbalance(kc/two + cost);
	            airport.setDiscount(kc/ two);
	            updateMetroCardObject(cardObject, kc/two);
	        }
	        airport.incAirportKid();
	    }

	    public Central getCentral() {
	        return central;
	    }

	    public Airport getAirport() {
	        return airport;
	    }
}
