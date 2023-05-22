package com.vo;

public class CityCountryVO {
	private String country;
	private String city;

	public CityCountryVO(String country, String city) {
		this.country = country;
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "CityCountryVO [country=" + country + ", city=" + city + "]";
	}

}
