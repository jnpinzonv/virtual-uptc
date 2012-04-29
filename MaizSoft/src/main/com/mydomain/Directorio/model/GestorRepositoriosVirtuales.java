/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.Set;

import javax.persistence.Column;
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
 * @author Nicolas
 *
 */
@Entity
@Table(name= "gestor_repositorio")
public class GestorRepositoriosVirtuales {
	
	
	private Long idRepositorio;
	
	private String urlRepositorio;
	
	private String nombreRepositorio;
	
	private String descripcionRepositorio;
	
	private String usernameRepositorio;
	
	private String passwordRepositorio;
	
	
	private Tipo tipos;
	
	/**
	 * @return the tipos
	 */
	@NotNull
	@ManyToOne
	public Tipo getTipos() {
		return tipos;
	}

	/**
	 * @param tipos the tipos to set
	 */
	public void setTipos(Tipo tipos) {
		this.tipos = tipos;
	}
	
	

	
	/**
	 * @return the idRepositorio
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getIdRepositorio() {
		return idRepositorio;
	}

	/**
	 * @param idRepositorio the idRepositorio to set
	 */
	public void setIdRepositorio(Long idRepositorio) {
		this.idRepositorio = idRepositorio;
	}

	/**
	 * @return the urlRepositorio
	 */
	@NotEmpty
	@Column(name= "url_repositorio")	
	public String getUrlRepositorio() {
		return urlRepositorio;
	}

	/**
	 * @param urlRepositorio the urlRepositorio to set
	 */
	public void setUrlRepositorio(String urlRepositorio) {
		this.urlRepositorio = urlRepositorio;
	}

	/**
	 * @return the nombreRepositorio
	 */
	@Column(name= "nombre_repositorio")
	@NotEmpty
	@Length(max=100)
	public String getNombreRepositorio() {
		return nombreRepositorio;
	}

	/**
	 * @param nombreRepositorio the nombreRepositorio to set
	 */
	public void setNombreRepositorio(String nombreRepositorio) {
		this.nombreRepositorio = nombreRepositorio;
	}

	/**
	 * @return the descripcionRepositorio
	 */
	@Column(name= "descripcion_repositorio")
	@Length(max=100)
	public String getDescripcionRepositorio() {
		return descripcionRepositorio;
	}

	/**
	 * @param descripcionRepositorio the descripcionRepositorio to set
	 */
	public void setDescripcionRepositorio(String descripcionRepositorio) {
		this.descripcionRepositorio = descripcionRepositorio;
	}

	/**
	 * @return the usernameRepositorio
	 */
	@Column(name= "username_repositorio")
	@Length(max=30)
	public String getUsernameRepositorio() {
		return usernameRepositorio;
	}

	/**
	 * @param usernameRepositorio the usernameRepositorio to set
	 */
	public void setUsernameRepositorio(String usernameRepositorio) {
		this.usernameRepositorio = usernameRepositorio;
	}

	/**
	 * @return the passwordRepositorio
	 */
	@Column(name= "password_repositorio")
	@Length(max=30)
	public String getPasswordRepositorio() {
		return passwordRepositorio;
	}

	/**
	 * @param passwordRepositorio the passwordRepositorio to set
	 */
	public void setPasswordRepositorio(String passwordRepositorio) {
		this.passwordRepositorio = passwordRepositorio;
	}

	
	
	
	
	
	

}
