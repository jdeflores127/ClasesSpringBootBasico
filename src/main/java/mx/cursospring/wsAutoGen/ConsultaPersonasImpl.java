package mx.cursospring.wsAutoGen;

import java.util.List;
import java.util.Optional;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.cursospring.model.Persona;
import mx.cursospring.repository.PersonaRepository;

@WebService(serviceName="consultaPersona", 
			endpointInterface = "mx.cursospring.wsAutoGen.ConsultaPersona")
@Component
public class ConsultaPersonasImpl implements ConsultaPersona{
	
	@Autowired PersonaRepository personaRepository;
	 
	public String holaMundo() {
		return "por fin ya le corrio al pinche edwin ya vamonos a mimir alv";
	}

	@Override
	public Persona obtenerPersona(int idPersona) throws PersonaNoEncontradaException {
		Optional<Persona> personaObtenida=personaRepository.findById(idPersona);
		if(personaObtenida.isPresent())
			return personaObtenida.get();
		else {
			throw new PersonaNoEncontradaException("Persona no encontrada");
		}
	}

	@Override
	public String insertarPersona(Persona persona) {
		persona.setId(0);
		Persona p=personaRepository.save(persona);
		return "instancia guardada en bd";
	}

	@Override
	public Persona obtenerPersonaPorEdad(int edad) throws PersonaNoEncontradaException{
		List<Persona> p=personaRepository.findByEdad(edad);
		if(p.size()==0)
			throw new PersonaNoEncontradaException("persona por edad no encontrada");
		return p.get(0);
	}
}
