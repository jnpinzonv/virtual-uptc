package com.mydomain.Directorio.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.security.management.RoleConditional;
import org.jboss.seam.annotations.security.management.RoleGroups;
import org.jboss.seam.annotations.security.management.RoleName;

/**
 * @author Josue Nicolas Pinzon Villamil Fecha: 13/03/2012 Correo:
 *         jnpinzonv@hotmail.com Clase empleada para describir los roles de
 *         usuario de la plataforma
 */
@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 9177366120789064801L;

	/**
	 * 
	 */
	private Long id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private boolean conditional;

	/**
	 * 
	 */
	private Set<UserRole> groups;

	/**
	 * @return
	 */
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	@RoleName
	@NotNull
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	@RoleGroups
	@ManyToMany
	@JoinTable(name = "user_role_group", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "member_of_role"))
	public Set<UserRole> getGroups() {
		return groups;
	}

	/**
	 * @param groups
	 */
	public void setGroups(Set<UserRole> groups) {
		this.groups = groups;
	}

	/**
	 * @return
	 */
	@RoleConditional
	public boolean isConditional() {
		return conditional;
	}

	/**
	 * @param conditional
	 */
	public void setConditional(boolean conditional) {
		this.conditional = conditional;
	}
}
