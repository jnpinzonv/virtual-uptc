/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version 3/04/2012
 */
@Entity
@Table(name="gestor_Agenda")
public class GestorAgenda {

	private Long idAgenda;
	
	private String agendaDescripcion;
	
	private Date fechaEvento;
	
	private Long horaEvento;
	
	private UserAccount userAccountAgenda;

	/**
	 * @return the idAgenda
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	public Long getIdAgenda() {
		return idAgenda;
	}

	/**
	 * @param idAgenda the idAgenda to set
	 */
	public void setIdAgenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}

	/**
	 * @return the agendaDescripcion
	 */
	@NotNull
	@Column(name= "agenda_descripcion")
	public String getAgendaDescripcion() {
		return agendaDescripcion;
	}

	/**
	 * @param agendaDescripcion the agendaDescripcion to set
	 */
	public void setAgendaDescripcion(String agendaDescripcion) {
		this.agendaDescripcion = agendaDescripcion;
	}

	/**
	 * @return the fechaEvento
	 */
	@NotNull
	@Column(name= "fecha_evento")
	public Date getFechaEvento() {
		return fechaEvento;
	}

	/**
	 * @param fechaEvento the fechaEvento to set
	 */
	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	/**
	 * @return the horaEvento
	 */
	@NotNull
	@Column(name= "hora_evento")
	public Long getHoraEvento() {
		return horaEvento;
	}

	/**
	 * @param horaEvento the horaEvento to set
	 */
	public void setHoraEvento(Long horaEvento) {
		this.horaEvento = horaEvento;
	}

	/**
	 * @return the userAccountAgenda
	 */
	@NotNull
	@ManyToOne
	public UserAccount getUserAccountAgenda() {
		return userAccountAgenda;
	}

	/**
	 * @param userAccountAgenda the userAccountAgenda to set
	 */
	public void setUserAccountAgenda(UserAccount userAccountAgenda) {
		this.userAccountAgenda = userAccountAgenda;
	}
	
	
	
	
}
