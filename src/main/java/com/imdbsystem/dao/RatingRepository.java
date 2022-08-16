package com.imdbsystem.dao;

import org.springframework.data.repository.CrudRepository;

import com.imdbsystem.model.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {

}
