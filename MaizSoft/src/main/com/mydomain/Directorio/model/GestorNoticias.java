/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.validator.NotEmpty;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name="gestor_noticias")
public class GestorNoticias {
	
	private Long idNoticia;
	
	private String nombreNoticia;
	
	private String descripcion;

	/**
	 * @return the idNoticia
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getIdNoticia() {
		return idNoticia;
	}

	/**
	 * @param idNoticia the idNoticia to set
	 */
	public void setIdNoticia(Long idNoticia) {
		this.idNoticia = idNoticia;
	}

	/**
	 * @return the nombreNoticia
	 */
	@NotEmpty
	public String getNombreNoticia() {
		return nombreNoticia;
	}

	/**
	 * @param nombreNoticia the nombreNoticia to set
	 */
	public void setNombreNoticia(String nombreNoticia) {
		this.nombreNoticia = nombreNoticia;
	}

	/**
	 * @return the descripcion
	 */
	@Lob
	@NotEmpty
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
