package com.mydomain.Directorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

/**
* Descripcion: Esta Clase se encarga de guardar infomaci�n sobre los
* receptores de los mensajes enviados y porteriormente recibidos.
* Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity(name="ReceptorMensajes")
@Table(name="receptor_mensajes")
@Name("receptorMensajes")
public class ReceptorMensajes {
	
	/**
	 * Variable encargada de almacenar el identificador del
	 * receptor de determinado mensaje.
	 */
	private Long idReceptormenajes;
	
	/**
	 * Variable en cargada de almacenar informaci�n con respecto
	 * a los usuarios del curso.
	 * Instancia de la clase Usuario.
	 */
	private Usuario userAccount;
	
	
	private boolean leido;
	/**
	 * Variable encargada de guardar informaci�n con respecto
	 * al env�o de mensajes en la plataformfa.
	 */
	private GestorMensajeria gestorMensajeria;
	
	/**
	 * Se obtiene el valor de idReceptormenajes
	 * @return El valor de idReceptormenajes
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_receptor_mensajes", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getIdReceptormenajes() {
		return idReceptormenajes;
	}
	/**
	 * Asigna el valor de idReceptormenajes
	 * @param idReceptormenajes El valor por establecer para idReceptormenajes
	 */
	public void setIdReceptormenajes(Long idReceptormenajes) {
		this.idReceptormenajes = idReceptormenajes;
	}
	
	/**
	 * Se obtiene el valor de userAccount
	 * @return El valor de userAccount
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_usuario", unique = false, nullable = false, insertable = true, updatable = true)
	public Usuario getUserAccount() {
		return userAccount;
	}
	/**
	 * Asigna el valor de userAccount
	 * @param userAccount El valor por establecer para userAccount
	 */
	public void setUserAccount(Usuario userAccount) {
		this.userAccount = userAccount;
	}
	
	/**
	 * Se obtiene el valor de gestorMensajeria
	 * @return El valor de gestorMensajeria
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_gestor_mensajeria", unique = false, nullable = false, insertable = true, updatable = true)
	public GestorMensajeria getGestorMensajeria() {
		return gestorMensajeria;
	}
	/**
	 * Asigna el valor de gestorMensajeria
	 * @param gestorMensajeria El valor por establecer para gestorMensajeria
	 */
	public void setGestorMensajeria(GestorMensajeria gestorMensajeria) {
		this.gestorMensajeria = gestorMensajeria;
	}
	
	/**
	 * Se obtiene el valor de leido
	 * @return El valor de leido
	 */
	@Column(name = "leido", unique = false, nullable = false, insertable = true, updatable = true)
	public boolean isLeido() {
		return leido;
	}
	
	/**
	 * Asigna el valor de leido
	 * @param leido El valor por establecer para leido
	 */
	public void setLeido(boolean leido) {
		this.leido = leido;
	}
}
