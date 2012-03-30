/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Nicolas
 *
 */
@Entity
@Table(name="facultad")
public class Facultad {
	
	private Long idFacultad;
	
	private  String nombreFacultad;
	
	private String descripcionFacultad;
	
	private Set<Escuela> listaEscuela;

	/**
	 * @return the idFacultad
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdFacultad() {
		return idFacultad;
	}

	/**
	 * @param idFacultad the idFacultad to set
	 */
	public void setIdFacultad(Long idFacultad) {
		this.idFacultad = idFacultad;
	}

	/**
	 * @return the nombreFacultad
	 */
	@Column(name="nombre_facultad")
	public String getNombreFacultad() {
		return nombreFacultad;
	}

	/**
	 * @param nombreFacultad the nombreFacultad to set
	 */
	public void setNombreFacultad(String nombreFacultad) {
		this.nombreFacultad = nombreFacultad;
	}

	/**
	 * @return the descripcionFacultad
	 */
	@Column(name="descripcion_facultad")
	public String getDescripcionFacultad() {
		return descripcionFacultad;
	}

	/**
	 * @param descripcionFacultad the descripcionFacultad to set
	 */
	public void setDescripcionFacultad(String descripcionFacultad) {
		this.descripcionFacultad = descripcionFacultad;
	}

	/**
	 * @return the listaEscuela
	 */
	@OneToMany (mappedBy="facultad")
	public Set<Escuela> getListaEscuela() {
		return listaEscuela;
	}

	/**
	 * @param listaEscuela the listaEscuela to set
	 */
	public void setListaEscuela(Set<Escuela> listaEscuela) {
		this.listaEscuela = listaEscuela;
	}
	
		

}
