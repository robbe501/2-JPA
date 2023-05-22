package com.main;

import com.dao.FilmActorDAO;
import com.dao.FilmActorDAOImpl;

public class Main {

	public static void main(String[] args) {

		FilmActorDAO filmActorDAO = new FilmActorDAOImpl();

//		Map<Film, List<Actor>> filmActor = new HashMap<>();
//		List<Actor> actors = new ArrayList<>();
//		List<Actor> actors2 = new ArrayList<>();
////
//		Film f1 = new Film("PULP FICTION", "Descrizione Pulp Fiction");
////
//		Film f2 = new Film("PULP FICTION2", "Descrizione Pulp Fiction");
////
//		Actor a1 = new Actor("BRUCE", "WILLIS");
////
//		Actor a2 = new Actor("TIM", "ROTH");
////
//		actors.add(a1);
//		actors.add(a2);
////
//		actors2.add(a1);
//		actors2.add(a2);
////
//		filmActor.put(f1, actors);
//		filmActor.put(f2, actors2);
//
//		filmActorDAO.insertFilmActor(filmActor);

//		filmActorDAO.updateActor(new Actor(285, "QUENTIN", "TARANTINO"));

//		filmActorDAO.updateFilm(new Film(1069, "QUENTIN", "DESC"));

//		filmActorDAO.deleteActor(285);

//		filmActorDAO.deleteFilm(1069);

		filmActorDAO.getFilmActor().forEach(System.out::println);

	}

}
