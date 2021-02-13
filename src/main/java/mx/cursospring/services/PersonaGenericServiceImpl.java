package mx.cursospring.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mx.cursospring.model.Persona;
import mx.cursospring.repository.PersonaRepository;

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
	public List<Persona> obtenerlistaPersonas(){
		List<Persona> personas= new ArrayList<Persona>();
		//select * from personaTable where edad > 5
		//Query methods
		//100 registros, 10 grupos 
		Page<Persona> page= personaRepository.findAll(PageRequest.of(0, 100,Sort.by("edad")));
		personas=page.getContent();
		//personas= personaRepository.findByNombre("marco");
		//personas= personaRepository.findByNombreAndEdadGreaterThan("marco", 100);	
		//Calendar cal= new GregorianCalendar();
		//cal.set(1999, 1, 12);
		
		//personas = personaRepository.findByFechaNacimientoAfter(cal.getTime());
		return personas;
	}
	
	
}
