package mx.cursospring.wsConfig;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.cursospring.wsAutoGen.ConsultaPersonasImpl;

@Configuration
public class ConfigWS {
	@Autowired
	private Bus bus;
	
	@Autowired(required=true)
	private ConsultaPersonasImpl consultaPersonasImpl;
	
	@Bean
	public Endpoint endpoint() {
		//mandamos la clase de configuracion del ws y implementacion del ws
		Endpoint endpoint = new EndpointImpl(bus, consultaPersonasImpl);
		endpoint.publish("/obtenerPersona");
		return endpoint;
	}
}
