package mx.cursospring.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.cursospring.model.Historico;
import mx.cursospring.model.Persona;
import mx.cursospring.repository.HistoricoRepository;
import mx.cursospring.repository.PersonaRepository;
@Service
@Qualifier("scotia") //le da un nombre al service
@Profile("scotia")
public class PersonaScotiaServiceImpl implements PersonaService{

	@Autowired HistoricoRepository historicoRepository;
	@Autowired PersonaRepository personaRepository;
	
	@Transactional(readOnly = true)
	public Persona obtenerPersona() {
		Persona p = new Persona();
		Optional<Persona> personaBD = personaRepository.findById(11);
		if(personaBD.isPresent())
			return personaBD.get();
		else 
			return p;
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED,
			timeout = 1000,
			//noRollbackFor = {RuntimeException.class},
			propagation = Propagation.REQUIRES_NEW)
	@Lock(LockModeType.OPTIMISTIC)
	public void insertarPersona(Persona p){
		
		
		Persona personaBD=personaRepository.findById(11).get();
		personaBD.setNombre(p.getNombre());
		personaBD.setFechaNacimiento(p.getFechaNacimiento());
		personaBD.setEdad(personaBD.getEdad()+p.getEdad());
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			System.out.println("error de interrupxion");
			e.printStackTrace();
		}
		//definiciones de datos
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		
		//Se inserta en base de datos
		//Persona personaInsertada=personaRepository.saveAndFlush(personaBD);
		//System.out.println("Persona insertada: "+personaInsertada.toString());
		
		Historico historico= new Historico();
		historico.setFechaMovimiento(calendar.getTime());
		historico.setIdPersona(personaBD.getId());
		historico.setTipoMovimiento("insercion");
		//Se inserta en el historico
		historico=historicoRepository.save(historico);
	
		//if(historico.getTipoMovimiento().equals("insercion"))
		//	throw new RuntimeException("ya me morí we");
	}
	@Override
	@Transactional(readOnly = true)
	public List<Persona> obtenerlistaPersonas() {
		List<Persona> personas=new ArrayList<Persona>();
		personas.add(personaRepository.findById(11).get());
		return personas;
	}
	
}
