/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.Date;
import java.util.Set;

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
@Table(name="gestor_video_conferencia")
public class GestorVideoConferencia {

	private Long idvideoConferencia;
	
	
	private UserAccount usuarioCreador;
	
	private String tituloVideoConferencia;
	
	private String descripcionVideoConferencia;
	
	private Date fechaVideoConferencia;
	
	private String horaVideoConferencia;
	
	private TipoAmPm tipoAmPm;
	
	private GrupoCurso grupoCursoVideo;

	/**
	 * @return the idvideoConferencia
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getIdvideoConferencia() {
		return idvideoConferencia;
	}

	/**
	 * @param idvideoConferencia the idvideoConferencia to set
	 */
	public void setIdvideoConferencia(Long idvideoConferencia) {
		this.idvideoConferencia = idvideoConferencia;
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
	 * @return the tituloVideoConferencia
	 */
	public String getTituloVideoConferencia() {
		return tituloVideoConferencia;
	}

	/**
	 * @param tituloVideoConferencia the tituloVideoConferencia to set
	 */
	public void setTituloVideoConferencia(String tituloVideoConferencia) {
		this.tituloVideoConferencia = tituloVideoConferencia;
	}

	/**
	 * @return the descripcionVideoConferencia
	 */
	public String getDescripcionVideoConferencia() {
		return descripcionVideoConferencia;
	}

	/**
	 * @param descripcionVideoConferencia the descripcionVideoConferencia to set
	 */
	public void setDescripcionVideoConferencia(String descripcionVideoConferencia) {
		this.descripcionVideoConferencia = descripcionVideoConferencia;
	}

	/**
	 * @return the fechaVideoConferencia
	 */
	@NotNull
	public Date getFechaVideoConferencia() {
		return fechaVideoConferencia;
	}

	/**
	 * @param fechaVideoConferencia the fechaVideoConferencia to set
	 */
	public void setFechaVideoConferencia(Date fechaVideoConferencia) {
		this.fechaVideoConferencia = fechaVideoConferencia;
	}

	/**
	 * @return the horaVideoConferencia
	 */
	@NotNull
	public String getHoraVideoConferencia() {
		return horaVideoConferencia;
	}

	/**
	 * @param horaVideoConferencia the horaVideoConferencia to set
	 */
	public void setHoraVideoConferencia(String horaVideoConferencia) {
		this.horaVideoConferencia = horaVideoConferencia;
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
	 * @return the grupoCursoVideo
	 */
	@NotNull
	@ManyToOne
	public GrupoCurso getGrupoCursoVideo() {
		return grupoCursoVideo;
	}

	/**
	 * @param grupoCursoVideo the grupoCursoVideo to set
	 */
	public void setGrupoCursoVideo(GrupoCurso grupoCursoVideo) {
		this.grupoCursoVideo = grupoCursoVideo;
	}
	
	
	
}
