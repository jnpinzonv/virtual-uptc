/**
 * 
 */
package com.mydomain.Directorio.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;



/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name="cuentas_usuario")
public class CuentasUsuario {
	
	private Long id;
	
	private UserAccount userAccounts;
	
	private Usuario usuarios;
	
	private GrupoUsuarios grupoUsuarios;


	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userAccounts
	 */
	@NotNull
	@ManyToOne
	public UserAccount getUserAccounts() {
		return userAccounts;
	}

	/**
	 * @param userAccounts the userAccounts to set
	 */
	public void setUserAccounts(UserAccount userAccounts) {
		this.userAccounts = userAccounts;
	}

	/**
	 * @return the usuarios
	 */
	@NotNull
	@ManyToOne
	public Usuario getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}
	

	/**
	 * @return the grupoUsuarios
	 */
	@OneToOne
	public GrupoUsuarios getGrupoUsuarios() {
		return grupoUsuarios;
	}

	/**
	 * @param grupoUsuarios the grupoUsuarios to set
	 */
	public void setGrupoUsuarios(GrupoUsuarios grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

	
	

}
