/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.validator.NotEmpty;
import org.jboss.seam.annotations.Name;


/**
* Descripcion: Esta Clase se encarga de gestionar el almacenamiento de datos, 
* en esta clase con lo referente al gestor de noticias, se comunica con la base de datos
* Modulo de Desarrollo :CU- ...
* @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity(name="GestorNoticias")
@Table(name="gestor_noticias")
@Name("gestorNoticias")
public class GestorNoticias {
	
	/**
	 * Variable que almacena el identificador de la noticia
	 * Tipo de Dato Long
	 */
	private Long idNoticia;
	
	/**
	 * Variable que almacena el nombre de la noticia
	 * Tipo de Dato String
	 */
	private String nombreNoticia;
	
	/**
	 * Variable que almacena la descripcion de la noticia
	 * Tipo de Dato String
	 */
	private String descripcion;

	/**
	 * Se obtiene el valor de idNoticia
	 * @return El valor de idNoticia
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name = "id_noticia", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getIdNoticia() {
		return idNoticia;
	}

	/**
	 * Asigna el valor de idNoticia
	 * @param idNoticia El valor por establecer para idNoticia
	 */
	public void setIdNoticia(Long idNoticia) {
		this.idNoticia = idNoticia;
	}

	/**
	 * Se obtiene el valor de nombreNoticia
	 * @return El valor de nombreNoticia
	 */
	@NotEmpty
	@Column(name = "nombre_noticia", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(30)")
	public String getNombreNoticia() {
		return nombreNoticia;
	}

	/**
	 * Asigna el valor de nombreNoticia
	 * @param nombreNoticia El valor por establecer para nombreNoticia
	 */
	public void setNombreNoticia(String nombreNoticia) {
		this.nombreNoticia = nombreNoticia;
	}

	/**
	 * Se obtiene el valor de descripcion
	 * @return El valor de descripcion
	 */

	@NotEmpty
	@Column(name = "descripcion_noticia", unique = false, nullable = false, insertable = true, updatable = true)
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

}
