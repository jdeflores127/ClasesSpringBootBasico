package mx.cursospring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.cursospring.model.Persona;
@Service
@Qualifier("scotia") //le da un nombre al service
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
	public void insertarPersona(Persona p){
		
	}
	@Override
	public List<Persona> obtenerlistaPersonas() {
		// TODO Auto-generated method stub
		return null;
	}
	
}