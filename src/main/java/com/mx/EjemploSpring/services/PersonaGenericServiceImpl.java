package com.mx.EjemploSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mx.EjemploSpring.model.Persona;
import com.mx.EjemploSpring.repository.PersonaRepository;

@Service
@Qualifier("generica") //le da un nombre al service
public class PersonaGenericServiceImpl implements PersonaService{
	//autowired sirve para pedirle a spring una instancia
	@Autowired PersonaRepository personaRepository;
	
	public Persona obtenerPersona() {
		//Se crea la persona
		Persona p = new Persona();
		//Se llenan los datos de persona
		p.setId(1);
		p.setEdad(30);
		p.setNombre("Serge");
		//Retornamos a la persona
		return p;
	}
	public void insertarPersona(Persona p){
		//Guardamos en la base de datos
		personaRepository.save(p);
	}
}
