package mx.cursospring.services;

public class FactoryPersonaService {
	
	public PersonaService damePersona(String persona) {
		if(persona.equals("Generica")) {			
			return new PersonaGenericServiceImpl();
		}
		else if(persona.equals("Scotia")) {
			return new PersonaScotiaServiceImpl();
		}
		else {
			System.out.println("No se encuentra implementación");
			return null;
		}
	}

}
