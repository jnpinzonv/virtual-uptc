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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.NotNull;

import java.util.List;


/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version 16/06/2012
 */
@Entity
@Table(name ="grupo_usuarios")
public class GrupoUsuarios {

	private Long idGrupoUsuarios;
	
	private Usuario userGrupoCurso;
	
	private GrupoCurso grupoCurso;

	private Set<NotaActividad> notaActividades;
	
	private CuentasUsuario userRole;
	
	private transient EnteUniversitario enteUniversitarioPadre;
	
	private transient EnteUniversitario enteUniversitarioHijo;
	
	private  transient List <Curso> cursos;

	/**
	 * @return the userGrupoCurso
	 */

	@ManyToOne
	public Usuario getUserGrupoCurso() {
		return userGrupoCurso;
	}

	/**
	 * @return the idGrupoUsuarios
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdGrupoUsuarios() {
		return idGrupoUsuarios;
	}

	/**
	 * @param idGrupoUsuarios the idGrupoUsuarios to set
	 */
	public void setIdGrupoUsuarios(Long idGrupoUsuarios) {
		this.idGrupoUsuarios = idGrupoUsuarios;
	}

	/**
	 * @param userGrupoCurso the userGrupoCurso to set
	 */
	public void setUserGrupoCurso(Usuario userGrupoCurso) {
		this.userGrupoCurso = userGrupoCurso;
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
	 * @return the notaActividades
	 */
	@OneToMany(mappedBy="grupoCurso",cascade=CascadeType.ALL)
	public Set<NotaActividad> getNotaActividades() {
		if(notaActividades==null){
			return new HashSet<NotaActividad>();
		}
		return notaActividades;
	}

	/**
	 * @param notaActividades the notaActividades to set
	 */
	public void setNotaActividades(Set<NotaActividad> notaActividades) {
		this.notaActividades = notaActividades;
	}

	/**
	 * @return the userRole
	 */
	@NotNull
	@OneToOne(mappedBy="grupoUsuarios")
	public CuentasUsuario getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
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
	 * @param enteUniversitarioPadre the enteUniversitarioPadre to set
	 */
	public void setEnteUniversitarioPadre(EnteUniversitario enteUniversitarioPadre) {
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
	 * @param enteUniversitarioHijo the enteUniversitarioHijo to set
	 */
	public void setEnteUniversitarioHijo(EnteUniversitario enteUniversitarioHijo) {
		this.enteUniversitarioHijo = enteUniversitarioHijo;
	}
	
	
	
		
	
	
}
