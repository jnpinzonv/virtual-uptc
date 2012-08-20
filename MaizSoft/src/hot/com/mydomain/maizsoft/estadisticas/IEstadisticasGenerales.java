/**
 * 
 */
package com.mydomain.maizsoft.estadisticas;



import java.util.List;

import javax.ejb.Local;
import com.mydomain.Directorio.model.EstadisticasGenerales;
import com.mydomain.Directorio.model.ReutilizacionOA;


/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 2/07/2012 
 */
@Local
public interface IEstadisticasGenerales {

	public List<EstadisticasGenerales> getEstadisticasAccion(String accion);
	
	public List<ReutilizacionOA> listaReutilizacionOA();
}