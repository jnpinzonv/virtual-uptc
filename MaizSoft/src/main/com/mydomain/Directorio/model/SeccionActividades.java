/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;

/**
* Descripcion: Esta Clase se encarga de almacenar información
* competente a las diferentes secciones de las actividades
* del curso.
* Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
public class SeccionActividades {
	
	/**
	 * Variable encargada de almacenar lo referente
	 * a las sesiones de las distinta actividades
	 * planteadas por el docente en la plataforma.
	 */
	private Long idSeccionActividades;
	
	/**
	 * Variable encargada de almacenar el nombre de las
	 * secciones que conforman el curso.
	 */
	private String nombreSeccion;
	
	/**
	 * Variable encargada de guardar la información referente a 
	 * las diferentes actividades planteadas.
	 * Instancia de la clase Actividad.
	 */
	private Actividad actividad;


	/**
	 * Se obtiene el valor de idSeccionActividades
	 * @return El valor de idSeccionActividades
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_Seccion_Actividades", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "numeric(8)")
	public Long getIdSeccionActividades() {
		return idSeccionActividades;
	}

	/**
	 * Asigna el valor de idSeccionActividades
	 * @param idSeccionActividades El valor por establecer para idSeccionActividades
	 */
	public void setIdSeccionActividades(Long idSeccionActividades) {
		this.idSeccionActividades = idSeccionActividades;
	}
	
	/**
	 * Se obtiene el valor de nombreSeccion
	 * @return El valor de nombreSeccion
	 */
	@NotEmpty
	@Length(max=100)
	@Column(name = "id_nombre_Seccion", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(20)")
	public String getNombreSeccion() {
		return nombreSeccion;
	}

	/**
	 * Asigna el valor de nombreSeccion
	 * @param nombreSeccion El valor por establecer para nombreSeccion
	 */
	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}
	
	/**
	 * Se obtiene el valor de actividad
	 * @return El valor de actividad
	 */
	@Column(name = "id_actividad", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "numeric(8)")
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
}
