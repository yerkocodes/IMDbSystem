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
import com.imdbsystem.dao.ShowRespository;
import com.imdbsystem.model.Show;
import com.imdbsystem.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {

	private static final Logger log = LoggerFactory.getLogger(ImDbSystemApplication.class);
	
	@Autowired
	private ShowRespository dao;

	@Override
	@Transactional(readOnly = true)
	public List<Show> findAllShow() {
		List<Show> showList = new ArrayList<>();
		try {
			showList = (List<Show>) dao.findAll();
		} catch (Exception e) {
			log.error("RatingServiceImpl: Ocurred an error in findAllRating method");
		}
		return showList;
	}

	@Override
	@Transactional
	public Show add(Show show) {
		try {
			return dao.save(show);
		} catch (Exception e) {
			log.error("RatingServiceImpl: Ocurred an error in add method");
		}
		return new Show();
	}

	@Override
	@Transactional
	public Show update(Show show) {
		try {
			return dao.save(show);
		} catch (Exception e) {
			log.error("RatingServiceImpl: Ocurred an error in update method");
		}
		return new Show();
	}

	@Override
	@Transactional
	public Boolean delete(Show show) {
		try {
			dao.delete(show);
			return true;
		} catch (Exception e) {
			log.error("RatingServiceImpl: Ocurred an error in delete method");
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Show findById(Long id) {
		try {
			Optional<Show> showToFind = dao.findById(id);
			return showToFind.get();
		} catch (Exception e) {
			log.error("UsersServiceImpl: Ocurred an error in findById method");
		}
		return new Show();
	}

}
