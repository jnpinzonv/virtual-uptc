/**
 * 
 */
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
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name="nota_actividad")
public class NotaActividad {

	private Long idNotaActividad;
	private boolean estadoPendiente;
	private String justificacion;
	
	private GestorCargaArchivos gestorCargaArchivos;
	
	private Actividad actividad;
	private GrupoUsuarios grupoCurso;
	private GestorMensajeria gestorMensajeria;
	
	private Long nota;
	

	/**
	 * @return the idNotaActividad
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdNotaActividad() {
		return idNotaActividad;
	}

	/**
	 * @param idNotaActividad the idNotaActividad to set
	 */
	public void setIdNotaActividad(Long idNotaActividad) {
		this.idNotaActividad = idNotaActividad;
	}

	/**
	 * @return the estadoPendiente
	 */
	public boolean isEstadoPendiente() {
		return estadoPendiente;
	}

	/**
	 * @param estadoPendiente the estadoPendiente to set
	 */
	public void setEstadoPendiente(boolean estadoPendiente) {
		this.estadoPendiente = estadoPendiente;
	}

	/**
	 * @return the justificacion
	 */
	@Length(max=300)
	public String getJustificacion() {
		return justificacion;
	}

	/**
	 * @param justificacion the justificacion to set
	 */
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	/**
	 * @return the gestorCargaArchivos
	 */
	
	@ManyToOne
	public GestorCargaArchivos getGestorCargaArchivos() {
		return gestorCargaArchivos;
	}

	/**
	 * @param gestorCargaArchivos the gestorCargaArchivos to set
	 */
	public void setGestorCargaArchivos(GestorCargaArchivos gestorCargaArchivos) {
		this.gestorCargaArchivos = gestorCargaArchivos;
	}

	

	/**
	 * @return the actividad
	 */
	@NotNull
	@ManyToOne
	public Actividad getActividad() {
		return actividad;
	}

	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	/**
	 * @return the grupoCurso
	 */
	@NotNull
	@ManyToOne
	public GrupoUsuarios getGrupoCurso() {
		return grupoCurso;
	}

	/**
	 * @param grupoCurso the grupoCurso to set
	 */
	public void setGrupoCurso(GrupoUsuarios grupoCurso) {
		this.grupoCurso = grupoCurso;
	}

	/**
	 * @return the gestorMensajeria
	 */
	@ManyToOne
	public GestorMensajeria getGestorMensajeria() {
		return gestorMensajeria;
	}

	/**
	 * @param gestorMensajeria the gestorMensajeria to set
	 */
	public void setGestorMensajeria(GestorMensajeria gestorMensajeria) {
		this.gestorMensajeria = gestorMensajeria;
	}

	/**
	 * @return the nota
	 */
	@NotNull
	public Long getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(Long nota) {
		this.nota = nota;
	}
	
	
	
}
