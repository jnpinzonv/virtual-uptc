/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

import com.sun.org.apache.regexp.internal.recompile;

/**
* Descripcion: Esta Clase se encarga de gestionar el almacenamiento de datos, se comunica con la base de datos
* Modulo de Desarrollo :CU- ...
* @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity(name="Actividad")
@Table(name="actividad")
@Name("actividad")
public class Actividad {
	
	/**
	 * Variable que se encarga de crear un identificador de una actividad,
	 * se designa con un tipo de dato Long 
	 */
	private Long idActividad;
	
	/**
	 * Variable que se encarga de crear un campo en la base de datos para el 
	 * manejo de descripción de la actividad, se designa con tipo de dato String
	 */
	private String descripcionActividad;
	
	/**
	 * Variable que se encarga de informar el estado de evaluación de la acividad,
	 * como se manejan estados se designa bajo el tipo de dato boolean
	 */
	private boolean evaluable;
	
	/**
	 * Variable que se encarga de manejar una lista que almacena las notas de las 
	 * actividades que se encuentran en la base de datos.
	 * Se instancia de la clase NotaActividad
	 */
	private Set<NotaActividad> listaNotaActividades;
	
	/**
	 * Varible que se encarga de almacenar el tipo de actividad que se esta trabajando
	 * Instancia de la clase Tipo
	 */
	private Tipo tipo;
	
	/**
	 * Variable que se encarga de almacenar una lista de gestor de anuncios
	 * Se instancia de la clase GestorAnuncios
	 */
	private Set<GestorAnuncios> gestorAnuncios;
	
	/**
	 * Variable que se encarga de almacenar una lista de numero de divisiones
	 * Se instancia de la clase NumeroDivisiones
	 */
	private Set<NumeroDivisiones> numeroDivisiones;
	
	private Date fechaCreacion;
	
	private Date fechaFinalizacion;
	
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
	 * Se obtiene el valor de idActividad
	 * @return El valor de idActividad
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_actividad", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getIdActividad() {
		return idActividad;
	}

	/**
	 * Asigna el valor de idActividad
	 * @param idActividad El valor por establecer para idActividad
	 */
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	
	/**
	 * Se obtiene el valor de descripcionActividad
	 * @return El valor de descripcionActividad
	 */
	@Length(max=300)
	@Column(name = "descripcion_actividad", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(300)")
	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	/**
	 * Asigna el valor de descripcionActividad
	 * @param descripcionActividad El valor por establecer para descripcionActividad
	 */
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	/**
	 * Se obtiene el valor de evaluable
	 * @return El valor de evaluable
	 */
	@Column(name = "evaluable", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "bit(1)")
	public boolean isEvaluable() {
		
		return evaluable;
	}

	/**
	 * Asigna el valor de evaluable
	 * @param evaluable El valor por establecer para evaluable
	 */
	public void setEvaluable(boolean evaluable) {
		this.evaluable = evaluable;
	}

	
	/**
	 * Se obtiene el valor de listaNotaActividades
	 * @return El valor de listaNotaActividades
	 */
	@OneToMany(mappedBy="actividad", cascade=CascadeType.ALL)
	public Set<NotaActividad> getListaNotaActividades() {
		if(listaNotaActividades==null){
			return new HashSet<NotaActividad>();
		}
		return listaNotaActividades;
	}

	/**
	 * Asigna el valor de listaNotaActividades
	 * @param listaNotaActividades El valor por establecer para listaNotaActividades
	 */
	public void setListaNotaActividades(Set<NotaActividad> listaNotaActividades) {
		this.listaNotaActividades = listaNotaActividades;
	}

	/**
	 * Se obtiene el valor de gestorAnuncios
	 * @return El valor de gestorAnuncios
	 */
	@OneToMany(mappedBy="actividad",cascade=CascadeType.ALL)
	public Set<GestorAnuncios> getGestorAnuncios() {
		if(gestorAnuncios==null){
			return new HashSet<GestorAnuncios>();
		}
		return gestorAnuncios;
	}

	/**
	 * Asigna el valor de gestorAnuncios
	 * @param gestorAnuncios El valor por establecer para gestorAnuncios
	 */
	public void setGestorAnuncios(Set<GestorAnuncios> gestorAnuncios) {
		this.gestorAnuncios = gestorAnuncios;
	}

	/**
	 * @return the numeroDivisiones
	 */
	@OneToMany(mappedBy="actividad",cascade=CascadeType.ALL)
	public Set<NumeroDivisiones> getNumeroDivisiones() {
		return numeroDivisiones;
	}

	/**
	 * @param numeroDivisiones the numeroDivisiones to set
	 */
	public void setNumeroDivisiones(Set<NumeroDivisiones> numeroDivisiones) {
		this.numeroDivisiones = numeroDivisiones;
	}

	/**
	 * Se obtiene el valor de fechaCreacion
	 * @return El valor de fechaCreacion
	 */
	@NotNull
	@Column(name = "fecha_creacion", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "datetime")
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Asigna el valor de fechaCreacion
	 * @param fechaCreacion El valor por establecer para fechaCreacion
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Se obtiene el valor de fechaFinalizacion
	 * @return El valor de fechaFinalizacion
	 */
	@NotNull
	@Column(name = "fecha_Finalizacion", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "datetime")
	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	/**
	 * Asigna el valor de fechaFinalizacion
	 * @param fechaFinalizacion El valor por establecer para fechaFinalizacion
	 */
	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	
	
}
