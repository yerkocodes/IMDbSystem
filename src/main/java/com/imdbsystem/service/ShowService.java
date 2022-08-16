package com.imdbsystem.service;

import java.util.List;

import com.imdbsystem.model.Show;

public interface ShowService {

	public List<Show> findAllShow();

	public Show add(Show show);

	public Show update(Show show);

	public Boolean delete(Show show);

	public Show findById(Long id);

}
