/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
public class SeccionActividades {
	
	private Long idSeccionActividades;
	
	private String nombreSeccion;
	
	private Actividad actividad;

	/**
	 * @return the idSeccionActividades
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdSeccionActividades() {
		return idSeccionActividades;
	}

	/**
	 * @param idSeccionActividades the idSeccionActividades to set
	 */
	public void setIdSeccionActividades(Long idSeccionActividades) {
		this.idSeccionActividades = idSeccionActividades;
	}

	/**
	 * @return the nombreSeccion
	 */
	@NotEmpty
	@Length(max=100)
	public String getNombreSeccion() {
		return nombreSeccion;
	}

	/**
	 * @param nombreSeccion the nombreSeccion to set
	 */
	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}

	/**
	 * @return the actividad
	 */
	
	public Actividad getActividad() {
		return actividad;
	}

	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	
	
	

}
