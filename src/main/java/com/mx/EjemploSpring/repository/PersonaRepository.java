package com.mx.EjemploSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.EjemploSpring.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Integer>{

}
