package mx.cursospring.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.cursospring.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer>{
	//select * from persona where nombre = 'marco'
	public List<Persona> findByNombre(String nombre);
	
	//select * from persona where nombre = 'marco' AND edad >10
	public List<Persona> findByNombreAndEdadGreaterThan(String nombre, Integer edad);

	//select * from persona where fechaNacimiento > '1999/01/09'
	public List<Persona> findByFechaNacimientoAfter(Date fecha);
	
	
	public List<Persona> findByEdad(int edad);
	
}
