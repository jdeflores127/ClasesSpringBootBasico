package mx.cursospring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.cursospring.model.Persona;
import mx.cursospring.services.FactoryPersonaService;
import mx.cursospring.services.PersonaGenericServiceImpl;
import mx.cursospring.services.PersonaScotiaServiceImpl;
import mx.cursospring.services.PersonaService;

@Controller
public class HomeController {
	
	@Autowired @Qualifier("generica") PersonaService ps;
	
	@GetMapping("/home")
	public String goHome() {
		int variableEjemplo =12;
		System.out.println("hola mundo: " + variableEjemplo);
		
		//Se define que html o que vista se va a mostrar
		//Retorna la vista home.html
		return "home";
	}
	
	@GetMapping("/mostrarPersona")
	public String goMostrarPersona(Model model) {
		//Obtener un objeto de java
		FactoryPersonaService ps = new FactoryPersonaService(); 
		PersonaService p = ps.damePersona("Generica");
		Persona persona = p.obtenerPersona();
		//La clase Model sirve para mandar objetos a la vista
		model.addAttribute("personaModel",persona);
		return "home";
	}
	
	@GetMapping("/verPersona")
	public String goVerPersona(Model model) throws InterruptedException {
		Persona p = new Persona();
		p.setId(1);
		p.setEdad(18);
		p.setNombre("Edgar");
		model.addAttribute("personaModel",p);
		//Thread.sleep(4000);
		return "mostrarPersona";
	}
	
	@GetMapping("/llenarFormulario")
	public String goFormulario() {
		
		return "formulario";
	}
	
	@GetMapping("/enviarPersonas")
	public String goEnviarPesonas(Model model) {
		//Se crea el arreglo para las personas
		ArrayList<Persona> personas = new ArrayList<Persona>();
		//Se crea la variable de persona para llenar los datos
		Persona p = new Persona();
		//Se asignan los datos de la persona
		p.setId(1);
		p.setEdad(18);
		p.setNombre("Edgar");
		//Se agrega la persona al arreglo
		personas.add(p);
		
		p.setId(2);
		p.setEdad(22);
		p.setNombre("Alan");
		personas.add(p);
		
		p.setId(3);
		p.setEdad(32);
		p.setNombre("Victoria");
		personas.add(p);
		
		model.addAttribute("personaModel",personas);
		return "mostrarPersona";
	}
	
	@PostMapping("/guardaFormulario")
	public String procesarRespuestaFormulario(
			@RequestParam("nombreForm") String nombre,
			@RequestParam("edadForm") int edad,
			@RequestParam("fechaForm") Date fecha){
		
		Persona p=new Persona();
		p.setNombre(nombre);
		p.setEdad(edad);
		p.setFechaNacimiento(fecha);
		
		System.out.println("el nombre es: "+nombre);
		System.out.println("la edad es: "+edad);
		
		ps.insertarPersona(p);
		
		
		return "formulario";
	}
	@GetMapping("/mostrarLista")
	public String mostrarLista(Model model){
		List<Persona> personas_list=ps.obtenerlistaPersonas();
		model.addAttribute("lista_personas", personas_list);
		return "mostrarLista";
	}
	

}
