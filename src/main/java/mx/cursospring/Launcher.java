package mx.cursospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Launcher {

	public static void main(String[] args) {
		//Inicializa el servidor de aplicaciones
		SpringApplication.run(Launcher.class, args);
	}

}
