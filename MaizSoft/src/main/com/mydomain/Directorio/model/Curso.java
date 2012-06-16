/**
 * 
 */
package com.mydomain.Directorio.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Size;

/**
 * @author Nicolas
 *
 */
@Entity
@Table(name="curso")
public class Curso {

	private Long codigo;
	
	private String nombreAsignatura;	
	
	private Set<GrupoCurso> grupoCursos;
	
	private EnteUniversitario enteUniversitario;
	
	/**
	 * @return the codigo
	 */
	@Id
	@NotNull	
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombreAsignatura
	 */
	@NotEmpty
	@Column(name="nombre_asignatura" )
	@Length(max=200)
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	/**
	 * @param nombreAsignatura the nombreAsignatura to set
	 */
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	

	/**
	 * @return the grupoCursos
	 */
	@OneToMany(mappedBy="cursoGrupo", cascade=CascadeType.ALL)
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

	/**
	 * @return the enteUniversitario
	 */
	@NotNull
	@ManyToOne
	public EnteUniversitario getEnteUniversitario() {
		return enteUniversitario;
	}

	/**
	 * @param enteUniversitario the enteUniversitario to set
	 */
	public void setEnteUniversitario(EnteUniversitario enteUniversitario) {
		this.enteUniversitario = enteUniversitario;
	}

	
	
	

}
