package com.imdbsystem.service;

import java.util.List;

import com.imdbsystem.model.Users;

public interface UsersService {

	public List<Users> findAllUsers();
	public Users add(Users user);
	public Users update(Users user);
	public Boolean delete(Users user);
	public Users findById(Integer id);

}
