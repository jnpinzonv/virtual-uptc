/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *
 */
@Entity
@Table(name="gestor_biblioteca")
public class GestorBibliotecas {

	private Long idBiblioteca;
	
	private String urlBiblioteca;
	
	private String nombreBiblioteca;
	
	private String descripcionBiblioteca;
	
	private String usernameBiblioteca;
	
	private String passwordBiblioteca;
	
	
	
	
	

	
	
	/**
	 * @return the idBiblioteca
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getIdBiblioteca() {
		return idBiblioteca;
	}

	/**
	 * @param idBiblioteca the idBiblioteca to set
	 */
	public void setIdBiblioteca(Long idBiblioteca) {
		this.idBiblioteca = idBiblioteca;
	}

	/**
	 * @return the urlBiblioteca
	 */
	@NotNull
	@Column(name= "url_repositorio")
	public String getUrlBiblioteca() {
		return urlBiblioteca;
	}

	/**
	 * @param urlBiblioteca the urlBiblioteca to set
	 */
	public void setUrlBiblioteca(String urlBiblioteca) {
		this.urlBiblioteca = urlBiblioteca;
	}

	/**
	 * @return the nombreBiblioteca
	 */
	@Column(name= "nombre_biblioteca")
	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}

	/**
	 * @param nombreBiblioteca the nombreBiblioteca to set
	 */
	public void setNombreBiblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
	}

	/**
	 * @return the descripcionBiblioteca
	 */
	@Column(name= "descripcion_biblioteca")
	public String getDescripcionBiblioteca() {
		return descripcionBiblioteca;
	}

	/**
	 * @param descripcionBiblioteca the descripcionBiblioteca to set
	 */
	public void setDescripcionBiblioteca(String descripcionBiblioteca) {
		this.descripcionBiblioteca = descripcionBiblioteca;
	}

	/**
	 * @return the usernameBiblioteca
	 */
	@Column(name= "username_biblioteca")
	public String getUsernameBiblioteca() {
		return usernameBiblioteca;
	}

	/**
	 * @param usernameBiblioteca the usernameBiblioteca to set
	 */
	public void setUsernameBiblioteca(String usernameBiblioteca) {
		this.usernameBiblioteca = usernameBiblioteca;
	}

	/**
	 * @return the passwordBiblioteca
	 */
	@Column(name= "password_biblioteca")
	public String getPasswordBiblioteca() {
		return passwordBiblioteca;
	}

	/**
	 * @param passwordBiblioteca the passwordBiblioteca to set
	 */
	public void setPasswordBiblioteca(String passwordBiblioteca) {
		this.passwordBiblioteca = passwordBiblioteca;
	}

	
	

	
	
}
