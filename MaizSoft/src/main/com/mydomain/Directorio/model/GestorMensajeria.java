/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name="gestor_mensajeria")
public class GestorMensajeria {

	private Long idMensaje;
	

	
	private Usuario deUsuario;
	
	private String mensaje;
	
	private String asunto;
	
	private Date fechaEnvio;
	
	private Tipo tipo;
	
	private Set<GestorMensajeria> listaGestorMensajeria;
	
	private GestorMensajeria gestorMensajeria;
	
	private Set<NotaActividad> notaActividad;
	
	/**
	 * @return the tipo
	 */
	@NotNull
	@ManyToOne
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the idMensaje
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getIdMensaje() {
		return idMensaje;
	}

	/**
	 * @param idMensaje the idMensaje to set
	 */
	
	public void setIdMensaje(Long idMensaje) {
		this.idMensaje = idMensaje;
	}

	

	/**
	 * @return the deUsuario
	 */
	@NotNull
	@ManyToOne
	public Usuario getDeUsuario() {
		return deUsuario;
	}

	/**
	 * @param deUsuario the deUsuario to set
	 */
	public void setDeUsuario(Usuario deUsuario) {
		this.deUsuario = deUsuario;
	}

	/**
	 * @return the mensaje
	 */
	@Column(name= "mensaje")
	@NotNull
	@Lob
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the asunto
	 */
	@Column(name= "asunto")
	@Length(max=100)
	public String getAsunto() {
		return asunto;
	}

	/**
	 * @param asunto the asunto to set
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	/**
	 * @return the fechaEnvio
	 */
	@NotNull
	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	/**
	 * @param fechaEnvio the fechaEnvio to set
	 */
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	/**
	 * @return the listaGestorMensajeria
	 */
	@OneToMany(mappedBy="gestorMensajeria",cascade=CascadeType.ALL)
	public Set<GestorMensajeria> getListaGestorMensajeria() {
		return listaGestorMensajeria;
	}

	/**
	 * @param listaGestorMensajeria the listaGestorMensajeria to set
	 */
	public void setListaGestorMensajeria(Set<GestorMensajeria> listaGestorMensajeria) {
		this.listaGestorMensajeria = listaGestorMensajeria;
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
	 * @return the notaActividad
	 */
	@OneToMany(mappedBy="gestorMensajeria",cascade=CascadeType.ALL)
	public Set<NotaActividad> getNotaActividad() {
		return notaActividad;
	}

	/**
	 * @param notaActividad the notaActividad to set
	 */
	public void setNotaActividad(Set<NotaActividad> notaActividad) {
		this.notaActividad = notaActividad;
	}
	
}
