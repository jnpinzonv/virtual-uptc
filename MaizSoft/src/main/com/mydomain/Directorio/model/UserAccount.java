package com.mydomain.Directorio.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
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
	
	private TipoDocumento tipoDocumento;
	
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
	
			
	private GrupoCurso grupoCurso;
	
	private Set<GestorAgenda> eventosAgenda;
	
	private GestorAnuncios gestorAnuncios;
	
	
	private Set<GestorMensajeria> usuarioEmisor;
	
	private Set<GestorMensajeria> usuarioReceptor;
	
	private Set<GestorAudioConferencia> audioConferencias;
	
	private Set<GestorVideoConferencia> videoConferencias;
	
	
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the tipoDocumento
	 */
	@Enumerated(EnumType.STRING)
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the primerNombre
	 */
	@NotNull
	@Length(max=50)
	@Pattern(regex="^\\w*$", message="Nombre de la persona no valido")
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
	@Pattern(regex="^\\w*$", message="Nombre de la persona no valido")
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
	@Pattern(regex="^\\w*$", message="Apellidos no validos")
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
	@NotNull
	@Email
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
	 * @return the grupoCurso
	 */
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
	 * @return the eventosAgenda
	 */
	@OneToMany(mappedBy="userAccountAgenda")
	public Set<GestorAgenda> getEventosAgenda() {
		if(eventosAgenda==null){
			return new HashSet<GestorAgenda>();
		}
		return eventosAgenda;
	}

	/**
	 * @param eventosAgenda the eventosAgenda to set
	 */
	public void setEventosAgenda(Set<GestorAgenda> eventosAgenda) {
		this.eventosAgenda = eventosAgenda;
	}

	/**
	 * @return the gestorAnuncios
	 */
	@OneToOne(mappedBy="userAccountAnuncio")
	public GestorAnuncios getGestorAnuncios() {
		return gestorAnuncios;
	}

	/**
	 * @param gestorAnuncios the gestorAnuncios to set
	 */
	public void setGestorAnuncios(GestorAnuncios gestorAnuncios) {
		this.gestorAnuncios = gestorAnuncios;
	}

	/**
	 * @return the usuarioEmisor
	 */
	@OneToMany(mappedBy="deUsuario")
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
	 * @return the usuarioReceptor
	 */
	@ManyToMany
	public Set<GestorMensajeria> getUsuarioReceptor() {
		if(usuarioReceptor==null){
			return new HashSet<GestorMensajeria>();
		}
		return usuarioReceptor;
	}

	/**
	 * @param usuarioReceptor the usuarioReceptor to set
	 */
	public void setUsuarioReceptor(Set<GestorMensajeria> usuarioReceptor) {
		this.usuarioReceptor = usuarioReceptor;
	}

	/**
	 * @return the audioConferencias
	 */
	@OneToMany(mappedBy="usuarioCreador")
	public Set<GestorAudioConferencia> getAudioConferencias() {
		if(audioConferencias==null){
			return new HashSet<GestorAudioConferencia>();
		}
		return audioConferencias;
	}

	/**
	 * @param audioConferencias the audioConferencias to set
	 */
	public void setAudioConferencias(Set<GestorAudioConferencia> audioConferencias) {
		this.audioConferencias = audioConferencias;
	}

	/**
	 * @return the videoConferencias
	 */
	@OneToMany(mappedBy="usuarioCreador")
	public Set<GestorVideoConferencia> getVideoConferencias() {
		if(videoConferencias==null){
			return new HashSet<GestorVideoConferencia>();
		}
		return videoConferencias;
	}

	/**
	 * @param videoConferencias the videoConferencias to set
	 */
	public void setVideoConferencias(Set<GestorVideoConferencia> videoConferencias) {
		this.videoConferencias = videoConferencias;
	}
	
	
	
	
}
