/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *
 */
@Entity
@Table(name= "gestor_enlaces_externos")
public class GestorEnlacesExternos {
	
	private Long idEnlace;
	
	private String urlEnlace;
	
	private String nombreEnlace;
	
	private String descripcionEnlace;
	
	private GrupoCurso grupoCurso;	

	
	
	/**
	 * @return the idEnlace
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getIdEnlace() {
		return idEnlace;
	}

	/**
	 * @param idEnlace the idEnlace to set
	 */
	public void setIdEnlace(Long idEnlace) {
		this.idEnlace = idEnlace;
	}

	/**
	 * @return the urlEnlace
	 */
	@NotNull
	@Column(name= "url_enlace")
	public String getUrlEnlace() {
		return urlEnlace;
	}

	/**
	 * @param urlEnlace the urlEnlace to set
	 */
	public void setUrlEnlace(String urlEnlace) {
		this.urlEnlace = urlEnlace;
	}

	/**
	 * @return the nombreEnlace
	 */
	@Column(name= "nombre_enlace")
	public String getNombreEnlace() {
		return nombreEnlace;
	}

	/**
	 * @param nombreEnlace the nombreEnlace to set
	 */
	public void setNombreEnlace(String nombreEnlace) {
		this.nombreEnlace = nombreEnlace;
	}

	/**
	 * @return the descripcionEnlace
	 */
	@Column(name= "descripcion_enlace")
	public String getDescripcionEnlace() {
		return descripcionEnlace;
	}

	/**
	 * @param descripcionEnlace the descripcionEnlace to set
	 */
	public void setDescripcionEnlace(String descripcionEnlace) {
		this.descripcionEnlace = descripcionEnlace;
	}

	
	/**
	 * @return the grupoCurso
	 */
	@NotNull
	@ManyToOne
	public GrupoCurso getGrupoCurso() {
		return grupoCurso;
	}

	/**
	 * @param grupoCurso the grupoCurso to set
	 */
	public void setGrupoCurso(GrupoCurso grupoCurso) {
		this.grupoCurso = grupoCurso;
	}

	
	
	
	
}
