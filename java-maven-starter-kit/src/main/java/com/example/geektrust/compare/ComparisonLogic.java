package com.example.geektrust.compare;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ComparisonLogic implements Comparator<String>{

	  private HashMap<String, Integer> hm;
	    public ComparisonLogic(HashMap<String, Integer> hm) {
	        this.hm = hm;
	    }

	    @Override
	    public int compare(String o1, String o2) {
	        int c1 = hm.get(o1);
	        int c2 = hm.get(o2);

	        if(c1 > c2)
	            return -1;
	        else if(c1 < c2)
	            return 1;
	        else {
	            return o1.compareTo(o2);
	        }
	    }
}
