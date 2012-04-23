/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name="gestor_mensajeria")
public class GestorMensajeria {

	private Long idMensaje;
	
	private Set<UserAccount> paraUsuario;
	
	private UserAccount deUsuario;
	
	private String mensaje;
	
	private String asunto;
	
	private Date fechaEnvio;

	/**
	 * @return the idMensaje
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getIdMensaje() {
		return idMensaje;
	}

	/**
	 * @param idMensaje the idMensaje to set
	 */
	
	public void setIdMensaje(Long idMensaje) {
		this.idMensaje = idMensaje;
	}

	

	/**
	 * @return the paraUsuario
	 */
	@NotNull
	@ManyToMany(mappedBy="usuarioReceptor")
	public Set<UserAccount> getParaUsuario() {
		if(paraUsuario==null){
			return new HashSet<UserAccount>();
		}
		return paraUsuario;
	}

	/**
	 * @param paraUsuario the paraUsuario to set
	 */
	public void setParaUsuario(Set<UserAccount> paraUsuario) {
		this.paraUsuario = paraUsuario;
	}

	/**
	 * @return the deUsuario
	 */
	@NotNull
	@ManyToOne
	public UserAccount getDeUsuario() {
		return deUsuario;
	}

	/**
	 * @param deUsuario the deUsuario to set
	 */
	public void setDeUsuario(UserAccount deUsuario) {
		this.deUsuario = deUsuario;
	}

	/**
	 * @return the mensaje
	 */
	@Column(name= "mensaje")
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the asunto
	 */
	@Column(name= "asunto")
	public String getAsunto() {
		return asunto;
	}

	/**
	 * @param asunto the asunto to set
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	/**
	 * @return the fechaEnvio
	 */
	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	/**
	 * @param fechaEnvio the fechaEnvio to set
	 */
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	
	
	
}
