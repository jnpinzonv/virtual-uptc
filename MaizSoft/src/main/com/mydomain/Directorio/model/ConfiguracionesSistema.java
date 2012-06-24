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


/**Descripcion: Esta Clase se encarga de gestionar el almacenamiento de datos, 
* en esta clase con lo referente a la configuración del sistema, se comunica con la base de datos
* Modulo de Desarrollo :CU- ...
* @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity
@Table(name="configuraciones_sistema")
public class ConfiguracionesSistema {
	
	/**
	 * Variable que designa un identificador
	 * Tipo de dato que trabaja es Long
	 */
	private Long id;
	
	/**
	 * Variable que se encarga de almacenar el nombre de la propiedad
	 * Va definida mediante un tipo de dato String
	 */
	private String nombrePropiedad;
	
	/**
	 * Variable que se encarga de almacenar detalles de la propiedad
	 * Va definida mediante un tipo de dato String
	 */
	private String detallesPropiedad;

	
	/**
	 * Se obtiene el valor de id
	 * @return El valor de id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * Asigna el valor de id
	 * @param id El valor por establecer para id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Se obtiene el valor de nombrePropiedad
	 * @return El valor de nombrePropiedad
	 */
	@Column(name = "tipo", unique = true, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(20)")
	public String getNombrePropiedad() {
		return nombrePropiedad;
	}

	/**
	 * Asigna el valor de nombrePropiedad
	 * @param nombrePropiedad El valor por establecer para nombrePropiedad
	 */
	public void setNombrePropiedad(String nombrePropiedad) {
		this.nombrePropiedad = nombrePropiedad;
	}

	/**
	 * Se obtiene el valor de detallesPropiedad
	 * @return El valor de detallesPropiedad
	 */
	@Column(name = "tipo", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(50)")
	public String getDetallesPropiedad() {
		return detallesPropiedad;
	}

	/**
	 * Asigna el valor de detallesPropiedad
	 * @param detallesPropiedad El valor por establecer para detallesPropiedad
	 */
	public void setDetallesPropiedad(String detallesPropiedad) {
		this.detallesPropiedad = detallesPropiedad;
	}

	
	
	
	

}
