package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NamedQuery(name = "Film.findAllFilmActor", query = "SELECT new com.vo.FilmActorVO(a.firstName, a.lastName, f.title) FROM Film f JOIN f.filmActors fa JOIN fa.actor a ")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private Integer filmId;

	@Lob
	private String description;

	@Column(name = "language_id")
	private Integer languageId;

	@UpdateTimestamp
	@Column(name = "last_update")
	private Timestamp lastUpdate;

	private Integer length;

	@Column(name = "original_language_id")
	private Integer originalLanguageId;

	private String rating;

	@Column(name = "release_year")
	private Integer releaseYear;

	@Column(name = "rental_duration")
	private Integer rentalDuration;

	@Column(name = "rental_rate")
	private Double rentalRate;

	@Column(name = "replacement_cost")
	private Double replacementCost;

	@Column(name = "special_features")
	private Object specialFeatures;

	private String title;

	// bi-directional many-to-one association to FilmActor
	@OneToMany(mappedBy = "film", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<FilmActor> filmActors;

	public Film() {
	}

	public Film(String title, String description) {
		this.title = title;
		this.description = description;
		this.languageId = 1;
		this.length = 190;
		this.originalLanguageId = 1;
		this.rating = "R";
		this.releaseYear = 1980;
		this.rentalDuration = 3;
		this.rentalRate = 2.99;
		this.replacementCost = 10.99;
		this.specialFeatures = "Trailers";
		this.filmActors = new ArrayList<>();

	}

	public Film(Integer filmId, String title, String description) {
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.languageId = 1;
		this.length = 190;
		this.originalLanguageId = 1;
		this.rating = "R";
		this.releaseYear = 1980;
		this.rentalDuration = 3;
		this.rentalRate = 2.99;
		this.replacementCost = 10.99;
		this.specialFeatures = "Trailers";

	}

	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Integer getOriginalLanguageId() {
		return this.originalLanguageId;
	}

	public void setOriginalLanguageId(Integer originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Integer getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getRentalDuration() {
		return this.rentalDuration;
	}

	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public Double getRentalRate() {
		return this.rentalRate;
	}

	public void setRentalRate(Double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Double getReplacementCost() {
		return this.replacementCost;
	}

	public void setReplacementCost(Double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Object getSpecialFeatures() {
		return this.specialFeatures;
	}

	public void setSpecialFeatures(Object specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(List<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}

	public FilmActor addFilmActor(FilmActor filmActor) {
		getFilmActors().add(filmActor);
		filmActor.setFilm(this);

		return filmActor;
	}

	public FilmActor removeFilmActor(FilmActor filmActor) {
		getFilmActors().remove(filmActor);
		filmActor.setFilm(null);

		return filmActor;
	}

}