/**
 * 
 */
package com.mydomain.maizsoft.estadisticas;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;


import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.EstadisticasGenerales;
import com.mydomain.Directorio.model.ReutilizacionOA;


/**
 * Descripcion: Esta Clase se encarga de ... Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 2/07/2012
 */
@Name("estadisticasGeneralesBean")
@Stateless
public class EstadisticasGeneralesBean implements IEstadisticasGenerales {

	@PersistenceContext
	EntityManager entityManager;

	public List<EstadisticasGenerales> getEstadisticasAccion(String accion) {

		Query q = entityManager.createQuery(ConsultasJpql.ESTADISTICAS_ACCION);
		q.setParameter("parametro", accion);

		return q.getResultList();
	}

	@Factory("reutilizacionOA")
	public List<ReutilizacionOA> listaReutilizacionOA() {
		
		List<ReutilizacionOA> nueva=new ArrayList<ReutilizacionOA>();
		Query q = entityManager.createQuery(ConsultasJpql.REUTILIZACION_OA);
		Iterator results =q.getResultList().iterator();
		
		while ( results.hasNext() ) {
		Object[] row = (Object[]) results.next();
		ReutilizacionOA nuevoA=new ReutilizacionOA();
		nuevoA.setIdOA((Long) row[0]);
		nuevoA.setTotal((Long) row[1]);
		
		nueva.add(nuevoA);
		}	
		return nueva;	
	}
	
}
