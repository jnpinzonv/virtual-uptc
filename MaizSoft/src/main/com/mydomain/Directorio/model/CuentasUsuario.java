/**
 * 
 */
package com.mydomain.Directorio.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

/**
 * Descripcion: Esta Clase se encarga de gestionar el almacenamiento de datos,
 * en esta clase lo referente a las cuentas de usuario, se comunica con la base
 * de datos Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 23/06/2012
 */
@Entity(name = "CuentasUsuario")
@Table(name = "cuentas_usuario")
@Name("cuentasUsuario")
@NamedQueries({
		@NamedQuery(name = "buscarCuentaPorUsername", query = "select s from CuentasUsuario s where s.userAccounts.username=:parametro"),
		@NamedQuery(name = "buscarCuentaPorUsuario", query = "select s from CuentasUsuario s where s.usuarios.documentoIdentidad=:parametro")

})
public class CuentasUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Variable la cual almacena el identificador de la cuenta Tipo de dato Long
	 */
	private Long id;

	/**
	 * Variable la cual almacena la cuenta del Usuario Se instancia de la clase
	 * UserAccount
	 */
	private UserAccount userAccounts;

	/**
	 * Variable la cual es encargada de almacenar los usuarios Se instancia de
	 * la clase Usuario
	 */
	private Usuario usuarios;

	/**
	 * Variable la cual almacena los grupos de usuarios Se instancia de la clase
	 * GrupoUsuarios
	 */
	private Set<GrupoUsuarios> grupoUsuarios;

	/**
	 * Se obtiene el valor de id
	 * 
	 * @return El valor de id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cuenta_usuario", unique = false, nullable = false, insertable = true, updatable = true)
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
	 * Se obtiene el valor de userAccounts
	 * 
	 * @return El valor de userAccounts
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_user_account", unique = false, nullable = false, insertable = true, updatable = true)
	public UserAccount getUserAccounts() {
		return userAccounts;
	}

	/**
	 * Asigna el valor de userAccounts
	 * 
	 * @param userAccounts
	 *            El valor por establecer para userAccounts
	 */
	public void setUserAccounts(UserAccount userAccounts) {
		this.userAccounts = userAccounts;
	}

	/**
	 * Se obtiene el valor de usuarios
	 * 
	 * @return El valor de usuarios
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_usuarios", unique = false, nullable = false, insertable = true, updatable = true)
	public Usuario getUsuarios() {
		return usuarios;
	}

	/**
	 * Asigna el valor de usuarios
	 * 
	 * @param usuarios
	 *            El valor por establecer para usuarios
	 */
	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * Se obtiene el valor de grupoUsuarios
	 * 
	 * @return El valor de grupoUsuarios
	 */

	@OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
	public Set<GrupoUsuarios> getGrupoUsuarios() {
		return grupoUsuarios;
	}

	/**
	 * Asigna el valor de grupoUsuarios
	 * 
	 * @param grupoUsuarios
	 *            El valor por establecer para grupoUsuarios
	 */
	public void setGrupoUsuarios(Set<GrupoUsuarios> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

}
