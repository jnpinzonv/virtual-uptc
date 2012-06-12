/**
 * 
 */
package com.mydomain.maizsoft.cargaarchivos;

import java.util.LinkedList;

import javax.ejb.Local;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.security.management.action.UserAction;

import com.mydomain.Directorio.model.Usuario;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Local
public interface IPreCargaUsuarios {

	
	
	/**
	 * @return the usuarios
	 */
	
	public LinkedList<Usuario> getUsuarios();
	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(LinkedList<Usuario> usuarios) ;
	/**
	 * @return the userActions
	 */
	
	public LinkedList<UserAction> getUserActions();
	/**
	 * @param userActions the userActions to set
	 */
	public void setUserActions(LinkedList<UserAction> userActions);
}
