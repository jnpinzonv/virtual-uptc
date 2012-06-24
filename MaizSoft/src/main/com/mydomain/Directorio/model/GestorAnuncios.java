/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;


 /**
* Descripcion: Esta Clase se encarga de gestionar el almacenamiento de datos, 
* en esta clase con lo referente al gestor de anuncios, se comunica con la base de datos
* Modulo de Desarrollo :CU- ...
* @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity
@Table(name="gestor_anuncios")
public class GestorAnuncios {
	
	 /**
	 * Variable que almacena el identificador del gestor de anuncios
	 * Tipo de dato Long
	 */
	 private Long idGestorAnuncios;
	 
	 /**
	  * Variable que almacena el nombre del anuncio
	  * Tipo de dato String
	  */
	 private String nombre;
	 
	 /**
	  * Variable que almacena la descripción del anuncio
	  * Tipo de dato String
	  */
	 private String descripcion;

	 /**
	  * Variable que almacena la actividad a la cual se le hace el anuncio
	  * Se instancia de la clase Actividad
	  */
	 private Actividad actividad;

	/**
	 * Se obtiene el valor de idGestorAnuncios
	 * @return El valor de idGestorAnuncios
	 */
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "id_gestor_de_anuncios", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(20)")
	public Long getIdGestorAnuncios() {
		return idGestorAnuncios;
	}

	/**
	 * Asigna el valor de idGestorAnuncios
	 * @param idGestorAnuncios El valor por establecer para idGestorAnuncios
	 */
	public void setIdGestorAnuncios(Long idGestorAnuncios) {
		this.idGestorAnuncios = idGestorAnuncios;
	}

	/**
	 * Se obtiene el valor de nombre
	 * @return El valor de nombre
	 */
	@NotEmpty
	@Length(max=50)
	@Column(name = "nombre_anuncio", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(50)")
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna el valor de nombre
	 * @param nombre El valor por establecer para nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Se obtiene el valor de descripcion
	 * @return El valor de descripcion
	 */
	@NotEmpty
	@Length(max=300)
	@Column(name = "descripción_anuncio", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(300)")
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Asigna el valor de descripcion
	 * @param descripcion El valor por establecer para descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Se obtiene el valor de actividad
	 * @return El valor de actividad
	 */
	@ManyToOne
	@NotNull
	@JoinColumn(name = "actividad", unique = false, nullable = false, insertable = true, updatable = true)
	public Actividad getActividad() {
		return actividad;
	}

	/**
	 * Asigna el valor de actividad
	 * @param actividad El valor por establecer para actividad
	 */
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	 
}
