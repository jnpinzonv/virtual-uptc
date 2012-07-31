/**
 * 
 */
package com.mydomain.maizsoft.academia;

import java.util.List;

import javax.ejb.Local;

import com.mydomain.Directorio.model.Actividad;

/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 31/07/2012 
 */
@Local
public interface IActividadSeleccionada {

	

	/**
	 * Se obtiene el valor de listaSeccionesCurso
	 * @return El valor de listaSeccionesCurso
	 */
	public List<Actividad> getListaActividadesDivision(Long idTipo) ;

	/**
	 * Asigna el valor de listaSeccionesCurso
	 * @param listaSeccionesCurso El valor por establecer para listaSeccionesCurso
	 */
	public void setListaActividadesCurso(List<Actividad> listaActividadesCurso) ;

	/**
	 * Se obtiene el valor de seccionSeleccionada
	 * @return El valor de seccionSeleccionada
	 */
	public long getActividadSeleccionada();

	/**
	 * Asigna el valor de seccionSeleccionada
	 * @param seccionSeleccionada El valor por establecer para seccionSeleccionada
	 */
	public void addActividadSeleccionada(long seccionSeleccionada) ;
}
