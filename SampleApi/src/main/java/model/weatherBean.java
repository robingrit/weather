package model;

import java.util.ArrayList;

public class weatherBean {
	
	 
	private String cityStr;
	private String countryStr;
	private String cloudsStr;
	private double temprature;
	private String  date;
	
	private ArrayList<String> ar = new ArrayList<String>();
	
	
	
	
	

	public weatherBean(String cityStr, String countryStr) {
		this.cityStr = cityStr;
		this.countryStr = countryStr;
		
	}
	 
	 
	 
	public String getCountryStr() {
		return countryStr;
	}
	public void setCountryStr(String countryStr) {
		this.countryStr = countryStr;
	}
	public String getCloudsStr() {
		return cloudsStr;
	}
	public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}
	public String getCityStr() {
		return cityStr;
	}
	
	
	public double getTemprature() {
		return temprature;
	}


	public void setTemprature(double temprature) {
				this.temprature =temprature;
		
	}



	public ArrayList<String> getAr() {
		return ar;
	}



	public void setAr( ArrayList<String> ar) {
		this.ar = ar;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}






	



	

	 
	 
}
