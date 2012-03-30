/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Nicolas
 *
 */
@Entity
@Table(name="actividad")
public class Actividad {
	
	private Long idActividad;
	
	private String descripcionActividad;
	
	private boolean evaluable;
	
	private Nota nota;
	
	
	private GrupoCurso actividadGrupoCurso;

	/**
	 * @return the idActividad
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdActividad() {
		return idActividad;
	}

	/**
	 * @param idActividad the idActividad to set
	 */
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	/**
	 * @return the descripcionActividad
	 */
	@Column(name="descripcion_actividad")
	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	/**
	 * @param descripcionActividad the descripcionActividad to set
	 */
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	/**
	 * @return the evaluable
	 */
	@Column(name="evaluable")
	public boolean isEvaluable() {
		return evaluable;
	}

	/**
	 * @param evaluable the evaluable to set
	 */
	public void setEvaluable(boolean evaluable) {
		this.evaluable = evaluable;
	}

	/**
	 * @return the actividadGrupoCurso
	 */
	@ManyToOne
	public GrupoCurso getActividadGrupoCurso() {
		return actividadGrupoCurso;
	}

	/**
	 * @param actividadGrupoCurso the actividadGrupoCurso to set
	 */
	public void setActividadGrupoCurso(GrupoCurso actividadGrupoCurso) {
		this.actividadGrupoCurso = actividadGrupoCurso;
	}

	/**
	 * @return the nota
	 */
	@OneToOne(mappedBy="actividad")
	public Nota getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
	
	

}
