package com.example.geektrust.model;

public class Central {

	    private int balance;
	    private int discount;
	    private int countAdult;
	    private int countSeniorCitizen;
	    private int countKid;

	    public Central() {
			// TODO Auto-generated constructor stub
		}
	   
	    
	    public Central(int balance, int discount, int countAdult, int countSeniorCitizen, int countKid) {
			super();
			this.balance = balance;
			this.discount = discount;
			this.countAdult = countAdult;
			this.countSeniorCitizen = countSeniorCitizen;
			this.countKid = countKid;
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

	    public void incAdult() {
	        this.countAdult++;
	    }

	    public void incSeniorCitizen() {
	        this.countSeniorCitizen++;
	    }

	    public void incKid() {
	        this.countKid++;
	    }
	
}
