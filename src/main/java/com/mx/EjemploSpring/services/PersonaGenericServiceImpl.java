package com.mx.EjemploSpring.services;

import com.mx.EjemploSpring.model.Persona;

public class PersonaGenericServiceImpl implements PersonaService{
	
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
}
