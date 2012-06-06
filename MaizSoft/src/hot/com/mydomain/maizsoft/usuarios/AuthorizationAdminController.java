/**
 * 
 */
package com.mydomain.maizsoft.usuarios;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.security.Restrict;
import org.jboss.seam.framework.Controller;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Name("authorizationAdminController")
@Scope(ScopeType.CONVERSATION)
public class AuthorizationAdminController extends Controller{
	
	@Restrict("#{s:hasRole('admin')}")
	public void forceCheckAdminAuthorization(){}
	
	@Restrict("#{s:hasRole('docente')}")
	public void forceCheckDocenteAuthorization(){}
	
	@Restrict("#{s:hasRole('estudiante')}")
	public void forceCheckEstudianteAuthorization(){}
	
	@Restrict("#{s:hasRole('visitante')}")
	public void forceCheckVisitanteAuthorization(){}
	
}
