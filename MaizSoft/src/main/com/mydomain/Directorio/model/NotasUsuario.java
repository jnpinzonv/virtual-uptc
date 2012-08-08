/**
 * 
 */
package com.mydomain.Directorio.model;

import org.jboss.cache.util.setCache;

/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 07/08/2012 
 */
public class NotasUsuario {
	
	private String nombreAsignatura;
	
	private double nota;
	
	
	/**
	 * Se obtiene el valor de nombreAsignatura
	 * @return El valor de nombreAsignatura
	 */
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}
	
	/**
	 * Se obtiene el valor de nota
	 * @return El valor de nota
	 */
	public double getNota() {
		return nota;
	}
	
	
	/**
	 * Asigna el valor de nombreAsignatura
	 * @param nombreAsignatura El valor por establecer para nombreAsignatura
	 */
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}
	
	
	/**
	 * Asigna el valor de nota
	 * @param nota El valor por establecer para nota
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}	
	
	
}
