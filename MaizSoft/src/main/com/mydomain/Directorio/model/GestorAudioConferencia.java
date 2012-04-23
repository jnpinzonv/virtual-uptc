/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name="gestor_audio_conferencia")
public class GestorAudioConferencia {

	private Long idAudioConferencia;	
	
	private UserAccount usuarioCreador;
	
	private String tituloAudioConferencia;
	
	private String descripcionAudioConferencia;
	
	private Date fechaAudioConferencia;
	
	private String horaAudioConferencia;
	
	private TipoAmPm tipoAmPm;
	
	private GrupoCurso grupoCursoAudio;

	/**
	 * @return the idAudioConferencia
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdAudioConferencia() {
		return idAudioConferencia;
	}

	/**
	 * @param idAudioConferencia the idAudioConferencia to set
	 */
	public void setIdAudioConferencia(Long idAudioConferencia) {
		this.idAudioConferencia = idAudioConferencia;
	}

	/**
	 * @return the usuarioCreador
	 */
	@NotNull
	@ManyToOne
	public UserAccount getUsuarioCreador() {
		return usuarioCreador;
	}

	/**
	 * @param usuarioCreador the usuarioCreador to set
	 */
	public void setUsuarioCreador(UserAccount usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

	/**
	 * @return the tituloAudioConferencia
	 */
	@NotNull
	public String getTituloAudioConferencia() {
		return tituloAudioConferencia;
	}

	/**
	 * @param tituloAudioConferencia the tituloAudioConferencia to set
	 */
	public void setTituloAudioConferencia(String tituloAudioConferencia) {
		this.tituloAudioConferencia = tituloAudioConferencia;
	}

	/**
	 * @return the descripcionAudioConferencia
	 */
	public String getDescripcionAudioConferencia() {
		return descripcionAudioConferencia;
	}

	/**
	 * @param descripcionAudioConferencia the descripcionAudioConferencia to set
	 */
	public void setDescripcionAudioConferencia(String descripcionAudioConferencia) {
		this.descripcionAudioConferencia = descripcionAudioConferencia;
	}

	/**
	 * @return the fechaAudioConferencia
	 */
	@NotNull
	public Date getFechaAudioConferencia() {
		return fechaAudioConferencia;
	}

	/**
	 * @param fechaAudioConferencia the fechaAudioConferencia to set
	 */
	public void setFechaAudioConferencia(Date fechaAudioConferencia) {
		this.fechaAudioConferencia = fechaAudioConferencia;
	}

	/**
	 * @return the horaAudioConferencia
	 */
	@NotNull
	public String getHoraAudioConferencia() {
		return horaAudioConferencia;
	}

	/**
	 * @param horaAudioConferencia the horaAudioConferencia to set
	 */
	public void setHoraAudioConferencia(String horaAudioConferencia) {
		this.horaAudioConferencia = horaAudioConferencia;
	}

	/**
	 * @return the tipoAmPm
	 */
	@Enumerated(EnumType.STRING)
	public TipoAmPm getTipoAmPm() {
		return tipoAmPm;
	}

	/**
	 * @param tipoAmPm the tipoAmPm to set
	 */
	public void setTipoAmPm(TipoAmPm tipoAmPm) {
		this.tipoAmPm = tipoAmPm;
	}

	/**
	 * @return the grupoCursoAudio
	 */
	@NotNull
	@ManyToOne
	public GrupoCurso getGrupoCursoAudio() {
		return grupoCursoAudio;
	}

	/**
	 * @param grupoCursoAudio the grupoCursoAudio to set
	 */
	public void setGrupoCursoAudio(GrupoCurso grupoCursoAudio) {
		this.grupoCursoAudio = grupoCursoAudio;
	}
	
	
	

}
