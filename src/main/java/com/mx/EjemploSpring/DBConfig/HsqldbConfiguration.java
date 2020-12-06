package com.mx.EjemploSpring.DBConfig;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//le decimos a hibernate donde buscar las entidades
@EnableJpaRepositories(
		entityManagerFactoryRef="PersonaEntityManagerFactory",
		transactionManagerRef="userTransactionManagerFactory",
		basePackages = {"com.mx.EjemploSpring.repository"})

public class HsqldbConfiguration {
	@Value("${hsql.datasource.url}") private String url;
	@Value("${hsql.datasource.driverClassName}") private String driverClassName;
	@Value("${hsql.datasoruce.username}") private String user;
	@Value("${hsql.datasource.password}") private String password;
	
	@Value("${hsql.jpa.showsql}") private String mostrarSql;
	@Value("${hsql.jpa.hibernate.ddlAuto}") private String crearBD;
	@Value("${hsql.jpa.hibernate.dialect}") private String dialecto;
	
	@Bean(name="personaDataSource")
	public DataSource userDataSource(){
		//Configurar conexion a base de datos
		DriverManagerDataSource datasource= new DriverManagerDataSource();
		datasource.setUrl(url);
		datasource.setDriverClassName(driverClassName);
		datasource.setUsername(user);
		datasource.setPassword(password);
		return datasource;
	}
	@Bean(name="PersonaEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean personaEntityManagerFactory(){
		/*
		 * 1.- indicamos el objeto dasource
		 * 2.- donde se encuentran las entidades
		 * 3.- indicar que se usará hibernate como proveedor de persistencia
		 * 4.- mapear las propiedades de hibernate
		 * */
		
		//paso 1
		LocalContainerEntityManagerFactoryBean emf= new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(userDataSource());
		
		//paso 2
		emf.setPackagesToScan("com.mx.EjemploSpring.model");
		
		//paso 3
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		
		//paso 4
		Map<String, Object> properties=new HashMap();
		properties.put("hibernate.show_sql",mostrarSql);
		properties.put("hibernate.hbm2ddl.auto",crearBD);
		properties.put("hibernate.dialect", dialecto);
		
		emf.setJpaPropertyMap(properties);
		return emf;
		
	}
	
	//Se configura la transaccionalidad 
	@Bean(name="userTransactionManagerFactory")
	public PlatformTransactionManager transactionManager(){
		JpaTransactionManager jtm= new JpaTransactionManager();
		jtm.setEntityManagerFactory(personaEntityManagerFactory().getObject());
		return jtm;
	}
	
	
	
}
