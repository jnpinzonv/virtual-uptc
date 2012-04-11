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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name="gestor_anuncios")
public class GestorAnuncios {
	
	private Long idAnuncio;
	
	private String nombreAnuncio;
	
	private String descripcionAnuncio;
	
	private UserAccount userAccountAnuncio;
	
	private GrupoCurso grupoCursoAnuncio;

	/**
	 * @return the idAnuncio
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getIdAnuncio() {
		return idAnuncio;
	}

	/**
	 * @param idAnuncio the idAnuncio to set
	 */
	public void setIdAnuncio(Long idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

	/**
	 * @return the nombreAnuncio
	 */
	@Column(name= "nombre_anuncio")
	public String getNombreAnuncio() {
		return nombreAnuncio;
	}

	/**
	 * @param nombreAnuncio the nombreAnuncio to set
	 */
	public void setNombreAnuncio(String nombreAnuncio) {
		this.nombreAnuncio = nombreAnuncio;
	}

	/**
	 * @return the descripcionAnuncio
	 */
	@Column(name= "descripcion_anuncio")
	public String getDescripcionAnuncio() {
		return descripcionAnuncio;
	}

	/**
	 * @param descripcionAnuncio the descripcionAnuncio to set
	 */
	public void setDescripcionAnuncio(String descripcionAnuncio) {
		this.descripcionAnuncio = descripcionAnuncio;
	}

	/**
	 * @return the userAccountAnuncio
	 */
	@OneToOne
	public UserAccount getUserAccountAnuncio() {
		return userAccountAnuncio;
	}

	/**
	 * @param userAccountAnuncio the userAccountAnuncio to set
	 */
	public void setUserAccountAnuncio(UserAccount userAccountAnuncio) {
		this.userAccountAnuncio = userAccountAnuncio;
	}

	/**
	 * @return the grupoCursoAnuncio
	 */
	@ManyToOne
	public GrupoCurso getGrupoCursoAnuncio() {
		return grupoCursoAnuncio;
	}

	/**
	 * @param grupoCursoAnuncio the grupoCursoAnuncio to set
	 */
	public void setGrupoCursoAnuncio(GrupoCurso grupoCursoAnuncio) {
		this.grupoCursoAnuncio = grupoCursoAnuncio;
	}

	
	
}
