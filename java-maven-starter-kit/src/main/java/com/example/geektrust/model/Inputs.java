package com.example.geektrust.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inputs {

	private static Map<String, MetroCard> map=new HashMap<>();
	private static List<StationEntryDetails> lst=new ArrayList<>();
	
	public void setdetailsOfCard(String[] arguments) {
		String metroCardNo=arguments[1];
		map.put(metroCardNo, new MetroCard(arguments));
		
	}
	
	public MetroCard getdetailsOfCard(String metroCardNo) {
		MetroCard metroCardObject=map.get(metroCardNo);
		return metroCardObject;
	}
	
	public void setdetailsOFCheckIn(String[] arguments) {
		lst.add(new StationEntryDetails(arguments));
		
	}
	
	public ArrayList<StationEntryDetails> getdetailsOfCheckIn(){
		return (ArrayList<StationEntryDetails>) lst;
	}
}
