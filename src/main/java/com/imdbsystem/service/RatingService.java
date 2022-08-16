package com.imdbsystem.service;

import java.util.List;

import com.imdbsystem.model.Rating;

public interface RatingService {

	public List<Rating> findAllRating();
	public Rating add(Rating rating);
	public Rating update(Rating rating);
	public Boolean delete(Rating rating);
	public Rating findById(Long id);

}
