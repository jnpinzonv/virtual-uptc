/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * @author Nicolas
 *
 */
@Entity
@Table(name="actividad")
public class Actividad {
	
	private Long idActividad;
	
	private String descripcionActividad;
	
	private boolean evaluable;
	
	private Set<NotaActividad> listaNotaActividades;
	
	private Tipo tipo;
	
	private Set<GestorAnuncios> gestorAnuncios;
	
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
	 * @return the idActividad
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdActividad() {
		return idActividad;
	}

	/**
	 * @param idActividad the idActividad to set
	 */
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}

	/**
	 * @return the descripcionActividad
	 */
	@Column(name="descripcion_actividad")
	@Length(max=300)
	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	/**
	 * @param descripcionActividad the descripcionActividad to set
	 */
	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	/**
	 * @return the evaluable
	 */
	@Column(name="evaluable")
	public boolean isEvaluable() {
		return evaluable;
	}

	/**
	 * @param evaluable the evaluable to set
	 */
	public void setEvaluable(boolean evaluable) {
		this.evaluable = evaluable;
	}

	/**
	 * @return the listaNotaActividades
	 */
	@OneToMany(mappedBy="actividad", cascade=CascadeType.ALL)
	public Set<NotaActividad> getListaNotaActividades() {
		if(listaNotaActividades==null){
			return new HashSet<NotaActividad>();
		}
		return listaNotaActividades;
	}

	/**
	 * @param listaNotaActividades the listaNotaActividades to set
	 */
	public void setListaNotaActividades(Set<NotaActividad> listaNotaActividades) {
		this.listaNotaActividades = listaNotaActividades;
	}

	/**
	 * @return the gestorAnuncios
	 */
	@OneToMany(mappedBy="actividad",cascade=CascadeType.ALL)
	public Set<GestorAnuncios> getGestorAnuncios() {
		if(gestorAnuncios==null){
			return new HashSet<GestorAnuncios>();
		}
		return gestorAnuncios;
	}

	/**
	 * @param gestorAnuncios the gestorAnuncios to set
	 */
	public void setGestorAnuncios(Set<GestorAnuncios> gestorAnuncios) {
		this.gestorAnuncios = gestorAnuncios;
	}

	
}
