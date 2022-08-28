package com.imdbsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.imdbsystem.model.Users;
import com.imdbsystem.serviceImpl.UsersServiceImpl;

@Service
public class AuthServiceImpl implements UserDetailsService {

	// inyeccion de dependencias para la interfaz UsuarioMapper y dispoponibilizar
	// cuando se requiera
	@Autowired
	private UsersServiceImpl usersServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Users user = usersServiceImpl.findByEmail(email);

		if (user == null) {// si el usuario es null
			throw new UsernameNotFoundException(email);// se ejecuta una excepcion
		}

		// almacenar todos GrantedAuthority del usuario
		List<GrantedAuthority> authorities = new ArrayList<>();

		// agregando el rol convertido en SimpleGrantedAuthority
		authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

		// se retorna un nuevo usuario con email, passwotd y las autoridades creadas
		// org.springframework.security.core.userdetails.User.User(String username,
		// String password, Collection<? extends GrantedAuthority> authorities)
		
		return new User(user.getEmail(), user.getPassword(), authorities);

	}

}
