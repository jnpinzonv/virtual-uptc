/**
 * 
 */
package com.mydomain.maizsoft.curso;

import java.util.List;

import javax.ejb.Local;

/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 18/07/2012 
 */
@Local
public interface ISeccionSeleccionada {

	
	
	/**
	 * Se obtiene el valor de listaSeccionesCurso
	 * @return El valor de listaSeccionesCurso
	 */
	public List<Integer> getListaSeccionesCurso() ;

	/**
	 * Asigna el valor de listaSeccionesCurso
	 * @param listaSeccionesCurso El valor por establecer para listaSeccionesCurso
	 */
	public void setListaSeccionesCurso(List<Integer> listaSeccionesCurso) ;

	/**
	 * Se obtiene el valor de seccionSeleccionada
	 * @return El valor de seccionSeleccionada
	 */
	public int getSeccionSeleccionada();

	/**
	 * Asigna el valor de seccionSeleccionada
	 * @param seccionSeleccionada El valor por establecer para seccionSeleccionada
	 */
	public void setSeccionSeleccionada(int seccionSeleccionada) ;
}
