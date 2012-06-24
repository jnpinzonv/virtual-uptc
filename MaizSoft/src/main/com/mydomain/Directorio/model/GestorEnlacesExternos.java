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
* en esta clase con lo referente al gestor de enlaces externos, se comunica con la base de datos
* Modulo de Desarrollo :CU- ...
* @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity
@Table(name= "gestor_enlaces_externos")
public class GestorEnlacesExternos {
	
	/**
	 * Variable que almacena el identificador de los enlaces
	 * Tipo de Dato Long
	 */
	private Long idEnlace;
	
	/**
	 * Variable que almacena la url del enlace
	 * Tipo de Dato String
	 */
	private String urlEnlace;
	
	/**
	 * Variable que almacena el nombre del enlace
	 * Tipo de Dato String
	 */
	private String nombreEnlace;
	
	/**
	 * Variable que almacena la descripción del enlace
	 * Tipo de Dato String
	 */
	private String descripcionEnlace;
	
	/**
	 * Variable que almacena el grupo del cujrso en el que se maneja el enlace
	 * Se instancia de la clase GrupoCurso
	 */
	private GrupoCurso grupoCurso;

	/**
	 * Se obtiene el valor de idEnlace
	 * @return El valor de idEnlace
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_enlace", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(20)")
	public Long getIdEnlace() {
		return idEnlace;
	}

	/**
	 * Asigna el valor de idEnlace
	 * @param idEnlace El valor por establecer para idEnlace
	 */
	public void setIdEnlace(Long idEnlace) {
		this.idEnlace = idEnlace;
	}

	/**
	 * Se obtiene el valor de urlEnlace
	 * @return El valor de urlEnlace
	 */
	@NotEmpty
	@Column(name = "url_enlace", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(50)")
	public String getUrlEnlace() {
		return urlEnlace;
	}

	/**
	 * Asigna el valor de urlEnlace
	 * @param urlEnlace El valor por establecer para urlEnlace
	 */
	public void setUrlEnlace(String urlEnlace) {
		this.urlEnlace = urlEnlace;
	}

	/**
	 * Se obtiene el valor de nombreEnlace
	 * @return El valor de nombreEnlace
	 */
	@NotEmpty
	@Length(max=100)
	@Column(name = "nombre_enlace", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(20)")
	public String getNombreEnlace() {
		return nombreEnlace;
	}

	/**
	 * Asigna el valor de nombreEnlace
	 * @param nombreEnlace El valor por establecer para nombreEnlace
	 */
	public void setNombreEnlace(String nombreEnlace) {
		this.nombreEnlace = nombreEnlace;
	}

	/**
	 * Se obtiene el valor de descripcionEnlace
	 * @return El valor de descripcionEnlace
	 */	
	@Length(max=300)
	@Column(name = "descripcion_enlace", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(100)")
	public String getDescripcionEnlace() {
		return descripcionEnlace;
	}

	/**
	 * Asigna el valor de descripcionEnlace
	 * @param descripcionEnlace El valor por establecer para descripcionEnlace
	 */
	public void setDescripcionEnlace(String descripcionEnlace) {
		this.descripcionEnlace = descripcionEnlace;
	}

	/**
	 * Se obtiene el valor de grupoCurso
	 * @return El valor de grupoCurso
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_grupo_curso", unique = false, nullable = false, insertable = true, updatable = true)
	public GrupoCurso getGrupoCurso() {
		return grupoCurso;
	}

	/**
	 * Asigna el valor de grupoCurso
	 * @param grupoCurso El valor por establecer para grupoCurso
	 */
	public void setGrupoCurso(GrupoCurso grupoCurso) {
		this.grupoCurso = grupoCurso;
	}	
	
}
