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
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;

/**
* Descripcion: Esta Clase se encarga de almacenar información
* relacionada con los diferentes tipos de actividades.
* Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity
@Table(name="tipo",uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Tipo {
	
	/**
	 * Variable encargada de almacenar el identificador
	 * del tipo de actividad.
	 */
	private Long idTipo;
	
	/**
	 * Variable encargada de guardar el nombre del
	 * tipo de actividad.
	 */
	private String nombre;
	
	/**
	 * Variable encargada de guardar la descripción del
	 * tipo de actividad.
	 */
	private String descripcion;
	
	/**
	 * Variable encargada de guardar información del
	 * tipo de actividad.
	 * Instancia de la clase Tipo 
	 */
	private Tipo tipo;
	
	/**
	 * Variable encargada de guardar la lista de los
	 * diferentes tipos de actividades.
	 */
	private Set<Tipo> listaTipo;
	
	/**
	 *Variable encargada de guardar la lista de los
	 * diferentes entes universitarios. 
	 */
	private Set<EnteUniversitario> enteUniversitarios;
	
	/**
	 * Variable encargada de almacenar la el conjunto de
	 * actividades establecidas.
	 */
	private Set<Actividad> actividad;
	
	/**
	 * Variable encargada de listar la información referente
	 * a la mensajería.
	 */
	private Set<GestorMensajeria> listaGestorMensajeria;
	
	/**
	 * Variable encargada de listar la información referente
	 * a los repositorios virtuales. 
	 */
	private Set<GestorRepositoriosVirtuales> gestorRepositoriosVirtuales;
	
	/**
	 *  Variable encargada de listar la información referente
	 * a los diferentes usuarios.
	 */
	private Set<Usuario> userAccount;

	/**
	 *  Variable encargada de listar la información referente
	 * a cargar archivos al curso.
	 */
	private Set<GestorCargaArchivos> gestorCargaArchivos;
	
	/**
	 * Se obtiene el valor de idTipo
	 * @return El valor de idTipo
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_tipo", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "numeric(8)")
	public Long getIdTipo() {
		return idTipo;
	}

	/**
	 * Asigna el valor de idTipo
	 * @param idTipo El valor por establecer para idTipo
	 */
	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}
	
	/**
	 * Se obtiene el valor de nombre
	 * @return El valor de nombre
	 */
	@NotEmpty
	@Column(name = "id_nombre", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(20)")
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
	 * Se obtiene el valor de descripcion
	 * @return El valor de descripcion
	 */
	@Length(max=300)
	@Column(name = "id_descripcion", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(100)")
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
	 * Se obtiene el valor de listaTipo
	 * @return El valor de listaTipo
	 */
	@OneToMany(mappedBy="tipo",cascade=CascadeType.ALL)
	@JoinColumn(name = "id_lista_tipo", unique = false, nullable = false, insertable = true, updatable = true)
	public Set<Tipo> getListaTipo() {
		if(listaTipo==null){
			return new HashSet<Tipo>();
		}
		return listaTipo;
	}

	/**
	 * Asigna el valor de listaTipo
	 * @param listaTipo El valor por establecer para listaTipo
	 */
	public void setListaTipo(Set<Tipo> listaTipo) {
		this.listaTipo = listaTipo;
	}
	
	/**
	 * Se obtiene el valor de enteUniversitarios
	 * @return El valor de enteUniversitarios
	 */
	@OneToMany(mappedBy="tipoEnteUniversitario",cascade=CascadeType.ALL)
	@JoinColumn(name = "id_tipo", unique = false, nullable = false, insertable = true, updatable = true)
	public Set<EnteUniversitario> getEnteUniversitarios() {
		return enteUniversitarios;
	}

	/**
	 * Asigna el valor de enteUniversitarios
	 * @param enteUniversitarios El valor por establecer para enteUniversitarios
	 */
	public void setEnteUniversitarios(Set<EnteUniversitario> enteUniversitarios) {
		this.enteUniversitarios = enteUniversitarios;
	}
	
	/**
	 * Se obtiene el valor de listaGestorMensajeria
	 * @return El valor de listaGestorMensajeria
	 */
	@OneToMany(mappedBy="tipo",cascade=CascadeType.ALL)
	@JoinColumn(name = "id_gestor_Mensajeria", unique = false, nullable = false, insertable = true, updatable = true)
	public Set<GestorMensajeria> getListaGestorMensajeria() {
		if(listaGestorMensajeria==null){
			return new HashSet<GestorMensajeria>();
		}
		return listaGestorMensajeria;
	}

	/**
	 * Asigna el valor de listaGestorMensajeria
	 * @param listaGestorMensajeria El valor por establecer para listaGestorMensajeria
	 */
	public void setListaGestorMensajeria(Set<GestorMensajeria> listaGestorMensajeria) {
		this.listaGestorMensajeria = listaGestorMensajeria;
	}

	/**
	 * Se obtiene el valor de gestorRepositoriosVirtuales
	 * @return El valor de gestorRepositoriosVirtuales
	 */
	@OneToMany(mappedBy="tipos",cascade=CascadeType.ALL)
	@JoinColumn(name = "id_repositorios_virtuales", unique = false, nullable = false, insertable = true, updatable = true)

	public Set<GestorRepositoriosVirtuales> getGestorRepositoriosVirtuales() {
		if(gestorRepositoriosVirtuales==null){
			return new HashSet<GestorRepositoriosVirtuales>();
		}
		return gestorRepositoriosVirtuales;
	}

	/**
	 * Asigna el valor de gestorRepositoriosVirtuales
	 * @param gestorRepositoriosVirtuales El valor por establecer para gestorRepositoriosVirtuales
	 */
	public void setGestorRepositoriosVirtuales(
			Set<GestorRepositoriosVirtuales> gestorRepositoriosVirtuales) {
		this.gestorRepositoriosVirtuales = gestorRepositoriosVirtuales;
	}

	/**
	 * Se obtiene el valor de userAccount
	 * @return El valor de userAccount
	 */
	@OneToMany(mappedBy="tipo",cascade=CascadeType.ALL)
	@JoinColumn(name = "id_user_Account", unique = false, nullable = false, insertable = true, updatable = true)
	public Set<Usuario> getUserAccount() {
		if(userAccount==null){
			return new HashSet<Usuario>();
		}
		return userAccount;
	}

	/**
	 * Asigna el valor de userAccount
	 * @param userAccount El valor por establecer para userAccount
	 */
	public void setUserAccount(Set<Usuario> userAccount) {
		this.userAccount = userAccount;
	}

	/**
	 * Se obtiene el valor de gestorCargaArchivos
	 * @return El valor de gestorCargaArchivos
	 */
	@OneToMany(mappedBy="tipo",cascade=CascadeType.ALL)
	@JoinColumn(name = "id_gestor_Carga_Archivos", unique = false, nullable = false, insertable = true, updatable = true)
	public Set<GestorCargaArchivos> getGestorCargaArchivos() {
		if(gestorCargaArchivos==null){
			return new HashSet<GestorCargaArchivos>();
		}
		return gestorCargaArchivos;
	}

	/**
	 * Asigna el valor de gestorCargaArchivos
	 * @param gestorCargaArchivos El valor por establecer para gestorCargaArchivos
	 */
	public void setGestorCargaArchivos(Set<GestorCargaArchivos> gestorCargaArchivos) {
		this.gestorCargaArchivos = gestorCargaArchivos;
	}

	/**
	 * Se obtiene el valor de actividad
	 * @return El valor de actividad
	 */
	@OneToMany(mappedBy="tipo",cascade=CascadeType.ALL)
	@JoinColumn(name = "id_actividad", unique = false, nullable = false, insertable = true, updatable = true)
	public Set<Actividad> getActividad() {
		if(actividad==null){
			return new HashSet<Actividad>();
		}
		return actividad;
	}

	/**
	 * Asigna el valor de actividad
	 * @param actividad El valor por establecer para actividad
	 */
	public void setActividad(Set<Actividad> actividad) {
		this.actividad = actividad;
	}
		
}
