package com.imdbsystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imdbsystem.ImDbSystemApplication;
import com.imdbsystem.dao.RatingRepository;
import com.imdbsystem.model.Rating;
import com.imdbsystem.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	private static final Logger log = LoggerFactory.getLogger(ImDbSystemApplication.class);
	
	@Autowired
	private RatingRepository dao;

	@Override
	@Transactional(readOnly = true)
	public List<Rating> findAllRating() {
		List<Rating> ratingList = new ArrayList<>();
		try {
			ratingList = (List<Rating>) dao.findAll();
		} catch (Exception e) {
			log.error("RatingServiceImpl: Ocurred an error in findAllRating method");
		}
		return ratingList;
	}

	@Override
	@Transactional
	public Rating add(Rating rating) {
		try {
			return dao.save(rating);
		} catch (Exception e) {
			log.error("RatingServiceImpl: Ocurred an error in add method");
		}
		return new Rating();
	}

	@Override
	@Transactional
	public Rating update(Rating rating) {
		try {
			return dao.save(rating);
		} catch (Exception e) {
			log.error("RatingServiceImpl: Ocurred an error in update method");
		}
		return new Rating();
	}

	@Override
	@Transactional
	public Boolean delete(Rating rating) {
		try {
			dao.delete(rating);
			return true;
		} catch (Exception e) {
			log.error("RatingServiceImpl: Ocurred an error in delete method");
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Rating findById(Long id) {
		try {
			Optional<Rating> ratingToFind = dao.findById(id);
			return ratingToFind.get();
		} catch (Exception e) {
			log.error("UsersServiceImpl: Ocurred an error in findById method");
		}
		return new Rating();
	}

}
