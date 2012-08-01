/**
 * 
 */
package com.mydomain.maizsoft.usuarios;


import java.util.List;

import com.mydomain.Directorio.model.Usuario;

/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 27/07/2012 
 */
public interface IUsuarioSeleccionado {
	
	public List<Usuario> getListaUsuarioSeleccionado();
	/**
	 * Se obtiene el valor de usuarioSeleccionado
	 * 
	 * @return El valor de usuarioSeleccionado
	 */
	public Usuario getUsuarioSeleccionado() ;
	/**
	 * Asigna el valor de usuarioSeleccionado
	 * 
	 * @param usuarioSeleccionado
	 *            El valor por establecer para usuarioSeleccionado
	 */
	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado);
	/**
	 * Asigna el valor de listaUsuarioSeleccionado
	 * 
	 * @param listaUsuarioSeleccionado
	 *            El valor por establecer para listaUsuarioSeleccionado
	 */
	public void setListaUsuarioSeleccionado(List<Usuario> listaUsuarioSeleccionado) ;
	
	/**
	 * @return
	 */
	String rutaImagen();
}
