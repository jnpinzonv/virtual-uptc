/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name="gestor_carga_archivos")
public class GestorCargaArchivos {

	private Long idGestorCargaArchivos;
	
	private String nombre;
	
	private String ruta;
	
	private String descripcion;
	
	private Set<NotaActividad> notaActividad;
	
	private Tipo tipo;
	
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
	 * @return the idGestorCargaArchivos
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdGestorCargaArchivos() {
		return idGestorCargaArchivos;
	}

	/**
	 * @param idGestorCargaArchivos the idGestorCargaArchivos to set
	 */
	public void setIdGestorCargaArchivos(Long idGestorCargaArchivos) {
		this.idGestorCargaArchivos = idGestorCargaArchivos;
	}

	/**
	 * @return the nombre
	 */
	@NotEmpty
	@Length(max=100)
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the ruta
	 */
	@NotEmpty
	public String getRuta() {
		return ruta;
	}

	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * @return the descripcion
	 */
	@Length(max=300)
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the notaActividad
	 */
	@OneToMany(mappedBy="gestorCargaArchivos",cascade=CascadeType.ALL)
	public Set<NotaActividad> getNotaActividad() {
		if(notaActividad==null){
			return new HashSet<NotaActividad>();
		}
		return notaActividad;
	}

	/**
	 * @param notaActividad the notaActividad to set
	 */
	public void setNotaActividad(Set<NotaActividad> notaActividad) {
		this.notaActividad = notaActividad;
	}

	
	
	
	
}
