/**
 * 
 */
package com.mydomain.maizsoft.comunicaciones;



import java.util.List;

import javax.ejb.Local;
import javax.faces.model.SelectItem;

import com.mydomain.Directorio.model.GrupoCurso;

/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 2/07/2012 
 */
@Local
public interface ICursoActual {

	
	public GrupoCurso getSeleccionado();
	
	public List<GrupoCurso> getListaGrupos();
	
	public void setSeleccionado(GrupoCurso seleccionado);
	
	public Long selecionado(long grupo);	

	

	
	

}