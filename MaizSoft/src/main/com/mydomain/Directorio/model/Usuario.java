/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Pattern;



/**
 *@author Josu� Nicol�s Pinz�n Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name ="usuarios")
public class Usuario{

	/**
	 * 
	 */

	
	private Long id;

	private Long documentoIdentidad;	
	
	private String primerNombre;
	
	private String segundoNombre;
	
	private String apellidos;
	
	private String correoElectronico;
	
	private String fotoUser;
	
	private Set<GrupoUsuarios> grupoUsuarios;
	
	
	private Set<GestorMensajeria> usuarioEmisor;
	
	private Set< ReceptorMensajes> mensajes;
	
	
	private Set<HistorialNotas> historialNotas;
	
	private Set<CuentasUsuario> cuentasUsuario;
	
	private EnteUniversitario enteUniversitarios;
	
	private String codigoUsuarios;
	
	private Tipo tipo;
	
	

	
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
	@Length(max=30)
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
	@NotNull
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
	 * @return the grupoUsuarios
	 */
	@OneToMany(mappedBy="userGrupoCurso",cascade=CascadeType.ALL)
	public Set<GrupoUsuarios> getGrupoUsuarios() {
		if(grupoUsuarios==null){
			return new HashSet<GrupoUsuarios>();
		}
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
	
	public String getFotoUser() {
		return fotoUser;
	}

	/**
	 * @param fotoUser the fotoUser to set
	 */
	public void setFotoUser(String fotoUser) {
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
	 * @return the codigoUsuarios
	 */
	@NotEmpty
	public String getCodigoUsuarios() {
		return codigoUsuarios;
	}

	/**
	 * @param codigoUsuarios the codigoUsuarios to set
	 */
	public void setCodigoUsuarios(String codigoUsuarios) {
		this.codigoUsuarios = codigoUsuarios;
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
		if(historialNotas==null){
			return new HashSet<HistorialNotas>();
		}
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
		if(mensajes==null){
			return new HashSet<ReceptorMensajes>();
		}
		return mensajes;
	}

	/**
	 * @param mensajes the mensajes to set
	 */
	public void setMensajes(Set<ReceptorMensajes> mensajes) {
		this.mensajes = mensajes;
	}

	/**
	 * @return the cuentasUsuario
	 */
	@OneToMany(mappedBy="usuarios",cascade=CascadeType.ALL)
	public Set<CuentasUsuario> getCuentasUsuario() {
		if(cuentasUsuario==null){
			return new HashSet<CuentasUsuario>();
		}
		
		return cuentasUsuario;
	}

	/**
	 * @param cuentasUsuario the cuentasUsuario to set
	 */
	public void setCuentasUsuario(Set<CuentasUsuario> cuentasUsuario) {
		this.cuentasUsuario = cuentasUsuario;
	}

	
}
