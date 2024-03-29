package com.mydomain.Directorio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jboss.seam.annotations.Name;

/**
 * Descripcion: Esta Clase se encarga de indicar y almacenar informaci�n
 * relacionada con los usuarios de los grupos. Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 22/06/2012
 */
@Entity(name = "GrupoUsuarios")
@Table(name = "grupo_usuarios")
@Name("grupoUsuarios")
@NamedQuery(name = "usuarioPorGrupo", query = "select t from GrupoUsuarios t where t.grupoCurso.idGrupo=:parametro")
public class GrupoUsuarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variable que almacena la identificación del grupo de usuarios del curso.
	 */
	private Long idGrupoUsuarios;

	/**
	 * Variable encargada de almacenar los datos de los usuarios del curso.
	 * Instancia de la clase Usuario.
	 */
	private Usuario userGrupoCurso;

	/**
	 * Variable encargada de hacer referencia a la información del grupo.
	 * Instancia de la clase GrupoCurso.
	 */
	private GrupoCurso grupoCurso;

	/**
	 * Variable que almacena la lista de las notas de las actividades obtenidas
	 * por los usuarios del grupo.
	 */
	private Set<NotaActividad> notaActividades;

	private transient String role;

	/**
	 * Variable que hace referencia a la informaci�n de la cuenta del usuario.
	 * Instancia de la clase CuentasUsuario.
	 */
	private CuentasUsuario userRole;

	private transient EnteUniversitario enteUniversitarioPadre;

	private transient EnteUniversitario enteUniversitarioHijo;

	private transient List<Usuario> usuarios;

	private transient Curso curso;

	/**
	 * Se obtiene el valor de userGrupoCurso
	 * 
	 * @return El valor de userGrupoCurso
	 */
	@ManyToOne
	@JoinColumn(name = "id_usuario", unique = false, nullable = true, insertable = true, updatable = true)
	public Usuario getUserGrupoCurso() {
		return userGrupoCurso;
	}

	/**
	 * Se obtiene el valor de idGrupoUsuarios
	 * 
	 * @return El valor de idGrupoUsuarios
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_grupo_usuarios", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getIdGrupoUsuarios() {
		return idGrupoUsuarios;
	}

	/**
	 * Asigna el valor de idGrupoUsuarios
	 * 
	 * @param idGrupoUsuarios
	 *            El valor por establecer para idGrupoUsuarios
	 */
	public void setIdGrupoUsuarios(Long idGrupoUsuarios) {
		this.idGrupoUsuarios = idGrupoUsuarios;
	}

	/**
	 * Se obtiene el valor de grupoCurso
	 * 
	 * @return El valor de grupoCurso
	 */
	@ManyToOne
	@JoinColumn(name = "id_grupo_curso", unique = false, nullable = false, insertable = true, updatable = true)
	public GrupoCurso getGrupoCurso() {
		return grupoCurso;
	}

	/**
	 * Asigna el valor de grupoCurso
	 * 
	 * @param grupoCurso
	 *            El valor por establecer para grupoCurso
	 */
	public void setGrupoCurso(GrupoCurso grupoCurso) {
		this.grupoCurso = grupoCurso;
	}

	/**
	 * Asigna el valor de userGrupoCurso
	 * 
	 * @param userGrupoCurso
	 *            El valor por establecer para userGrupoCurso
	 */
	public void setUserGrupoCurso(Usuario userGrupoCurso) {
		this.userGrupoCurso = userGrupoCurso;
	}

	/**
	 * Se obtiene el valor de notaActividades
	 * 
	 * @return El valor de notaActividades
	 */
	@OneToMany(mappedBy = "grupoCurso", cascade = CascadeType.ALL)
	public Set<NotaActividad> getNotaActividades() {
		if (notaActividades == null) {
			return new HashSet<NotaActividad>();
		}
		return notaActividades;
	}

	/**
	 * Asigna el valor de notaActividades
	 * 
	 * @param notaActividades
	 *            El valor por establecer para notaActividades
	 */
	public void setNotaActividades(Set<NotaActividad> notaActividades) {
		this.notaActividades = notaActividades;
	}

	/**
	 * Se obtiene el valor de userRole
	 * 
	 * @return El valor de userRole
	 */

	@ManyToOne
	@JoinColumn(name = "id_cuenta_usuario", unique = false, nullable = false, insertable = true, updatable = true)
	public CuentasUsuario getUserRole() {
		return userRole;
	}

	/**
	 * Asigna el valor de userRole
	 * 
	 * @param userRole
	 *            El valor por establecer para userRole
	 */
	public void setUserRole(CuentasUsuario userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the enteUniversitarioPadre
	 */
	@Transient
	public EnteUniversitario getEnteUniversitarioPadre() {

		return enteUniversitarioPadre;
	}

	/**
	 * @param enteUniversitarioPadre
	 *            the enteUniversitarioPadre to set
	 */
	public void setEnteUniversitarioPadre(
			EnteUniversitario enteUniversitarioPadre) {
		this.enteUniversitarioPadre = enteUniversitarioPadre;
	}

	/**
	 * @return the enteUniversitarioHijo
	 */

	@Transient
	public EnteUniversitario getEnteUniversitarioHijo() {
		return enteUniversitarioHijo;
	}

	/**
	 * @param enteUniversitarioHijo
	 *            the enteUniversitarioHijo to set
	 */
	public void setEnteUniversitarioHijo(EnteUniversitario enteUniversitarioHijo) {
		this.enteUniversitarioHijo = enteUniversitarioHijo;
	}

	/**
	 * @return the usuarios
	 */
	@Transient
	public List<Usuario> getUsuarios() {
		
		if (usuarios == null)
			return new ArrayList<Usuario>();
		return usuarios;
	}

	/**
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the curso
	 */
	@Transient
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso
	 *            the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * Se obtiene el valor de role
	 * 
	 * @return El valor de role
	 */
	@Transient
	public String getRole() {
		if (role == null) {
			return role = "estudiante";
		}
		System.out.println("hhhh"+role);
		
		
		return role;
	}

	/**
	 * Asigna el valor de role
	 * 
	 * @param role
	 *            El valor por establecer para role
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
