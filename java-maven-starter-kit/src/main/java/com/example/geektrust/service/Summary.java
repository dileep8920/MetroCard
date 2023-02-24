package com.example.geektrust.service;

import java.util.HashMap;
import java.util.TreeMap;

import com.example.geektrust.compare.ComparisonLogic;
import com.example.geektrust.model.Airport;
import com.example.geektrust.model.Central;

public class Summary {

	 private final String adult = "ADULT";
	    private final String seniorCitizen = "SENIOR_CITIZEN";
	    private final String kid = "KID";
	    private TotalExpense ctc = new TotalExpense();
	    private Central central = ctc.getCentral();
	    private Airport airport = ctc.getAirport();
	    private HashMap<String, Integer> hm1 = new HashMap<>();
	    private HashMap<String, Integer> hm2 = new HashMap<>();

	    public void centralSummaryPrint() {
	        int countAdult = central.getAdultCount();
	        int countSeniorCitizen = central.getSeniorCitizenCount();
	        int countKid = central.getKidCount();

	        if(countAdult != 0)
	            hm1.put(adult, countAdult);
	        if(countSeniorCitizen != 0)
	            hm1.put(seniorCitizen, countSeniorCitizen);
	        if(countKid != 0)
	            hm1.put(kid, countKid);

	        System.out.println("TOTAL_COLLECTION CENTRAL " + central.getbalance() + " " + central.getDiscount());
	        System.out.println("PASSENGER_TYPE_SUMMARY");

	        ComparisonLogic logic = new ComparisonLogic(hm1);
	        TreeMap<String, Integer> map = new TreeMap<>(logic);
	        map.putAll(hm1);

	        for(String type: map.keySet()) {
	            int count = map.get(type);
	            System.out.println(type + " " + count);
	        }
	    }

	    public void airportSummaryPrint() {
	        int countAdult = airport.getAdultCount();
	        int countSeniorCitizen = airport.getSeniorCitizenCount();
	        int countKid = airport.getKidCount();

	        if(countAdult != 0)
	            hm2.put(adult, countAdult);
	        if(countSeniorCitizen != 0)
	            hm2.put(seniorCitizen, countSeniorCitizen);
	        if(countKid != 0)
	            hm2.put(kid, countKid);

	        System.out.println("TOTAL_COLLECTION AIRPORT " + airport.getbalance() + " " + airport.getDiscount());
	        System.out.println("PASSENGER_TYPE_SUMMARY");

	        ComparisonLogic logic = new ComparisonLogic(hm2);
	        TreeMap<String, Integer> map = new TreeMap<>(logic);
	        map.putAll(hm2);

	        for(String type: map.keySet()) {
	            int count = map.get(type);
	            System.out.println(type + " " + count);
	        }
	    }
}
