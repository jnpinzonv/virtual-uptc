package com.mydomain.Directorio.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.NotNull;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.security.management.UserEnabled;
import org.jboss.seam.annotations.security.management.UserPassword;
import org.jboss.seam.annotations.security.management.UserPrincipal;
import org.jboss.seam.annotations.security.management.UserRoles;


/**
 * @author Josue Nicolas Pinzon Villamil Fecha: 13/03/2012 Correo:
 *         jnpinzonv@hotmail.com Clase empleada para describir el usuario de la
 *         plataforma
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"), name = "user_account")
@Scope(ScopeType.SESSION)
public class UserAccount implements Serializable {

	/**
	 * Representa la version de serealizacion de la clase
	 */
	private static final long serialVersionUID = 6368734442192368866L;

	/**
	 * Id del usuario
	 */
	private Long id;

	/**
	 * Nombre de usuario de identificacion de la plataforma
	 */
	private String username;
	/**
	 * Contrasenia de usuario para logueo de la plataforma
	 */
	private String passwordHash;
	/**
	 * Representa el estado de la cuenta activa/inactiva
	 */
	private boolean enabled;

	/**
	 * Lista de roles que desemplenia el usuario dentro de la plataforma
	 */
	private Set<UserRole> roles;

	
	private Set<CuentasUsuario> cuentasUsuarios;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna el nombre del usuario
	 * 
	 * @return usuername
	 */

	@NotNull
	@UserPrincipal
	public String getUsername() {
		return username;
	}

	/**
	 * Impone el nombre de usuario
	 * 
	 * @param username
	 *            =! null
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Retorna el Password del Usuario
	 * 
	 * @return
	 */
	@UserPassword(hash = "SHA")
	@Column(name = "password_hash")
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * Impone el password de usuario
	 * 
	 * @param passwordHash
	 *            =! null
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * Estado de la cuenta del usario
	 * 
	 * @return enable
	 */
	@UserEnabled
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Impone el parametro de estado
	 * 
	 * @param enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Lista de roles del usuario
	 * 
	 * @return roles
	 */
	@UserRoles
	@ManyToMany
	@JoinTable(name = "user_account_role", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "member_of_role"))
	public Set<UserRole> getRoles() {
		return roles;
	}

	/**
	 * Lista de roles
	 * 
	 * @param roles
	 *            != null
	 */
	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	/**
	 * @return the cuentasUsuarios
	 */
	@OneToMany(mappedBy="userAccounts",cascade=CascadeType.ALL)
	public Set<CuentasUsuario> getCuentasUsuarios() {
		if(cuentasUsuarios==null){
			return new HashSet<CuentasUsuario>();
		}
		
		return cuentasUsuarios;
	}

	/**
	 * @param cuentasUsuarios the cuentasUsuarios to set
	 */
	public void setCuentasUsuarios(Set<CuentasUsuario> cuentasUsuarios) {
		this.cuentasUsuarios = cuentasUsuarios;
	}

	/**
	 * @return the cuentasUsuario
	 */



	

}
