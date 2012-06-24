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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;


/**
* Descripcion: Esta Clase se encarga de gestionar el almacenamiento de datos, 
* en esta clase con lo referente al gestor de mensajería, se comunica con la base de datos
* Modulo de Desarrollo :CU- ...
* @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity(name="GestorMensajeria")
@Table(name="gestor_mensajeria")
@Name("gestorMensajeria")
public class GestorMensajeria {

	/**
	 * Variable que almacena el identificador del mensaje
	 * Tipo de Dato Long
	 */
	private Long idMensaje;
	
	/**
	 * Variable que almacena usuarios quienes envian el mensaje
	 * Se instancia de la clase Usuario
	 */
	private Usuario deUsuario;
	
	/**
	 * Variable que almacena el mensaje 
	 * Tipo de dato String
	 */
	private String mensaje;
	
	/**
	 * Variable que almacena el asunto del mensaje
	 * Tipo de dato String
	 */
	private String asunto;
	
	/**
	 * Variable que almacena la fecha en la que se envía el mensaje
	 * Tipo de dato Date
	 */
	private Date fechaEnvio;
	
	/**
	 * Variable que almacena el tipo de mensaje a transmitir
	 * Se instancia de la clase Tipo
	 */
	private Tipo tipo;
	
	/**
	 * Variable que almacena un listado de gestores de mensajería
	 * Se instancia de la clase GestorMensajería
	 */
	private Set<GestorMensajeria> listaGestorMensajeria;
	
	/**
	 * Variable que almacena los gestores de mensajería
	 * Se instancia de la clase GestorMensajería 
	 */
	private GestorMensajeria gestorMensajeria;
	
	/**
	 * Variable que almacena la nota de la actividad
	 * Se instancia de la clase NotaActividad
	 */
	private Set<NotaActividad> notaActividad;

	/**
	 * Se obtiene el valor de idMensaje
	 * @return El valor de idMensaje
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name = "id_mensaje", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getIdMensaje() {
		return idMensaje;
	}

	/**
	 * Asigna el valor de idMensaje
	 * @param idMensaje El valor por establecer para idMensaje
	 */
	public void setIdMensaje(Long idMensaje) {
		this.idMensaje = idMensaje;
	}

	/**
	 * Se obtiene el valor de deUsuario
	 * @return El valor de deUsuario
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_de_usuario", unique = false, nullable = false, insertable = true, updatable = true)
	public Usuario getDeUsuario() {
		return deUsuario;
	}

	/**
	 * Asigna el valor de deUsuario
	 * @param deUsuario El valor por establecer para deUsuario
	 */
	public void setDeUsuario(Usuario deUsuario) {
		this.deUsuario = deUsuario;
	}

	/**
	 * Se obtiene el valor de mensaje
	 * @return El valor de mensaje
	 */
	@NotNull
	@Lob
	@Column(name = "mensaje", unique = false, nullable = false, insertable = true, updatable = true)
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Asigna el valor de mensaje
	 * @param mensaje El valor por establecer para mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Se obtiene el valor de asunto
	 * @return El valor de asunto
	 */
	@Length(max=100)
	@Column(name = "asunto", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(60)")
	public String getAsunto() {
		return asunto;
	}

	/**
	 * Asigna el valor de asunto
	 * @param asunto El valor por establecer para asunto
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	/**
	 * Se obtiene el valor de fechaEnvio
	 * @return El valor de fechaEnvio
	 */
	@NotNull	
	@Column(name = "fecha_envio", unique = false, nullable = false, insertable = true, updatable = true)
	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	/**
	 * Asigna el valor de fechaEnvio
	 * @param fechaEnvio El valor por establecer para fechaEnvio
	 */
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	/**
	 * Se obtiene el valor de tipo
	 * @return El valor de tipo
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_tipo", unique = false, nullable = false, insertable = true, updatable = true)
	public Tipo getTipo() {
		return tipo;
	}

	/**
	 * Asigna el valor de tipo
	 * @param tipo El valor por establecer para tipo
	 */
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	/**
	 * Se obtiene el valor de listaGestorMensajeria
	 * @return El valor de listaGestorMensajeria
	 */
	@OneToMany(mappedBy="gestorMensajeria",cascade=CascadeType.ALL)
	public Set<GestorMensajeria> getListaGestorMensajeria() {
		return listaGestorMensajeria;
	}

	/**
	 * Asigna el valor de listaGestorMensajeria
	 * @param listaGestorMensajeria El valor por establecer para listaGestorMensajeria
	 */
	public void setListaGestorMensajeria(Set<GestorMensajeria> listaGestorMensajeria) {
		this.listaGestorMensajeria = listaGestorMensajeria;
	}

	/**
	 * Se obtiene el valor de gestorMensajeria
	 * @return El valor de gestorMensajeria
	 */
	@ManyToOne
	@JoinColumn(name = "id_gestor_mensajería", unique = false, nullable = false, insertable = true, updatable = true)
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
	 * Se obtiene el valor de notaActividad
	 * @return El valor de notaActividad
	 */
	@OneToMany(mappedBy="gestorMensajeria",cascade=CascadeType.ALL)
	public Set<NotaActividad> getNotaActividad() {
		return notaActividad;
	}

	/**
	 * Asigna el valor de notaActividad
	 * @param notaActividad El valor por establecer para notaActividad
	 */
	public void setNotaActividad(Set<NotaActividad> notaActividad) {
		this.notaActividad = notaActividad;
	}
	
}
