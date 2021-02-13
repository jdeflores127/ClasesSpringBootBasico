package mx.cursospring.wsAutoGen;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import mx.cursospring.model.Persona;

@WebService
public interface ConsultaPersona {
	@WebMethod
	public String holaMundo();
	@WebMethod
	public Persona obtenerPersona(@WebParam(name="idPersona")int idPersona) throws PersonaNoEncontradaException;
	@WebMethod
	public String insertarPersona(@WebParam(name="persona")Persona persona);
	@WebMethod
	public Persona obtenerPersonaPorEdad(@WebParam(name="edad") int edad) throws PersonaNoEncontradaException;
}
