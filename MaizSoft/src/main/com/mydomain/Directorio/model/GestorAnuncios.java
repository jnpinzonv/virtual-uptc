/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
 @Entity
 @Table(name="gestor_anuncios")
public class GestorAnuncios {

	 private Long idGestorAnuncios;
	 
	 private String nombre;
	 
	 private String descripcion;

	 private Actividad actividad;
	/**
	 * @return the idGestorAnuncios
	 */
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdGestorAnuncios() {
		return idGestorAnuncios;
	}

	/**
	 * @param idGestorAnuncios the idGestorAnuncios to set
	 */
	public void setIdGestorAnuncios(Long idGestorAnuncios) {
		this.idGestorAnuncios = idGestorAnuncios;
	}

	/**
	 * @return the nombre
	 */
	@NotEmpty
	@Length(max=50)
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	@NotEmpty
	@Length(max=300)
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the actividad
	 */
	@ManyToOne
	@NotNull
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
