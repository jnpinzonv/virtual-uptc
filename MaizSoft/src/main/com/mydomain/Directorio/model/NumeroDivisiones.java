package com.mydomain.Directorio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

/**
 * Descripcion: Esta Clase se encarga de almacenar informaci�n relacionada con
 * la divisi�n de los grupos. Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 23/06/2012
 */
@Entity(name = "NumeroDivisiones")
@Name("numeroDivisiones")
@Table(name = "numero_divisiones")
public class NumeroDivisiones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variable que almacena la informaci�n competente al identificador del
	 * n�mero de divisiones que diferencian las actividades planteadas en el
	 * curso.
	 */
	private Long id;

	/**
	 * Variable encargada de almacenar el n�mero de divisiones presentes en
	 * cada curso.
	 */
	private Integer numeroDivision;

	/**
	 * Variable que se encarga de guardar la infomac�on pertenenciente a las
	 * actividades planteadas en el curso. Instancia de la clase Actividad.
	 */
	private Actividad actividad;

	/**
	 * Variable encargada de almacenar informaci�n pertinente de los
	 * diferentes grupos de los cursos creados. Instancia de la clase
	 * GrupoCurso.
	 */
	private GrupoCurso grupoCurso;

	/**
	 * Se obtiene el valor de id
	 * 
	 * @return El valor de id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_numero_division", unique = false, nullable = false, insertable = true, updatable = true)
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
	 * Se obtiene el valor de numeroDivision
	 * 
	 * @return El valor de numeroDivision
	 */
	@Column(name = "numero_division", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "numeric(4)")
	public Integer getNumeroDivision() {
		return numeroDivision;
	}

	/**
	 * Asigna el valor de numeroDivision
	 * 
	 * @param numeroDivision
	 *            El valor por establecer para numeroDivision
	 */
	public void setNumeroDivision(Integer numeroDivision) {
		this.numeroDivision = numeroDivision;
	}

	/**
	 * Se obtiene el valor de actividad
	 * 
	 * @return El valor de actividad
	 */
	@ManyToOne
	@NotNull
	@JoinColumn(name = "id_actividad", unique = false, nullable = false, insertable = true, updatable = true)
	public Actividad getActividad() {
		return actividad;
	}

	/**
	 * Asigna el valor de actividad
	 * 
	 * @param actividad
	 *            El valor por establecer para actividad
	 */
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	/**
	 * Se obtiene el valor de grupoCurso
	 * 
	 * @return El valor de grupoCurso
	 */
	@ManyToOne
	@NotNull
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
}