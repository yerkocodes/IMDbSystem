package com.imdbsystem.dao;

import org.springframework.data.repository.CrudRepository;

import com.imdbsystem.model.Show;

public interface ShowRespository extends CrudRepository<Show, Long> {

}
