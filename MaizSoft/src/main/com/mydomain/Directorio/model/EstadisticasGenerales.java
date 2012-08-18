/**
 * 
 */
package com.mydomain.Directorio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.seam.annotations.Name;

/**
 * Descripcion: Esta Clase se encarga de ... Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 22/07/2012
 */
@Entity(name = "EstadisticasGenerales")
@Table(name = "estadisticas_generales")
@Name("estadisticasGenerales")
public class EstadisticasGenerales implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date fechaSuceso;

	private String login;

	private String accionElemento;

	private Long idGrupoCurso;
	
	private String tipo;
	
	private Long idOA;

	/**
	 * Se obtiene el valor de id
	 * 
	 * @return El valor de id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_estadisticas_generales", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getId() {
		return id;
	}

	/**
	 * Asigna el valor de id
	 * 
	 * @param id
	 *            El valor por establecer para id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Se obtiene el valor de fechaSuceso
	 * 
	 * @return El valor de fechaSuceso
	 */

	@Column(name = "fecha_suceso", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "datetime")
	public Date getFechaSuceso() {
		return fechaSuceso;
	}

	/**
	 * Asigna el valor de fechaSuceso
	 * 
	 * @param fechaSuceso
	 *            El valor por establecer para fechaSuceso
	 */
	public void setFechaSuceso(Date fechaSuceso) {
		this.fechaSuceso = fechaSuceso;
	}

	/**
	 * Se obtiene el valor de login
	 * 
	 * @return El valor de login
	 */
	@Column(name = "usuario_logueado", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(40)")
	public String getLogin() {
		return login;
	}

	/**
	 * Asigna el valor de login
	 * 
	 * @param login
	 *            El valor por establecer para login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Se obtiene el valor de accionElemento
	 * 
	 * @return El valor de accionElemento
	 */
	@Column(name = "accion_elemento", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(40)")
	public String getAccionElemento() {
		return accionElemento;
	}

	/**
	 * Asigna el valor de accionElemento
	 * 
	 * @param accionElemento
	 *            El valor por establecer para accionElemento
	 */
	public void setAccionElemento(String accionElemento) {
		this.accionElemento = accionElemento;
	}

	/**
	 * Se obtiene el valor de idGrupoCurso
	 * 
	 * @return El valor de idGrupoCurso
	 */
	@Column(name = "id_grupo_curso", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "numeric(19)")
	public Long getIdGrupoCurso() {
		return idGrupoCurso;
	}

	/**
	 * Asigna el valor de idGrupoCurso
	 * 
	 * @param idGrupoCurso
	 *            El valor por establecer para idGrupoCurso
	 */
	public void setIdGrupoCurso(Long idGrupoCurso) {
		this.idGrupoCurso = idGrupoCurso;
	}

	/**
	 * Se obtiene el valor de tipo
	 * @return El valor de tipo
	 */
	@Column(name = "tipo", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "varchar(60)")
	public String getTipo() {
		return tipo;
	}

	/**
	 * Asigna el valor de tipo
	 * @param tipo El valor por establecer para tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Se obtiene el valor de idOA
	 * @return El valor de idOA
	 */
	public Long getIdOA() {
		return idOA;
	}

	/**
	 * Asigna el valor de idOA
	 * @param idOA El valor por establecer para idOA
	 */
	public void setIdOA(Long idOA) {
		this.idOA = idOA;
	}
	
	
	
	

}
