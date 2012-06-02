/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name="configuraciones_sistema")
public class ConfiguracionesSistema {
	
	private Long id;
	
	
	private String nombrePropiedad;
	
	private String detallesPropiedad;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombrePropiedad
	 */
	@Column(name="nombre_propiedad", unique=true)
	public String getNombrePropiedad() {
		return nombrePropiedad;
	}

	/**
	 * @param nombrePropiedad the nombrePropiedad to set
	 */
	public void setNombrePropiedad(String nombrePropiedad) {
		this.nombrePropiedad = nombrePropiedad;
	}

	/**
	 * @return the detallesPropiedad
	 */
	@Column(name="detalles_propiedades")
	public String getDetallesPropiedad() {
		return detallesPropiedad;
	}

	/**
	 * @param detallesPropiedad the detallesPropiedad to set
	 */
	public void setDetallesPropiedad(String detallesPropiedad) {
		this.detallesPropiedad = detallesPropiedad;
	}
	
	
	
	

}
