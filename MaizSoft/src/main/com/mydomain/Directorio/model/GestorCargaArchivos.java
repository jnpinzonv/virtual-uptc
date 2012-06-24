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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;


/**
* Descripcion: Esta Clase se encarga de gestionar el almacenamiento de datos, 
* en esta clase con lo referente al gestor de carga de archivos, se comunica con la base de datos
* Modulo de Desarrollo :CU- ...
* @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity
@Table(name="gestor_carga_archivos")
public class GestorCargaArchivos {

	/**
	 * Variable que almacena el identificador del gestor de carga de archivos
	 * Tipo de Dato Long
	 */
	private Long idGestorCargaArchivos;
	
	/**
	 * Variable que almacena el nombre del archivo
	 * Tipo de dato String
	 */
	private String nombre;
	
	/**
	 * Variable que almacena la ruta en al que se encuentra el archivo
	 * Tipo de dato String
	 */
	private String ruta;
	
	/**
	 * Variable que almacena la descripción del archivo
	 * Tipo de Dato String
	 */
	private String descripcion;
	
	
	/**
	 * Variable que almacena las calificaciones de la actividad
	 * Se instancia de la clase NotaActividad
	 */
	private Set<NotaActividad> notaActividad;
	
	/**
	 * Variable que almacena el tipo de archivo a cargar
	 * Se instancia de la clase Tipo
	 */
	private Tipo tipo;
	
	
	
	
	/**
	 * Se obtiene el valor de idGestorCargaArchivos
	 * @return El valor de idGestorCargaArchivos
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_gestor_carga_archivos", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(20)")
	public Long getIdGestorCargaArchivos() {
		return idGestorCargaArchivos;
	}

	/**
	 * Asigna el valor de idGestorCargaArchivos
	 * @param idGestorCargaArchivos El valor por establecer para idGestorCargaArchivos
	 */
	public void setIdGestorCargaArchivos(Long idGestorCargaArchivos) {
		this.idGestorCargaArchivos = idGestorCargaArchivos;
	}

	/**
	 * Se obtiene el valor de nombre
	 * @return El valor de nombre
	 */
	@NotEmpty
	@Length(max=100)
	@Column(name = "nombre_archivo", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(100)")
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna el valor de nombre
	 * @param nombre El valor por establecer para nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Se obtiene el valor de ruta
	 * @return El valor de ruta
	 */
	@NotEmpty
	@Column(name = "ruta_archivo", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(100)")
	public String getRuta() {
		return ruta;
	}

	/**
	 * Asigna el valor de ruta
	 * @param ruta El valor por establecer para ruta
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * Se obtiene el valor de descripcion
	 * @return El valor de descripcion
	 */
	@Length(max=300)
	@Column(name = "descripcion_archivo", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(300)")
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Asigna el valor de descripcion
	 * @param descripcion El valor por establecer para descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * Se obtiene el valor de notaActividad
	 * @return El valor de notaActividad
	 */
	@OneToMany(mappedBy="gestorCargaArchivos",cascade=CascadeType.ALL)
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
