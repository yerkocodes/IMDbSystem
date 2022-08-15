package com.imdbsystem.dao;

import org.springframework.data.repository.CrudRepository;

import com.imdbsystem.model.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {

}
