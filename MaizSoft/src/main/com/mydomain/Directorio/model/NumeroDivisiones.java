package com.mydomain.Directorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.jboss.seam.annotations.Name;

import com.sun.istack.internal.NotNull;

/**
* Descripcion: Esta Clase se encarga de almacenar informaciï¿½n relacionada
* con la división de los grupos.
* Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niï¿½o edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity(name="numero_divisiones")
@Name("numero_divisiones")
@Table(name="numero_divisones")
public class NumeroDivisiones {

	
	/**
	 * Variable que almacena la informaciï¿½n competente
	 * al identificador del nï¿½mero de divisiones que diferencian
	 * las actividades planteadas en el curso.
	 */
	private Long id; 
	
	
	/**
	 * Variable encargada de almacenar el nï¿½mero de divisiones
	 * presentes en cada curso.
	 */
	private Integer numeroDivision;
	
	/**
	 * Variable que se encarga de guardar la infomacï¿½on pertenenciente
	 * a las actividades planteadas en el curso.
	 * Instancia de la clase Actividad.
	 */
	private Actividad actividad;
	
	/**
	 * Variable encargada de almacenar informaciï¿½n pertinente de los 
	 * diferentes grupos de los cursos creados.
	 * Instancia de la clase GrupoCurso.
	 */
	private GrupoCurso grupoCurso;

	/**
	 * Se obtiene el valor de id
	 * @return El valor de id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "numeric(8)")
	public Long getId() {
		return id;
	}


	/**
	 * Asigna el valor de id
	 * @param id El valor por establecer para id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Se obtiene el valor de numeroDivision
	 * @return El valor de numeroDivision
	 */
	@Column(name = "id_numero_Division", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "numeric(3)")
	public Integer getNumeroDivision() {
		return numeroDivision;
	}


	/**
	 * Asigna el valor de numeroDivision
	 * @param numeroDivision El valor por establecer para numeroDivision
	 */
	public void setNumeroDivision(Integer numeroDivision) {
		this.numeroDivision = numeroDivision;
	}

	/**
	 * Se obtiene el valor de actividad
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
	 * @param actividad El valor por establecer para actividad
	 */
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	/**
	 * Se obtiene el valor de grupoCurso
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
	 * @param grupoCurso El valor por establecer para grupoCurso
	 */
	public void setGrupoCurso(GrupoCurso grupoCurso) {
		this.grupoCurso = grupoCurso;
	}
}