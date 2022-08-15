package com.imdbsystem.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Show {

	@Id// indica cual atributo es el id columna en la base de datos
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_USUARIO") //ORACLE
	@GeneratedValue(strategy=GenerationType.IDENTITY) //MYSQL
	private Long id;

	private String showTitle;
	private String showNetwork;
}
