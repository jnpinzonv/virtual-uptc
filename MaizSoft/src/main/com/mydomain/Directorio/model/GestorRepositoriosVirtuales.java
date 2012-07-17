/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

/**
 * Descripcion: Esta Clase se encarga de gestionar el almacenamiento de datos,
 * en esta clase con lo referente al gestor de repositorios virtuales, se
 * comunica con la base de datos Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 23/06/2012
 */
@Entity(name = "GestorRepositoriosVirtuales")
@Table(name = "gestor_repositorios_virtuales")
@Name("gestorRepositoriosVirtuales")
public class GestorRepositoriosVirtuales {

	/**
	 * Variable que se encarga de crear un identificador de un repositorio, Tipo
	 * de Dato Long
	 */
	private Long idRepositorio;

	/**
	 * Variable que se encarga de almacenar la url del repositorio, Tipo de Dato
	 * String
	 */
	private String urlRepositorio;

	/**
	 * Variable que se encarga de almacenar el nombre del repositorio Tipo de
	 * Dato String
	 */
	private String nombreRepositorio;

	/**
	 * Variable que se encarga de almacenar la descripción del repositorio Tipo
	 * de Dato String
	 */
	private String descripcionRepositorio;

	/**
	 * Variable que se encarga de almacenar el nombre de usuario del repositorio
	 * Tipo de Dato String
	 */
	private String usernameRepositorio;

	/**
	 * Variable que se encarga de almacenar la contraseña del repositorio Tipo
	 * de Dato String
	 */
	private String passwordRepositorio;

	/**
	 * Variable que se encarga de almacenar los tipos de repositorio Se
	 * instancia de la clase Tipo
	 */

	private Tipo tipos;

	/**
	 * Se obtiene el valor de idRepositorio
	 * 
	 * @return El valor de idRepositorio
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_repositorio", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getIdRepositorio() {
		return idRepositorio;
	}

	/**
	 * Asigna el valor de idRepositorio
	 * 
	 * @param idRepositorio
	 *            El valor por establecer para idRepositorio
	 */
	public void setIdRepositorio(Long idRepositorio) {
		this.idRepositorio = idRepositorio;
	}

	/**
	 * Se obtiene el valor de urlRepositorio
	 * 
	 * @return El valor de urlRepositorio
	 */
	@NotEmpty
	@Column(name = "url_repositorio", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(300)")
	public String getUrlRepositorio() {
		return urlRepositorio;
	}

	/**
	 * Asigna el valor de urlRepositorio
	 * 
	 * @param urlRepositorio
	 *            El valor por establecer para urlRepositorio
	 */
	public void setUrlRepositorio(String urlRepositorio) {
		this.urlRepositorio = urlRepositorio;
	}

	/**
	 * Se obtiene el valor de nombreRepositorio
	 * 
	 * @return El valor de nombreRepositorio
	 */
	@NotEmpty
	@Length(max = 100)
	@Column(name = "nombre_repositorio", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(30)")
	public String getNombreRepositorio() {
		return nombreRepositorio;
	}

	/**
	 * Asigna el valor de nombreRepositorio
	 * 
	 * @param nombreRepositorio
	 *            El valor por establecer para nombreRepositorio
	 */
	public void setNombreRepositorio(String nombreRepositorio) {
		this.nombreRepositorio = nombreRepositorio;
	}

	/**
	 * Se obtiene el valor de descripcionRepositorio
	 * 
	 * @return El valor de descripcionRepositorio
	 */
	@Length(max = 300)
	@Column(name = "descripcion_repositorio", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "varchar(300)")
	public String getDescripcionRepositorio() {
		return descripcionRepositorio;
	}

	/**
	 * Asigna el valor de descripcionRepositorio
	 * 
	 * @param descripcionRepositorio
	 *            El valor por establecer para descripcionRepositorio
	 */
	public void setDescripcionRepositorio(String descripcionRepositorio) {
		this.descripcionRepositorio = descripcionRepositorio;
	}

	/**
	 * Se obtiene el valor de usernameRepositorio
	 * 
	 * @return El valor de usernameRepositorio
	 */
	@Length(max = 30)
	@Column(name = "username_repositorio", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "varchar(20)")
	public String getUsernameRepositorio() {
		return usernameRepositorio;
	}

	/**
	 * Asigna el valor de usernameRepositorio
	 * 
	 * @param usernameRepositorio
	 *            El valor por establecer para usernameRepositorio
	 */
	public void setUsernameRepositorio(String usernameRepositorio) {
		this.usernameRepositorio = usernameRepositorio;
	}

	/**
	 * Se obtiene el valor de passwordRepositorio
	 * 
	 * @return El valor de passwordRepositorio
	 */
	@Length(max = 30)
	@Column(name = "password_repositorio", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "varchar(20)")
	public String getPasswordRepositorio() {
		return passwordRepositorio;
	}

	/**
	 * Asigna el valor de passwordRepositorio
	 * 
	 * @param passwordRepositorio
	 *            El valor por establecer para passwordRepositorio
	 */
	public void setPasswordRepositorio(String passwordRepositorio) {
		this.passwordRepositorio = passwordRepositorio;
	}

	/**
	 * Se obtiene el valor de tipos
	 * 
	 * @return El valor de tipos
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_tipo", unique = false, nullable = false, insertable = true, updatable = true)
	public Tipo getTipos() {
		return tipos;
	}

	/**
	 * Asigna el valor de tipos
	 * 
	 * @param tipos
	 *            El valor por establecer para tipos
	 */
	public void setTipos(Tipo tipos) {
		this.tipos = tipos;
	}

}
