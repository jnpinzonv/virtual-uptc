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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;


/**
* Descripcion: Esta Clase se encarga de gestionar el almacenamiento de datos, 
* en esta clase con lo referente a los entes universitarios, se comunica con la base de datos
* Modulo de Desarrollo :CU- ...
* @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity(name="ente_universitario")
@Table(name="ente_universitario")
@NamedQuery(name="entesUniversitariosPorFacultad",query="select t from EnteUniversitario t where t.enteUniversitario.idEnteUniversitario=:parametro")
public class EnteUniversitario {
	
	/**
	 * Variable que almacena el identificador del ente universitario
	 * Tipo de dato Long
	 */
	private Long idEnteUniversitario;
	
	/**
	 * Variable que almacena el nombre del ente universitario
	 * Tipo de dato String 
	 */
	private  String nombreEnteUniversitario;
	
	/**
	 * Variable que almacena la descripción del ente universitario
	 * Tipo de dato String
	 */
	private String descripcionEnteUniversitario;
		
	/**
	 * Variable que almacena el ente universitario
	 * Se instanica de la clase EnteUniversitario
	 */
	private EnteUniversitario enteUniversitario;
	
	/**
	 * Variable que almacena el código del ente universitario
	 * Tipo de dato String
	 */
	private String codigoEnteUniversitario;
	
	/**
	 * Variable que almacena el listado de entes universitarios
	 * Se instancia de la clase EnteUniversitario
	 */
	private Set<EnteUniversitario> listaEnteUniversitarios;
	
	/**
	 * Variable que almacena el tipo de ente universitario
	 * Se instancia de la clase Tipo
	 */
	private Tipo tipoEnteUniversitario;
	
	/**
	 * Variable que almacena la lista de cursos ofrecidos
	 * Se instancia de la clase Curso
	 */
	private Set<Curso> listaCursosOfrecidos;
	
	/**
	 * Variable que almacena la lista de cuentas de usuarios 
	 * Se instancia de la clase Usuario
	 */
	private Set<Usuario> listaUserAccounts;

	/**
	 * Se obtiene el valor de idEnteUniversitario
	 * @return El valor de idEnteUniversitario
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_ente_universitario_padre", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getIdEnteUniversitario() {
		return idEnteUniversitario;
	}

	/**
	 * Asigna el valor de idEnteUniversitario
	 * @param idEnteUniversitario El valor por establecer para idEnteUniversitario
	 */
	public void setIdEnteUniversitario(Long idEnteUniversitario) {
		this.idEnteUniversitario = idEnteUniversitario;
	}

	/**
	 * Se obtiene el valor de nombreEnteUniversitario
	 * @return El valor de nombreEnteUniversitario
	 */
	@NotEmpty
	@Length(max=200)
	@Column(name = "nombre_ente_universitario", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(200)")
	public String getNombreEnteUniversitario() {
		return nombreEnteUniversitario;
	}

	/**
	 * Asigna el valor de nombreEnteUniversitario
	 * @param nombreEnteUniversitario El valor por establecer para nombreEnteUniversitario
	 */
	public void setNombreEnteUniversitario(String nombreEnteUniversitario) {
		this.nombreEnteUniversitario = nombreEnteUniversitario;
	}

	/**
	 * Se obtiene el valor de descripcionEnteUniversitario
	 * @return El valor de descripcionEnteUniversitario
	 */
	@Length(max=300)
	@Column(name = "descripcion_ente_universitario", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(200)")
	public String getDescripcionEnteUniversitario() {
		return descripcionEnteUniversitario;
	}

	/**
	 * Asigna el valor de descripcionEnteUniversitario
	 * @param descripcionEnteUniversitario El valor por establecer para descripcionEnteUniversitario
	 */
	public void setDescripcionEnteUniversitario(String descripcionEnteUniversitario) {
		this.descripcionEnteUniversitario = descripcionEnteUniversitario;
	}

	/**
	 * Se obtiene el valor de enteUniversitario
	 * @return El valor de enteUniversitario
	 */
	@ManyToOne
	@JoinColumn(name = "id_ente_universitario", unique = false, nullable = false, insertable = true, updatable = true)
	public EnteUniversitario getEnteUniversitario() {
		return enteUniversitario;
	}

	/**
	 * Asigna el valor de enteUniversitario
	 * @param enteUniversitario El valor por establecer para enteUniversitario
	 */
	public void setEnteUniversitario(EnteUniversitario enteUniversitario) {
		this.enteUniversitario = enteUniversitario;
	}

	/**
	 * Se obtiene el valor de codigoEnteUniversitario
	 * @return El valor de codigoEnteUniversitario
	 */
	@Column(name = "codigo_ente_universitario", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(20)")
	public String getCodigoEnteUniversitario() {
		return codigoEnteUniversitario;
	}

	/**
	 * Asigna el valor de codigoEnteUniversitario
	 * @param codigoEnteUniversitario El valor por establecer para codigoEnteUniversitario
	 */
	public void setCodigoEnteUniversitario(String codigoEnteUniversitario) {
		this.codigoEnteUniversitario = codigoEnteUniversitario;
	}

	/**
	 * Se obtiene el valor de listaEnteUniversitarios
	 * @return El valor de listaEnteUniversitarios
	 */
	@OneToMany(mappedBy="enteUniversitario", cascade=CascadeType.ALL)
	public Set<EnteUniversitario> getListaEnteUniversitarios() {
		return listaEnteUniversitarios;
	}

	/**
	 * Asigna el valor de listaEnteUniversitarios
	 * @param listaEnteUniversitarios El valor por establecer para listaEnteUniversitarios
	 */
	public void setListaEnteUniversitarios(
			Set<EnteUniversitario> listaEnteUniversitarios) {
		this.listaEnteUniversitarios = listaEnteUniversitarios;
	}

	/**
	 * Se obtiene el valor de tipoEnteUniversitario
	 * @return El valor de tipoEnteUniversitario
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_tipo_ente_universitario", unique = false, nullable = false, insertable = true, updatable = true)
	public Tipo getTipoEnteUniversitario() {
		return tipoEnteUniversitario;
	}

	/**
	 * Asigna el valor de tipoEnteUniversitario
	 * @param tipoEnteUniversitario El valor por establecer para tipoEnteUniversitario
	 */
	public void setTipoEnteUniversitario(Tipo tipoEnteUniversitario) {
		this.tipoEnteUniversitario = tipoEnteUniversitario;
	}

	/**
	 * Se obtiene el valor de listaCursosOfrecidos
	 * @return El valor de listaCursosOfrecidos
	 */
	@OneToMany(mappedBy="enteUniversitario",cascade=CascadeType.ALL)
	public Set<Curso> getListaCursosOfrecidos() {
		return listaCursosOfrecidos;
	}

	/**
	 * Asigna el valor de listaCursosOfrecidos
	 * @param listaCursosOfrecidos El valor por establecer para listaCursosOfrecidos
	 */
	public void setListaCursosOfrecidos(Set<Curso> listaCursosOfrecidos) {
		this.listaCursosOfrecidos = listaCursosOfrecidos;
	}

	/**
	 * Se obtiene el valor de listaUserAccounts
	 * @return El valor de listaUserAccounts
	 */

	@OneToMany(mappedBy="enteUniversitarios",cascade=CascadeType.ALL)
	public Set<Usuario> getListaUserAccounts() {
		return listaUserAccounts;
	}

	/**
	 * Asigna el valor de listaUserAccounts
	 * @param listaUserAccounts El valor por establecer para listaUserAccounts
	 */
	public void setListaUserAccounts(Set<Usuario> listaUserAccounts) {
		this.listaUserAccounts = listaUserAccounts;
	}

}
