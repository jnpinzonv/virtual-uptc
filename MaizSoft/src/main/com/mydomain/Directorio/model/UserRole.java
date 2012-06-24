package com.mydomain.Directorio.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.security.management.RoleConditional;
import org.jboss.seam.annotations.security.management.RoleGroups;
import org.jboss.seam.annotations.security.management.RoleName;

/**
* Descripcion: Esta Clase se encarga de almacenar informaci�n referente
* a los roles de los usuarios.
* Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity(name="UserRole")
@Table(name="user_role")
@Name("userRole")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 9177366120789064801L;

	/**
	 * Variable que almacena el identificar del rol 
	 * del usuario.
	 */
	private Long id;
	
	/**
	 * Variable que almacena el nombre
	 * del rol del usuario.
	 */
	private String name;
	
	/**
	 * Variable que da a conocer si el usuario
	 * posee un rol o no.
	 */
	private boolean conditional;

	/**
	 * Variable encargada de almacenar la lista de roles de usuario.
	 */
	private Set<UserRole> groups;
	
	/**
	 * Se obtiene el valor de id
	 * @return El valor de id
	 */
	@Id
	@GeneratedValue
	@Column(name = "id_user_role", unique = false, nullable = false, insertable = true, updatable = true)
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
	 * Se obtiene el valor de name
	 * @return El valor de name
	 */
	@RoleName
	@NotNull
	@Column(name = "name", unique = true, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(30)")
	public String getName() {
		return name;
	}

	/**
	 * Asigna el valor de name
	 * @param name El valor por establecer para name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Se obtiene el valor de groups
	 * @return El valor de groups
	 */
	@RoleGroups
	@ManyToMany
	@JoinTable(name = "user_role_group", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "member_of_role"))
		public Set<UserRole> getGroups() {
		return groups;
	}

	/**
	 * Asigna el valor de groups
	 * @param groups El valor por establecer para groups
	 */
	public void setGroups(Set<UserRole> groups) {
		this.groups = groups;
	}

	/**
	 * Se obtiene el valor de conditional
	 * @return El valor de conditional
	 */
	@RoleConditional
	@Column(name = "conditional", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "bit(1)")
	public boolean isConditional() {
		return conditional;
	}

	/**
	 * Asigna el valor de conditional
	 * @param conditional El valor por establecer para conditional
	 */
	public void setConditional(boolean conditional) {
		this.conditional = conditional;
	}
	

	
	
}
