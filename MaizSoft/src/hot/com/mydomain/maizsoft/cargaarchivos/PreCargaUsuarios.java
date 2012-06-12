/**
 * 
 */
package com.mydomain.maizsoft.cargaarchivos;

import java.util.LinkedList;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.security.management.action.UserAction;

import com.mydomain.Directorio.model.UserAccount;
import com.mydomain.Directorio.model.Usuario;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */

@Name("preCargaUsuarios")
public class PreCargaUsuarios implements IPreCargaUsuarios {

	
	private LinkedList <Usuario> usuarios;
	
	private LinkedList< UserAction> userActions;
	/**
	 * 
	 */
	public PreCargaUsuarios() {
		usuarios =new LinkedList<Usuario>();
		userActions= new LinkedList<UserAction>();
	}
	/**
	 * @return the usuarios
	 */
	@Factory("listaUsuariosPreCargada")
	public LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}
	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(LinkedList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	/**
	 * @return the userActions
	 */
	@Factory("listaCuentasUsuariosPreCargada")
	public LinkedList<UserAction> getUserActions() {
		return userActions;
	}
	/**
	 * @param userActions the userActions to set
	 */
	public void setUserActions(LinkedList<UserAction> userActions) {
		this.userActions = userActions;
	}
	
	
	

}
