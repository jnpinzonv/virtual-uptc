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
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
* Descripcion: Esta Clase se encarga de gestionar el almacenamiento de datos, 
* en esta clase lo referente a las cuentas de usuario, se comunica con la base de datos
* Modulo de Desarrollo :CU- ...
* @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity
@Table(name="cuentas_usuario")
@NamedQuery(name = "buscarCuentaporUsername", query = "select s from CuentasUsuario s where s.userAccounts.username=:parametro")
public class CuentasUsuario {
	
	/**
	 * Variable la cual almacena el identificador de la cuenta
	 * Tipo de dato Long
	 */
	private Long id;
	
	/**
	 * Variable la cual almacena la cuenta del Usuario 
	 * Se instancia de la clase UserAccount
	 */
	private UserAccount userAccounts;
	
	/**
	 * Variable la cual es encargada de almacenar los usuarios
	 * Se instancia de la clase Usuario 
	 */
	private Usuario usuarios;
	
	/**
	 * Variable la cual almacena los grupos de usuarios
	 * Se instancia de la clase GrupoUsuarios
	 */
	private GrupoUsuarios grupoUsuarios;

	/**
	 * Se obtiene el valor de id
	 * @return El valor de id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(20)")
	public Long getId() {
		return id;
	}

	/**
	 * Asigna el valor de id
	 * @param id El valor por establecer para id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Se obtiene el valor de userAccounts
	 * @return El valor de userAccounts
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "usser_account", unique = false, nullable = false, insertable = true, updatable = true)
	public UserAccount getUserAccounts() {
		return userAccounts;
	}

	/**
	 * Asigna el valor de userAccounts
	 * @param userAccounts El valor por establecer para userAccounts
	 */
	public void setUserAccounts(UserAccount userAccounts) {
		this.userAccounts = userAccounts;
	}

	/**
	 * Se obtiene el valor de usuarios
	 * @return El valor de usuarios
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "tipo", unique = false, nullable = false, insertable = true, updatable = true)
	public Usuario getUsuarios() {
		return usuarios;
	}

	/**
	 * Asigna el valor de usuarios
	 * @param usuarios El valor por establecer para usuarios
	 */
	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * Se obtiene el valor de grupoUsuarios
	 * @return El valor de grupoUsuarios
	 */
	@OneToOne
	@JoinColumn(name = "grupo_usuarios", unique = false, nullable = false, insertable = true, updatable = true)
	public GrupoUsuarios getGrupoUsuarios() {
		return grupoUsuarios;
	}

	/**
	 * Asigna el valor de grupoUsuarios
	 * @param grupoUsuarios El valor por establecer para grupoUsuarios
	 */
	public void setGrupoUsuarios(GrupoUsuarios grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

}
