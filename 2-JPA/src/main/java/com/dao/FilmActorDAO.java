package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Actor;
import com.entity.Film;
import com.vo.FilmActorVO;

public interface FilmActorDAO {
	public void insertFilmActor(Map<Film, List<Actor>> filmActor);

	public void updateFilm(Film film);

	public void updateActor(Actor actor);

	public void deleteFilm(Integer filmId);

	public void deleteActor(Integer actorId);

	public List<FilmActorVO> getFilmActor();
}
