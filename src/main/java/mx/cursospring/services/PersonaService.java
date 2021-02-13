package mx.cursospring.services;

import java.util.List;

import mx.cursospring.model.Persona;

public interface PersonaService {
	public Persona obtenerPersona();
	public void insertarPersona(Persona p);
	public List<Persona> obtenerlistaPersonas();
}
