/**
 * 
 */
package com.mydomain.maizsoft.academia;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;

import com.mydomain.Directorio.model.Actividad;
import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.GrupoCurso;

/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 31/07/2012 
 */
@Stateless
@Name("actividadSeleccionadaBean")
@Scope(ScopeType.SESSION)
public class ActividadSeleccionadaBean implements IActividadSeleccionada{
	

	
	private List<Actividad> listaActividadesCurso;
	
	
	private static long actividadSeleccionada =-1L;
	
	
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Se obtiene el valor de listaSeccionesCurso
	 * @return El valor de listaSeccionesCurso
	 */

	public List<Actividad> getListaActividadesDivision(Long idTipo) {
		
		try {
			
			Query q = entityManager.createQuery(
					ConsultasJpql.ACTIVIADES_POR_DIVISION);
			q.setParameter("parametro", idTipo);
						
			 listaActividadesCurso=(List<Actividad>)q.getResultList();
		
		
		} catch (RuntimeException e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Algo malo a sucedido :-(  por favor vuelva a seleccionar el curso");
		}
		
		
		return listaActividadesCurso;
	}

	/**
	 * Asigna el valor de listaSeccionesCurso
	 * @param listaSeccionesCurso El valor por establecer para listaSeccionesCurso
	 */
	public void setListaActividadesCurso(List<Actividad> listaActividadesCurso) {
		this.listaActividadesCurso = listaActividadesCurso;
	}

	/**
	 * Se obtiene el valor de seccionSeleccionada
	 * @return El valor de seccionSeleccionada
	 */
	public long getActividadSeleccionada() {
	 	
		return actividadSeleccionada;
	}

	/**
	 * Asigna el valor de seccionSeleccionada
	 * @param seccionSeleccionada El valor por establecer para seccionSeleccionada
	 */
	public void addActividadSeleccionada(long actividadSeleccionada) {
		System.out.println("hola actividad"+ actividadSeleccionada);
		this.actividadSeleccionada = actividadSeleccionada;
	}

	


}
