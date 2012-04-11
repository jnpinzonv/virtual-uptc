/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
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
@Table(name="curso")
public class Curso {

	private Long codigo;
	
	private String nombreAsignatura;
	
	private Escuela escuelaCurso;
	
	private Semestre semestreCurso;
	
	private Set<GrupoCurso> grupoCursos;
	
	
	
	/**
	 * @return the codigo
	 */
	@Id
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	
	@Column(name="codigo")
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombreAsignatura
	 */
	@Column(name="nombre_asignatura")
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	/**
	 * @param nombreAsignatura the nombreAsignatura to set
	 */
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	@ManyToOne
	public Escuela getEscuelaCurso() {
		return escuelaCurso;
	}

	/**
	 * @param escuelaCurso the escuelaCurso to set
	 */
	public void setEscuelaCurso(Escuela escuelaCurso) {
		this.escuelaCurso = escuelaCurso;
	}

	/**
	 * @return the semestreCurso
	 */
	@ManyToOne
	public Semestre getSemestreCurso() {
		return semestreCurso;
	}

	/**
	 * @param semestreCurso the semestreCurso to set
	 */
	public void setSemestreCurso(Semestre semestreCurso) {
		this.semestreCurso = semestreCurso;
	}

	/**
	 * @return the grupoCursos
	 */
	@OneToMany(mappedBy="cursoGrupo")
	public Set<GrupoCurso> getGrupoCursos() {
		if(grupoCursos==null){
			return new HashSet<GrupoCurso>();
		}
		return grupoCursos;
	}

	/**
	 * @param grupoCursos the grupoCursos to set
	 */
	public void setGrupoCursos(Set<GrupoCurso> grupoCursos) {
		this.grupoCursos = grupoCursos;
	}

	
	
	

}
