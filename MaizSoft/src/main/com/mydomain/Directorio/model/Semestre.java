/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Nicolas
 *
 */
@Entity
@Table(name="semestre")
public class Semestre {
	
	private Long idSemestre;
	
	private Integer anioAcademico;
	
	private Integer semestreAcademico;
	
	private Set<Curso> cursoSemestre;

	/**
	 * @return the idSemestre
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdSemestre() {
		return idSemestre;
	}

	/**
	 * @param idSemestre the idSemestre to set
	 */
	public void setIdSemestre(Long idSemestre) {
		this.idSemestre = idSemestre;
	}

	/**
	 * @return the anioAcademico
	 */
	@Column(name="anio_academico")
	public Integer getAnioAcademico() {
		return anioAcademico;
	}

	/**
	 * @param anioAcademico the anioAcademico to set
	 */
	public void setAnioAcademico(Integer anioAcademico) {
		this.anioAcademico = anioAcademico;
	}

	/**
	 * @return the semestreAcademico
	 */
	@Column(name="semestre_academico")
	public Integer getSemestreAcademico() {
		return semestreAcademico;
	}

	/**
	 * @param semestreAcademico the semestreAcademico to set
	 */
	public void setSemestreAcademico(Integer semestreAcademico) {
		this.semestreAcademico = semestreAcademico;
	}

	/**
	 * @return the cursoSemestre
	 */
	@OneToMany(mappedBy="semestreCurso")
	public Set<Curso> getCursoSemestre() {
		if(cursoSemestre==null){
			return new HashSet<Curso>();
		}
		return cursoSemestre;
	}

	/**
	 * @param cursoSemestre the cursoSemestre to set
	 */
	public void setCursoSemestre(Set<Curso> cursoSemestre) {
		this.cursoSemestre = cursoSemestre;
	}
	
	
	

}
