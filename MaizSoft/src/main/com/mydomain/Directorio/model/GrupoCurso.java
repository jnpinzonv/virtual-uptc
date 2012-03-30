/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Nicolas
 *
 */
@Entity
@Table(name= "grupo_curso")
public class GrupoCurso {
	
	private Long IdGrupo;
		
	private Integer cupos;
	
	private Integer inscritos;
	
	private Curso cursoGrupo;
	
	private Set<UserAccount> listaUsuarios;

	private Set< Actividad> actividades;
	/**
	 * @return the idGrupo
	 */
	@Id
	public Long getIdGrupo() {
		return IdGrupo;
	}

	/**
	 * @param idGrupo the idGrupo to set
	 */
	public void setIdGrupo(Long idGrupo) {
		IdGrupo = idGrupo;
	}

	
	/**
	 * @return the cupos
	 */
	@Column(name="cupos")
	public Integer getCupos() {
		return cupos;
	}

	/**
	 * @param cupos the cupos to set
	 */
	public void setCupos(Integer cupos) {
		this.cupos = cupos;
	}

	/**
	 * @return the inscritos
	 */
	@Column(name="inscritos")
	public Integer getInscritos() {
		return inscritos;
	}

	/**
	 * @param inscritos the inscritos to set
	 */
	public void setInscritos(Integer inscritos) {
		this.inscritos = inscritos;
	}

	/**
	 * @return the cursoGrupo
	 */
	@ManyToOne
	public Curso getCursoGrupo() {
		return cursoGrupo;
	}

	/**
	 * @param cursoGrupo the cursoGrupo to set
	 */
	public void setCursoGrupo(Curso cursoGrupo) {
		this.cursoGrupo = cursoGrupo;
	}

	/**
	 * @return the listaUsuarios
	 */
	@OneToMany(mappedBy="grupoCurso")
	public Set<UserAccount> getListaUsuarios() {
		return listaUsuarios;
	}

	/**
	 * @param listaUsuarios the listaUsuarios to set
	 */
	public void setListaUsuarios(Set<UserAccount> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	/**
	 * @return the actividades
	 */
	@OneToMany(mappedBy="actividadGrupoCurso")
	public Set<Actividad> getActividades() {
		return actividades;
	}

	/**
	 * @param actividades the actividades to set
	 */
	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	
	
	
	

}
