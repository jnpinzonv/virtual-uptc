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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Pattern;
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

	private Long documentoIdentidad;
	
	
	
	private String primerNombre;
	
	private String segundoNombre;
	
	private String apellidos;
	
	private String correoElectronico;
	
	
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
	
	private byte[] fotoUser;

	/**
	 * Lista de roles que desemplenia el usuario dentro de la plataforma
	 */
	private Set<UserRole> roles;
	
			
	private Set<GrupoUsuarios> grupoUsuarios;
	
	
	private Set<GestorMensajeria> usuarioEmisor;
	
	private Set< ReceptorMensajes> mensajes;
	
	
	private Set<HistorialNotas> historialNotas;
	
	private EnteUniversitario enteUniversitarios;
	
	private Tipo tipo;
	
	/**
	 * @return the tipo
	 */
	@NotNull
	@ManyToOne
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
	/**
	 * @return the primerNombre
	 */
	@NotNull
	@Length(max=50)
	@Pattern(regex="^\\w*$")
	public String getPrimerNombre() {
		return primerNombre;
	}

	/**
	 * @param primerNombre the primerNombre to set
	 */
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	/**
	 * @return the segundoNombre
	 */

	@Length(max=50)
	@Pattern(regex="^\\w*$")
	public String getSegundoNombre() {
		return segundoNombre;
	}

	/**
	 * @param segundoNombre the segundoNombre to set
	 */
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	/**
	 * @return the apellidos
	 */
	@NotNull
	@Length(max=15)
	@Pattern(regex="^\\w*$")
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the correoElectronico
	 */
	@NotEmpty
	@Email
	@Length(max=60)
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
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
	 * @return the grupoUsuarios
	 */
	@OneToMany(mappedBy="userGrupoCurso",cascade=CascadeType.ALL)
	public Set<GrupoUsuarios> getGrupoUsuarios() {
		return grupoUsuarios;
	}

	/**
	 * @param grupoUsuarios the grupoUsuarios to set
	 */
	public void setGrupoUsuarios(Set<GrupoUsuarios> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

	/**
	 * @return the fotoUser
	 */
	@Lob
	public byte[] getFotoUser() {
		return fotoUser;
	}

	/**
	 * @param fotoUser the fotoUser to set
	 */
	public void setFotoUser(byte[] fotoUser) {
		this.fotoUser = fotoUser;
	}

	/**
	 * @param documentoIdentidad the documentoIdentidad to set
	 */
	
	public void setDocumentoIdentidad(Long documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	/**
	 * @return the documentoIdentidad
	 */
	@NotNull
	public Long getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	
	
	/**
	 * @return the usuarioEmisor
	 */
	@OneToMany(mappedBy="deUsuario",cascade=CascadeType.ALL)
	public Set<GestorMensajeria> getUsuarioEmisor() {
		if(usuarioEmisor==null){
			return new HashSet<GestorMensajeria>();
		}
		return usuarioEmisor;
	}

	/**
	 * @param usuarioEmisor the usuarioEmisor to set
	 */
	public void setUsuarioEmisor(Set<GestorMensajeria> usuarioEmisor) {
		this.usuarioEmisor = usuarioEmisor;
	}

	
	

	/**
	 * @return the enteUniversitarios
	 */
	@NotNull
	@ManyToOne
	public EnteUniversitario getEnteUniversitarios() {
		return enteUniversitarios;
	}

	/**
	 * @param enteUniversitarios the enteUniversitarios to set
	 */
	public void setEnteUniversitarios(EnteUniversitario enteUniversitarios) {
		this.enteUniversitarios = enteUniversitarios;
	}

	/**
	 * @return the historialNotas
	 */
	@OneToMany(mappedBy="userAccount",cascade=CascadeType.ALL)
	public Set<HistorialNotas> getHistorialNotas() {
		return historialNotas;
	}

	/**
	 * @param historialNotas the historialNotas to set
	 */
	public void setHistorialNotas(Set<HistorialNotas> historialNotas) {
		this.historialNotas = historialNotas;
	}

	/**
	 * @return the mensajes
	 */
	@OneToMany(mappedBy="userAccount",cascade=CascadeType.ALL)
	public Set<ReceptorMensajes> getMensajes() {
		return mensajes;
	}

	/**
	 * @param mensajes the mensajes to set
	 */
	public void setMensajes(Set<ReceptorMensajes> mensajes) {
		this.mensajes = mensajes;
	}
	
	
		
}
