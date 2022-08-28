package com.imdbsystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imdbsystem.ImDbSystemApplication;
import com.imdbsystem.dao.UsersRepository;
import com.imdbsystem.model.Role;
import com.imdbsystem.model.Users;
import com.imdbsystem.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	private static final Logger log = LoggerFactory.getLogger(ImDbSystemApplication.class);
	
	@Autowired
	private UsersRepository dao;

	@Autowired
	private BCryptPasswordEncoder encoder;
	

	@Override
	@Transactional(readOnly = true)
	public List<Users> findAllUsers() {
		List<Users> usersList = new ArrayList<>();
		try {
			usersList = (List<Users>) dao.findAll();
		} catch (Exception e) {
			log.error("UsersServiceImpl: Ocurred an error in findAllUsers method");
		}
		return usersList;
	}

	@Override
	@Transactional
	public Users add(Users user) {
		Users response = new Users();
		try {
			if (user.getPassword().equals(user.getPasswordConfirmation())) {
				user.setRole(Role.USER);
				user.setPassword(encoder.encode(user.getPassword()));
				user.setPasswordConfirmation(encoder.encode(user.getPasswordConfirmation()));
				response = dao.save(user);
			}
		} catch (Exception e) {
			log.error("UsersServiceImpl: Ocurred an error in add method");
		}
		return response;
	}

	@Override
	@Transactional
	public Users update(Users user) {
		try {
			Users userUpdated = dao.save(user);
			return userUpdated;
		} catch (Exception e) {
			log.error("UsersServiceImpl: Ocurred an error in update method");
		}
		return new Users();
	}

	@Override
	@Transactional
	public Boolean delete(Users user) {
		try {
			dao.delete(user);
			return true;
		} catch (Exception e) {
			log.error("UsersServiceImpl: Ocurred an error in delete method");
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Users findById(Long id) {
		try {
			Optional<Users> userToFind = dao.findById(id);
			return userToFind.get();
		} catch (Exception e) {
			log.error("UsersServiceImpl: Ocurred an error in findById method");
		}
		return new Users();
	}

	@Override
	@Transactional(readOnly = true)
	public Users findByEmail(String email) {
		try {
			return dao.findByEmail(email);
		} catch (Exception e) {
			log.error("UsersServiceImpl: Ocurred an error in findByEmail method");
		}
		return new Users();
	}

}
