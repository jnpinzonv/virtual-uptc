/**
 * 
 */
package com.mydomain.Directorio.model;

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
@Table(name="receptor_mensajes")
public class ReceptorMensajes {
	
	private Long idReceptormenajes;
	private Usuario userAccount;
	private GestorMensajeria gestorMensajeria;
	
	/**
	 * @return the idReceptormenajes
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdReceptormenajes() {
		return idReceptormenajes;
	}
	/**
	 * @param idReceptormenajes the idReceptormenajes to set
	 */
	public void setIdReceptormenajes(Long idReceptormenajes) {
		this.idReceptormenajes = idReceptormenajes;
	}
	/**
	 * @return the userAccount
	 */
	@NotNull
	@ManyToOne
	public Usuario getUserAccount() {
		return userAccount;
	}
	/**
	 * @param userAccount the userAccount to set
	 */
	public void setUserAccount(Usuario userAccount) {
		this.userAccount = userAccount;
	}
	/**
	 * @return the gestorMensajeria
	 */
	@NotNull
	@ManyToOne
	public GestorMensajeria getGestorMensajeria() {
		return gestorMensajeria;
	}
	/**
	 * @param gestorMensajeria the gestorMensajeria to set
	 */
	public void setGestorMensajeria(GestorMensajeria gestorMensajeria) {
		this.gestorMensajeria = gestorMensajeria;
	}
	
	

}
