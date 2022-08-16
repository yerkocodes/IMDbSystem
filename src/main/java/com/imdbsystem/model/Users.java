package com.imdbsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
//@SequenceGenerator(name = "SQ_USUARIO", initialValue = 1, allocationSize = 1,sequenceName = "SQ_USUARIO" //ORACLE
public class Users {

	@Id// indica cual atributo es el id columna en la base de datos
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_USUARIO") //ORACLE
	@GeneratedValue(strategy=GenerationType.IDENTITY) //MYSQL
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String passwordConfirmation;
	
	@Column(nullable = false)
	private Role role;
}
