package com.mydomain.Directorio.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Pattern;
import org.jboss.seam.annotations.Name;

/**
 * Descripcion: Esta Clase se encarga de almacenar informaci�n de los usuarios
 * de la palataforma. Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 22/06/2012
 */
@Entity(name="Usuario")
@Table(name="usuario")
@Name("usuario")
@NamedQueries({
		@NamedQuery(name = "usuariosPorEscuela", query = "select s from Usuario s where s.enteUniversitarios.idEnteUniversitario=:parametro")})
public class Usuario {

	/**
	 * Variable que almacena el número de identificación del usuario.
	 */
	private Long id;

	/**
	 * Variable que se encarga de almacenar el número del documento de identidad
	 * del usuario.
	 */
	private Long documentoIdentidad;

	/**
	 * Variable que guarda el primer nombre del usuario.
	 */
	private String primerNombre;

	/**
	 * Variable que guarda el segundo nombre del usuario.
	 */
	private String segundoNombre;

	/**
	 * Variable que guarda los apellidos del usuario.
	 */
	private String apellidos;

	/**
	 * Variable que almacena la dirreci�n de correo electr�nico del usuario.
	 */
	private String correoElectronico;

	/**
	 * Variable que guarda la direcci�n de la fotograf�a del usuario.
	 */
	private String fotoUser;

	/**
	 * Variable encargada de almacenar el grupo de usuarios del curso.
	 */
	private Set<GrupoUsuarios> grupoUsuarios;

	/**
	 * Variable encargada de almacenar los datos del usuario emisor de un
	 * mensaje.
	 */
	private Set<GestorMensajeria> usuarioEmisor;

	/**
	 * Variable encargada de almacenar los datos del usuario receptor de un
	 * mensaje.
	 */
	private Set<ReceptorMensajes> mensajes;

	/**
	 * Variable encargada de almacenar el historial de notas del usuario del
	 * curso.
	 */
	private Set<HistorialNotas> historialNotas;

	/**
	 * Variable encargada de almacenar el conjunto de las cuentas de los
	 * usuarios.
	 */
	private Set<CuentasUsuario> cuentasUsuario;

	/**
	 * Variable que almacena la informaci�n conserniente a la universidad a la
	 * cual pertenece el curso y por lo tanto sus integrantes. Instancia de la
	 * clase EnteUniversitrio.
	 */
	private EnteUniversitario enteUniversitarios;

	/**
	 * Variable encargada de almacenar el c�digo de los usuarios, el cual puede
	 * tener letras y n�meros.
	 */
	private String codigoUsuarios;

	/**
	 * Variable que guarda la informaci�n del tipo de usuario que se encuentra
	 * inscirto en el curso.
	 */
	private Tipo tipo;
	
	
	private Set<NotaActividad> notaActividad;
	
	private Set<Actividad> actividad;
	
	private transient String role;

	/**
	 * Se obtiene el valor de id
	 * 
	 * @return El valor de id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getId() {
		return id;
	}

	/**
	 * Asigna el valor de id
	 * 
	 * @param id
	 *            El valor por establecer para id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Se obtiene el valor de tipo
	 * 
	 * @return El valor de tipo
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_tipo", unique = false, nullable = false, insertable = true, updatable = true)
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * Asigna el valor de tipo
	 * 
	 * @param tipo
	 *            El valor por establecer para tipo
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * Se obtiene el valor de primerNombre
	 * 
	 * @return El valor de primerNombre
	 */
	@NotNull
	@Length(max = 50)
	@Pattern(regex = "^\\w*$")
	@Column(name = "primer_nombre", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(30)")
	public String getPrimerNombre() {
		return primerNombre;
	}

	/**
	 * Asigna el valor de primerNombre
	 * 
	 * @param primerNombre
	 *            El valor por establecer para primerNombre
	 */
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	/**
	 * Se obtiene el valor de segundoNombre
	 * 
	 * @return El valor de segundoNombre
	 */
	@Length(max = 50)
	@Pattern(regex = "^\\w*$")
	@Column(name = "segundo_nombre", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "varchar(30)")
	public String getSegundoNombre() {
		return segundoNombre;
	}

	/**
	 * Asigna el valor de segundoNombre
	 * 
	 * @param segundoNombre
	 *            El valor por establecer para segundoNombre
	 */
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	/**
	 * Se obtiene el valor de apellidos
	 * 
	 * @return El valor de apellidos
	 */
	@NotNull
	@Length(max = 30)
	@Pattern(regex = "^\\w*$")
	@Column(name = "apellidos", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(30)")
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Asigna el valor de apellidos
	 * 
	 * @param apellidos
	 *            El valor por establecer para apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Se obtiene el valor de correoElectronico
	 * 
	 * @return El valor de correoElectronico
	 */
	@NotNull
	@Email
	@Length(max = 60)
	@Column(name = "correo_electronico", unique = true, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(60)")
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * Asigna el valor de correoElectronico
	 * 
	 * @param correoElectronico
	 *            El valor por establecer para correoElectronico
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * Se obtiene el valor de grupoUsuarios
	 * 
	 * @return El valor de grupoUsuarios
	 */
	@OneToMany(mappedBy = "userGrupoCurso", cascade = CascadeType.ALL)
	public Set<GrupoUsuarios> getGrupoUsuarios() {
		if (grupoUsuarios == null) {
			return new HashSet<GrupoUsuarios>();
		}
		return grupoUsuarios;
	}

	/**
	 * Asigna el valor de grupoUsuarios
	 * 
	 * @param grupoUsuarios
	 *            El valor por establecer para grupoUsuarios
	 */
	public void setGrupoUsuarios(Set<GrupoUsuarios> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

	/**
	 * Se obtiene el valor de fotoUser
	 * 
	 * @return El valor de fotoUser
	 */
	@Column(name = "foto_user", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "varchar(300)")
	public String getFotoUser() {
		return fotoUser;
	}

	/**
	 * Asigna el valor de fotoUser
	 * 
	 * @param fotoUser
	 *            El valor por establecer para fotoUser
	 */
	public void setFotoUser(String fotoUser) {
		this.fotoUser = fotoUser;
	}

	/**
	 * Se obtiene el valor de documentoIdentidad
	 * 
	 * @return El valor de documentoIdentidad
	 */
	@NotNull
	@Column(name = "documento_identidad", unique = true, nullable = false, insertable = true, updatable = true, columnDefinition = "numeric(15)")
	public Long getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	/**
	 * Asigna el valor de documentoIdentidad
	 * 
	 * @param documentoIdentidad
	 *            El valor por establecer para documentoIdentidad
	 */
	public void setDocumentoIdentidad(Long documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	/**
	 * Se obtiene el valor de codigoUsuarios
	 * 
	 * @return El valor de codigoUsuarios
	 */
	@NotEmpty
	@Column(name = "codigo_usuarios", unique = true, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(15)")
	public String getCodigoUsuarios() {
		return codigoUsuarios;
	}

	/**
	 * Asigna el valor de codigoUsuarios
	 * 
	 * @param codigoUsuarios
	 *            El valor por establecer para codigoUsuarios
	 */
	public void setCodigoUsuarios(String codigoUsuarios) {
		this.codigoUsuarios = codigoUsuarios;
	}

	/**
	 * Se obtiene el valor de usuarioEmisor
	 * 
	 * @return El valor de usuarioEmisor
	 */
	@OneToMany(mappedBy = "deUsuario", cascade = CascadeType.ALL)
	public Set<GestorMensajeria> getUsuarioEmisor() {
		if (usuarioEmisor == null) {
			return new HashSet<GestorMensajeria>();
		}
		return usuarioEmisor;
	}

	/**
	 * Asigna el valor de usuarioEmisor
	 * 
	 * @param usuarioEmisor
	 *            El valor por establecer para usuarioEmisor
	 */
	public void setUsuarioEmisor(Set<GestorMensajeria> usuarioEmisor) {
		this.usuarioEmisor = usuarioEmisor;
	}

	/**
	 * Se obtiene el valor de enteUniversitarios
	 * 
	 * @return El valor de enteUniversitarios
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_ente_universitario", unique = false, nullable = false, insertable = true, updatable = true)
	public EnteUniversitario getEnteUniversitarios() {
		return enteUniversitarios;
	}

	/**
	 * Asigna el valor de enteUniversitarios
	 * 
	 * @param enteUniversitarios
	 *            El valor por establecer para enteUniversitarios
	 */
	public void setEnteUniversitarios(EnteUniversitario enteUniversitarios) {
		this.enteUniversitarios = enteUniversitarios;
	}

	/**
	 * Se obtiene el valor de historialNotas
	 * 
	 * @return El valor de historialNotas
	 */
	@OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
	public Set<HistorialNotas> getHistorialNotas() {
		if (historialNotas == null) {
			return new HashSet<HistorialNotas>();
		}
		return historialNotas;
	}

	/**
	 * Asigna el valor de historialNotas
	 * 
	 * @param historialNotas
	 *            El valor por establecer para historialNotas
	 */
	public void setHistorialNotas(Set<HistorialNotas> historialNotas) {
		this.historialNotas = historialNotas;
	}

	/**
	 * Se obtiene el valor de mensajes
	 * 
	 * @return El valor de mensajes
	 */
	@OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
	public Set<ReceptorMensajes> getMensajes() {
		if (mensajes == null) {
			return new HashSet<ReceptorMensajes>();
		}
		return mensajes;
	}

	/**
	 * Asigna el valor de mensajes
	 * 
	 * @param mensajes
	 *            El valor por establecer para mensajes
	 */
	public void setMensajes(Set<ReceptorMensajes> mensajes) {
		this.mensajes = mensajes;
	}

	/**
	 * Se obtiene el valor de cuentasUsuario
	 * 
	 * @return El valor de cuentasUsuario
	 */
	@OneToMany(mappedBy="usuarios",cascade=CascadeType.ALL)
	public Set<CuentasUsuario> getCuentasUsuario() {		
		if(cuentasUsuario==null){
			return new HashSet<CuentasUsuario>();
	}
		return cuentasUsuario;
	}
	
	/**
	 * Asigna el valor de cuentasUsuario
	 * 
	 * @param cuentasUsuario
	 *            El valor por establecer para cuentasUsuario
	 */
	public void setCuentasUsuario(Set<CuentasUsuario> cuentasUsuario) {
		this.cuentasUsuario = cuentasUsuario;
	}

	/**
	 * Se obtiene el valor de notaActividad
	 * @return El valor de notaActividad
	 */
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	public Set<NotaActividad> getNotaActividad() {
		return notaActividad;
	}

	/**
	 * Asigna el valor de notaActividad
	 * @param notaActividad El valor por establecer para notaActividad
	 */
	public void setNotaActividad(Set<NotaActividad> notaActividad) {
		this.notaActividad = notaActividad;
	}

	/**
	 * Se obtiene el valor de actividad
	 * @return El valor de actividad
	 */
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	public Set<Actividad> getActividad() {
		return actividad;
	}

	/**
	 * Asigna el valor de actividad
	 * @param actividad El valor por establecer para actividad
	 */
	public void setActividad(Set<Actividad> actividad) {
		this.actividad = actividad;
	}
	
	/**
	 * Se obtiene el valor de role
	 * @return El valor de role
	 */
	@Transient
	public String getRole() {
		if(role==null){
			return role="estudiante";
		}
		return role;
	}
	
	/**
	 * Asigna el valor de role
	 * @param role El valor por establecer para role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
