package com.dao;

import java.util.List;

import com.entity.City;
import com.entity.Country;
import com.vo.CityCountryVO;

public interface CityCountryDAO {
	public void insertCityCountry(Country country, List<City> cities);

	public void updateCountry(Country country);

	public void updateCity(City city);

	public void deleteCountry(Integer countryId);

	public List<CityCountryVO> getCityCountry();
}
