/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

/**
 * @author Nicolas
 *
 */
@Entity
@Table(name="ente_universitario")
public class EnteUniversitario {
	
	private Long idEnteUniversitario;
	
	private  String nombreEnteUniversitario;
	
	private String descripcionEnteUniversitario;
		
	private EnteUniversitario enteUniversitario;
	
	private String codigoEnteUniversitario;
	
	private Set<EnteUniversitario> listaEnteUniversitarios;
	
	private Tipo tipoEnteUniversitario;
	
	private Set<Curso> listaCursosOfrecidos;
	
	private Set<Usuario> listaUserAccounts;

	/**
	 * @return the idEnteUniversitario
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdEnteUniversitario() {
		return idEnteUniversitario;
	}

	/**
	 * @param idEnteUniversitario the idEnteUniversitario to set
	 */
	public void setIdEnteUniversitario(Long idEnteUniversitario) {
		this.idEnteUniversitario = idEnteUniversitario;
	}

	/**
	 * @return the nombreEnteUniversitario
	 */
	@NotEmpty
	@Length(max=200)
	public String getNombreEnteUniversitario() {
		return nombreEnteUniversitario;
	}

	/**
	 * @param nombreEnteUniversitario the nombreEnteUniversitario to set
	 */
	public void setNombreEnteUniversitario(String nombreEnteUniversitario) {
		this.nombreEnteUniversitario = nombreEnteUniversitario;
	}

	/**
	 * @return the descripcionEnteUniversitario
	 */
	@Length(max=300)
	public String getDescripcionEnteUniversitario() {
		return descripcionEnteUniversitario;
	}

	/**
	 * @param descripcionEnteUniversitario the descripcionEnteUniversitario to set
	 */
	public void setDescripcionEnteUniversitario(String descripcionEnteUniversitario) {
		this.descripcionEnteUniversitario = descripcionEnteUniversitario;
	}
	
	
	

	/**
	 * @return the codigoEnteUniversitario
	 */
	public String getCodigoEnteUniversitario() {
		return codigoEnteUniversitario;
	}

	/**
	 * @param codigoEnteUniversitario the codigoEnteUniversitario to set
	 */
	public void setCodigoEnteUniversitario(String codigoEnteUniversitario) {
		this.codigoEnteUniversitario = codigoEnteUniversitario;
	}

	/**
	 * @return the enteUniversitario
	 */
	
	@ManyToOne
	public EnteUniversitario getEnteUniversitario() {
		return enteUniversitario;
	}

	/**
	 * @param enteUniversitario the enteUniversitario to set
	 */
	public void setEnteUniversitario(EnteUniversitario enteUniversitario) {
		this.enteUniversitario = enteUniversitario;
	}

	/**
	 * @return the listaEnteUniversitarios
	 */
	@OneToMany(mappedBy="enteUniversitario", cascade=CascadeType.ALL)
	public Set<EnteUniversitario> getListaEnteUniversitarios() {
		if(listaEnteUniversitarios==null)
			return new HashSet<EnteUniversitario>();
		return listaEnteUniversitarios;
	}

	/**
	 * @param listaEnteUniversitarios the listaEnteUniversitarios to set
	 */
	public void setListaEnteUniversitarios(
			Set<EnteUniversitario> listaEnteUniversitarios) {
		this.listaEnteUniversitarios = listaEnteUniversitarios;
	}

	/**
	 * @return the tipoEnteUniversitario
	 */
	@NotNull
	@ManyToOne
	public Tipo getTipoEnteUniversitario() {
		return tipoEnteUniversitario;
	}

	/**
	 * @param tipoEnteUniversitario the tipoEnteUniversitario to set
	 */
	public void setTipoEnteUniversitario(Tipo tipoEnteUniversitario) {
		this.tipoEnteUniversitario = tipoEnteUniversitario;
	}
	
	/**
	 * @return the facultad
	 */
	

	/**
	 * @return the listaCursosOfrecidos
	 */
	@OneToMany(mappedBy="enteUniversitario",cascade=CascadeType.ALL)
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

	/**
	 * @return the listaUserAccounts
	 */
	@OneToMany(mappedBy="enteUniversitarios",cascade=CascadeType.ALL)
	public Set<Usuario> getListaUserAccounts() {
		if(listaUserAccounts==null){
			return new HashSet<Usuario>();
		}
		return listaUserAccounts;
	}

	/**
	 * @param listaUserAccounts the listaUserAccounts to set
	 */
	public void setListaUserAccounts(Set<Usuario> listaUserAccounts) {
		
		this.listaUserAccounts = listaUserAccounts;
	}
	
	
	
	
}
