package com.example.geektrust.model;

public class Airport {
	    private int balance;
	    private int discount;
	    private int countAdult;
	    private int countSeniorCitizen;
	    private int countKid;
	    

	    public Airport(int balance, int discount, int countAdult, int countSeniorCitizen, int countKid) {
			super();
			this.balance = balance;
			this.discount = discount;
			this.countAdult = countAdult;
			this.countSeniorCitizen = countSeniorCitizen;
			this.countKid = countKid;
		}

		public Airport() {
			// TODO Auto-generated constructor stub
		}

		public int getbalance() {
	        return balance;
	    }

	    public int getDiscount() {
	        return discount;
	    }

	    public int getAdultCount() {
	        return countAdult;
	    }

	    public int getSeniorCitizenCount() {
	        return countSeniorCitizen;
	    }

	    public int getKidCount() {
	        return countKid;
	    }

	    public void setbalance(int balance) {
	        this.balance += balance;
	    }

	    public void setDiscount(int discount) {
	        this.discount += discount;
	    }

	    public void incAirportAdult() {
	        this.countAdult++;
	    }

	    public void incAirportSenior() {
	        this.countSeniorCitizen++;
	    }

	    public void incAirportKid() {
	        this.countKid++;
	    }

}
