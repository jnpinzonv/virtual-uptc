package com.mydomain.Directorio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Size;

/**
* Descripcion: Esta Clase se encarga de almacenar toda la información
* relacionada con las calificaciones obtenidas por los usuarios en
* las actividades realizadas por cada uno de ellos.
* Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity
@Table(name="nota_actividad")
public class NotaActividad {

	/**
	 * Variable encargada de almacenar el identificador de las
	 * notas o calificaciones de determinada actividad.
	 */
	private Long idNotaActividad;
	
	/**
	 * Variable encargada de informar si el estado de la nota de
	 * determinada actividad está pendiente o ya fue asignada.
	 */
	private boolean estadoPendiente;
	
	/**
	 * Variable encargada de almacenar la descripción de la justificación
	 * de la nota o calificación de determinada actividad.
	 */
	private String justificacion;
	
	/**
	 * Variable encargada de almacenar lo referente a cargar archivos 
	 * en la plataforma.
	 * Instancia de la clase GestorCargaArchivos.
	 */
	private GestorCargaArchivos gestorCargaArchivos;
	
	/**
	 * Variable encargada de guardar la información relacionada
	 * a las diferentes actividades planteadas en la plataforma.
	 * Instancia de la clase Actividad.
	 */
	private Actividad actividad;
	/**
	 * Variable encargada de almacenar información competente
	 * a los grupos de usuarios
	 */
	private GrupoUsuarios grupoCurso;
	
	/**
	 * Variable encargada de almacenar información relacionada
	 * con mensajería.
	 * Instancia de la clase GestorMensajeria.
	 */
	private GestorMensajeria gestorMensajeria;
	
	/**
	 * Variable encargada de guardar las notas o calificaciones
	 * obtenidas por determinado usuario en una actividad dada.
	 */
	private Long nota;
	

	/**
	 * Se obtiene el valor de idNotaActividad
	 * @return El valor de idNotaActividad
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdNotaActividad() {
		return idNotaActividad;
	}

	/**
	 * Asigna el valor de idNotaActividad
	 * @param idNotaActividad El valor por establecer para idNotaActividad
	 */
	public void setIdNotaActividad(Long idNotaActividad) {
		this.idNotaActividad = idNotaActividad;
	}
	
	/**
	 * Se obtiene el valor de estadoPendiente
	 * @return El valor de estadoPendiente
	 */
	public boolean isEstadoPendiente() {
		return estadoPendiente;
	}

	/**
	 * Asigna el valor de estadoPendiente
	 * @param estadoPendiente El valor por establecer para estadoPendiente
	 */
	public void setEstadoPendiente(boolean estadoPendiente) {
		this.estadoPendiente = estadoPendiente;
	}
	
	/**
	 * Se obtiene el valor de justificacion
	 * @return El valor de justificacion
	 */
	@Length(max=300)
	public String getJustificacion() {
		return justificacion;
	}

	/**
	 * Asigna el valor de justificacion
	 * @param justificacion El valor por establecer para justificacion
	 */
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	
	/**
	 * Se obtiene el valor de gestorCargaArchivos
	 * @return El valor de gestorCargaArchivos
	 */
	@ManyToOne
	public GestorCargaArchivos getGestorCargaArchivos() {
		return gestorCargaArchivos;
	}

	/**
	 * Asigna el valor de gestorCargaArchivos
	 * @param gestorCargaArchivos El valor por establecer para gestorCargaArchivos
	 */
	public void setGestorCargaArchivos(GestorCargaArchivos gestorCargaArchivos) {
		this.gestorCargaArchivos = gestorCargaArchivos;
	}
	
	/**
	 * Se obtiene el valor de actividad
	 * @return El valor de actividad
	 */
	@NotNull
	@ManyToOne
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
	@NotNull
	@ManyToOne
	public GrupoUsuarios getGrupoCurso() {
		return grupoCurso;
	}

	/**
	 * Asigna el valor de grupoCurso
	 * @param grupoCurso El valor por establecer para grupoCurso
	 */
	public void setGrupoCurso(GrupoUsuarios grupoCurso) {
		this.grupoCurso = grupoCurso;
	}

	/**
	 * Se obtiene el valor de gestorMensajeria
	 * @return El valor de gestorMensajeria
	 */
	@ManyToOne
	public GestorMensajeria getGestorMensajeria() {
		return gestorMensajeria;
	}

	/**
	 * Asigna el valor de gestorMensajeria
	 * @param gestorMensajeria El valor por establecer para gestorMensajeria
	 */
	public void setGestorMensajeria(GestorMensajeria gestorMensajeria) {
		this.gestorMensajeria = gestorMensajeria;
	}

	/**
	 * Se obtiene el valor de nota
	 * @return El valor de nota
	 */
	@NotNull
	public Long getNota() {
		return nota;
	}

	/**
	 * Asigna el valor de nota
	 * @param nota El valor por establecer para nota
	 */
	public void setNota(Long nota) {
		this.nota = nota;
	}
}
