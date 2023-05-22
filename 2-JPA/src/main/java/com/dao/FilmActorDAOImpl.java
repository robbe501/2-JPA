package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Actor;
import com.entity.Film;
import com.entity.FilmActor;
import com.provider.ProviderManager;
import com.vo.FilmActorVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.RollbackException;

public class FilmActorDAOImpl implements FilmActorDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	@Override
	public void insertFilmActor(Map<Film, List<Actor>> filmActor) {
		initRoutine();

		for (Film f : filmActor.keySet()) {
			filmActor.get(f).forEach(a -> f.addFilmActor(new FilmActor(f, a)));
			em.persist(f);
		}

		closingRoutine();

	}

	@Override
	public void updateFilm(Film film) {
		initRoutine();

		em.merge(film);

		closingRoutine();

	}

	@Override
	public void updateActor(Actor actor) {
		initRoutine();

		em.merge(actor);

		closingRoutine();

	}

	@Override
	public void deleteFilm(Integer filmId) {
		initRoutine();

		em.remove(em.find(Film.class, filmId));

		closingRoutine();

	}

	@Override
	public void deleteActor(Integer actorId) {
		initRoutine();

		em.remove(em.find(Actor.class, actorId));

		closingRoutine();

	}

	@Override
	public List<FilmActorVO> getFilmActor() {
		initRoutine();
		List<FilmActorVO> filmsActors = em.createNamedQuery("Film.findAllFilmActor", FilmActorVO.class).getResultList();
		closingRoutine();
		return filmsActors;
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
