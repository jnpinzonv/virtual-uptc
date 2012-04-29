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
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name="tipo",uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Tipo {
	
	private Long idTipo;
	
	private String nombre;
	
	private String descripcion;
	
	private Tipo tipo;
	
	private Set<Tipo> listaTipo;
	
	private Set<EnteUniversitario> enteUniversitarios;
	
	private Set<Actividad> actividad;
	
	private Set<GestorMensajeria> listaGestorMensajeria;
	
	private Set<GestorRepositoriosVirtuales> gestorRepositoriosVirtuales;
	
	private Set<UserAccount> userAccount;

	private Set<GestorCargaArchivos> gestorCargaArchivos;
	/**
	 * @return the idTipo
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdTipo() {
		return idTipo;
	}

	/**
	 * @param idTipo the idTipo to set
	 */
	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}

	/**
	 * @return the nombre
	 */
	@NotEmpty
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
	 * @return the tipo
	 */
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
	 * @return the listaTipo
	 */
	@OneToMany(mappedBy="tipo",cascade=CascadeType.ALL)
	public Set<Tipo> getListaTipo() {
		if(listaTipo==null){
			return new HashSet<Tipo>();
		}
		return listaTipo;
	}

	/**
	 * @param listaTipo the listaTipo to set
	 */
	public void setListaTipo(Set<Tipo> listaTipo) {
		this.listaTipo = listaTipo;
	}

	/**
	 * @return the enteUniversitarios
	 */
	@OneToMany(mappedBy="tipoEnteUniversitario",cascade=CascadeType.ALL)
	public Set<EnteUniversitario> getEnteUniversitarios() {
		return enteUniversitarios;
	}

	/**
	 * @param enteUniversitarios the enteUniversitarios to set
	 */
	public void setEnteUniversitarios(Set<EnteUniversitario> enteUniversitarios) {
		this.enteUniversitarios = enteUniversitarios;
	}

	
	/**
	 * @return the listaGestorMensajeria
	 */
	@OneToMany(mappedBy="tipo",cascade=CascadeType.ALL)
	public Set<GestorMensajeria> getListaGestorMensajeria() {
		if(listaGestorMensajeria==null){
			return new HashSet<GestorMensajeria>();
		}
		return listaGestorMensajeria;
	}

	/**
	 * @param listaGestorMensajeria the listaGestorMensajeria to set
	 */
	public void setListaGestorMensajeria(Set<GestorMensajeria> listaGestorMensajeria) {
		this.listaGestorMensajeria = listaGestorMensajeria;
	}

	/**
	 * @return the gestorRepositoriosVirtuales
	 */
	@OneToMany(mappedBy="tipos",cascade=CascadeType.ALL)
	public Set<GestorRepositoriosVirtuales> getGestorRepositoriosVirtuales() {
		if(gestorRepositoriosVirtuales==null){
			return new HashSet<GestorRepositoriosVirtuales>();
		}
		return gestorRepositoriosVirtuales;
	}

	/**
	 * @param gestorRepositoriosVirtuales the gestorRepositoriosVirtuales to set
	 */
	public void setGestorRepositoriosVirtuales(
			Set<GestorRepositoriosVirtuales> gestorRepositoriosVirtuales) {
		this.gestorRepositoriosVirtuales = gestorRepositoriosVirtuales;
	}

	/**
	 * @return the userAccount
	 */
	@OneToMany(mappedBy="tipo",cascade=CascadeType.ALL)
	public Set<UserAccount> getUserAccount() {
		if(userAccount==null){
			return new HashSet<UserAccount>();
		}
		return userAccount;
	}

	/**
	 * @param userAccount the userAccount to set
	 */
	public void setUserAccount(Set<UserAccount> userAccount) {
		this.userAccount = userAccount;
	}

	/**
	 * @return the gestorCargaArchivos
	 */
	@OneToMany(mappedBy="tipo",cascade=CascadeType.ALL)
	public Set<GestorCargaArchivos> getGestorCargaArchivos() {
		if(gestorCargaArchivos==null){
			return new HashSet<GestorCargaArchivos>();
		}
		return gestorCargaArchivos;
	}

	/**
	 * @param gestorCargaArchivos the gestorCargaArchivos to set
	 */
	public void setGestorCargaArchivos(Set<GestorCargaArchivos> gestorCargaArchivos) {
		this.gestorCargaArchivos = gestorCargaArchivos;
	}

	/**
	 * @return the actividad
	 */
	@OneToMany(mappedBy="tipo",cascade=CascadeType.ALL)
	public Set<Actividad> getActividad() {
		if(actividad==null){
			return new HashSet<Actividad>();
		}
		return actividad;
	}

	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(Set<Actividad> actividad) {
		this.actividad = actividad;
	}

	
	
}
