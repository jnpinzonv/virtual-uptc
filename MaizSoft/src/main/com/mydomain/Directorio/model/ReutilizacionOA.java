/**
 * 
 */
package com.mydomain.Directorio.model;

/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 20/08/2012 
 */
public class ReutilizacionOA {

	private Long idOA;
	
	private Long total;
	
	
	/**
	 * Se obtiene el valor de idOA
	 * @return El valor de idOA
	 */
	public Long getIdOA() {
		
		return idOA;
	}
	
	/**
	 * Asigna el valor de idOA
	 * @param idOA El valor por establecer para idOA
	 */
	public void setIdOA(Long idOA) {
		this.idOA = idOA;
	}
	
	/**
	 * Se obtiene el valor de total
	 * @return El valor de total
	 */
	public Long getTotal() {
		return total;
	}
	
	/**
	 * Asigna el valor de total
	 * @param total El valor por establecer para total
	 */
	public void setTotal(Long total) {
		this.total = total;
	}
}
