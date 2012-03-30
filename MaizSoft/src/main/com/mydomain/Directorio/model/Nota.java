/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Nicolas
 *
 */
@Entity
@Table(name="nota")
public class Nota {
	
	private Long idNota;
	
	private Long porcentaje;
	
	private Long valorNota;
	
	private Actividad actividad;

	/**
	 * @return the idNota
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdNota() {
		return idNota;
	}

	/**
	 * @param idNota the idNota to set
	 */
	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}

	/**
	 * @return the porcentaje
	 */
	@Column(name="porcentaje")
	public Long getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(Long porcentaje) {
		this.porcentaje = porcentaje;
	}

	/**
	 * @return the valorNota
	 */
	@Column(name="valor_nota")
	public Long getValorNota() {
		return valorNota;
	}

	/**
	 * @param valorNota the valorNota to set
	 */
	public void setValorNota(Long valorNota) {
		this.valorNota = valorNota;
	}

	/**
	 * @return the actividad
	 */
	@OneToOne
	public Actividad getActividad() {
		return actividad;
	}

	/**
	 * @param actividad the actividad to set
	 */
	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	
	
	

}
