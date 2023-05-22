package com.dao;

import java.util.List;

import com.entity.City;
import com.entity.Country;
import com.provider.ProviderManager;
import com.vo.CityCountryVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class CityCountryDAOImpl implements CityCountryDAO {
	private EntityManagerFactory emf;
	private EntityManager em;

	@Override
	public void insertCityCountry(Country country, List<City> cities) {
		initRoutine();
		em.persist(country);
		for (City ci : cities) {
			ci.setCountry(country);
			em.persist(ci);
		}

		closingRoutine();

	}

	@Override
	public void updateCity(City city) {
		initRoutine();
		City c = em.find(City.class, city.getCityId());
		city.setCountry(c.getCountry());
		em.merge(city);
		closingRoutine();

	}

	@Override
	public void updateCountry(Country country) {
		initRoutine();
		em.merge(country);
		closingRoutine();

	}

	@Override
	public void deleteCountry(Integer countryId) {
		initRoutine();
		em.remove(em.find(Country.class, countryId));
		closingRoutine();

	}

	@Override
	public List<CityCountryVO> getCityCountry() {
		initRoutine();
		List<CityCountryVO> citiesCountries = em.createNamedQuery("Country.findAllCityCountry", CityCountryVO.class)
				.getResultList();
		closingRoutine();
		return citiesCountries;
	}

	private void closingRoutine() {
		try {
			ProviderManager.commitTransaction(em);
			System.out.println("Transazione Completata");
		} catch (RollbackException rbe) {
			rbe.printStackTrace();
			System.err.println("Transazione Fallita");
			ProviderManager.rollbackTransaction(em);
		}

		ProviderManager.closeTransaction(em);
		ProviderManager.closeEntityManagerFactory(emf);
	}

	private void initRoutine() {
		emf = ProviderManager.getEntityManagerFactory();
		em = ProviderManager.getEntityManager(emf);

		ProviderManager.beginTransaction(em);
	}

}
