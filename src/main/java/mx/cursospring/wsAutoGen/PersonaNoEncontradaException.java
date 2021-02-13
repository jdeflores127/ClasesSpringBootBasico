package mx.cursospring.wsAutoGen;

import javax.xml.ws.WebFault;
import javax.xml.ws.soap.SOAPFaultException;

public class PersonaNoEncontradaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PersonaNoEncontradaException(String excepcion){
		super(excepcion);
		
	}

}
