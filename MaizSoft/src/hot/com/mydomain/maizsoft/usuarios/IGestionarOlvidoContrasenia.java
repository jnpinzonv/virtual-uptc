/**
 * 
 */
package com.mydomain.maizsoft.usuarios;

import javax.ejb.Local;

/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 20/07/2012 
 */
@Local
public interface IGestionarOlvidoContrasenia {
	
	public void enviarEmail(String para,String clave);
	
	public String usuarioValido();

}
