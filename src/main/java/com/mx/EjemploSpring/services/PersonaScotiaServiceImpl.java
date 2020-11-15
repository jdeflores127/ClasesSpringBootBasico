package com.mx.EjemploSpring.services;

import com.mx.EjemploSpring.model.Persona;

public class PersonaScotiaServiceImpl implements PersonaService{

	public Persona obtenerPersona() {
		Persona p = new Persona();
		p.setId(1);
		p.setNombre("Edgar");
		p.setEdad(32);
		
		Persona p2 = new Persona();
		p2.setId(2);
		p2.setNombre("Diego");
		p2.setEdad(8);
		
		if(p2.getEdad()>p.getEdad())
			return p2;
		else
			return p;
	}
	
}
