/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 * @author Nicolas
 *
 */
@Entity
@Table(name="escuela")
public class Escuela {

	private Long idEscuela;
	
	private  String nombreEscuela;
	
	private String descripcionEscuela;
	
	private Facultad facultad;
	
	private Set<Curso> listaCursosOfrecidos;

	/**
	 * @return the idEscuela
	 */
	@Id
	public Long getIdEscuela() {
		return idEscuela;
	}

	/**
	 * @param idEscuela the idEscuela to set
	 */
	public void setIdEscuela(Long idEscuela) {
		this.idEscuela = idEscuela;
	}

	/**
	 * @return the nombreEscuela
	 */
	@Column(name="nombre_escuela")
	public String getNombreEscuela() {
		return nombreEscuela;
	}

	/**
	 * @param nombreEscuela the nombreEscuela to set
	 */
	public void setNombreEscuela(String nombreEscuela) {
		this.nombreEscuela = nombreEscuela;
	}

	/**
	 * @return the descripcionEscuela
	 */
	@Column(name="descripcion_escuela")
	public String getDescripcionEscuela() {
		return descripcionEscuela;
	}

	/**
	 * @param descripcionEscuela the descripcionEscuela to set
	 */
	public void setDescripcionEscuela(String descripcionEscuela) {
		this.descripcionEscuela = descripcionEscuela;
	}

	/**
	 * @return the facultad
	 */
	@NotNull 
	@ManyToOne
	public Facultad getFacultad() {
		return facultad;
	}

	/**
	 * @param facultad the facultad to set
	 */
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	/**
	 * @return the listaCursosOfrecidos
	 */
	@OneToMany(mappedBy="escuelaCurso")
	public Set<Curso> getListaCursosOfrecidos() {
		if(listaCursosOfrecidos==null){
			return new HashSet<Curso>();
		}
		return listaCursosOfrecidos;
	}

	/**
	 * @param listaCursosOfrecidos the listaCursosOfrecidos to set
	 */
	public void setListaCursosOfrecidos(Set<Curso> listaCursosOfrecidos) {
		this.listaCursosOfrecidos = listaCursosOfrecidos;
	}
	
		
	
}
