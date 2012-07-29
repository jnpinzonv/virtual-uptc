/**
 * 
 */
package com.mydomain.maizsoft.curso;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.faces.FacesMessages;

import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.GrupoUsuarios;

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
@Stateless
@Name("seccionSeleccionadaBean")
public class SeccionSeleccionadaBean implements ISeccionSeleccionada {

	
	
	private List<Integer> listaSeccionesCurso;
	
	
	private static int seccionSeleccionada =1;
	
	
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Se obtiene el valor de listaSeccionesCurso
	 * @return El valor de listaSeccionesCurso
	 */
	@Factory("listaSeccionesCurso")
	public List<Integer> getListaSeccionesCurso() {
		
		try {
			
		
		Query q = entityManager.createQuery(ConsultasJpql.GRUPO_SELECCIONDADO);
		GrupoCurso nuevo =(GrupoCurso)q.getSingleResult();
		List< Integer> nue= new ArrayList<Integer>();
		for (int i = 0; i <nuevo.getNumeroTotal(); i++) {
			nue.add((i+1));			
		}	
		
		listaSeccionesCurso=nue;
		
		} catch (RuntimeException e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Algo malo a sucedido :-(  por favor vuelva a seleccionar el curso");
		}
		
		
		return listaSeccionesCurso;
	}

	/**
	 * Asigna el valor de listaSeccionesCurso
	 * @param listaSeccionesCurso El valor por establecer para listaSeccionesCurso
	 */
	public void setListaSeccionesCurso(List<Integer> listaSeccionesCurso) {
		this.listaSeccionesCurso = listaSeccionesCurso;
	}

	/**
	 * Se obtiene el valor de seccionSeleccionada
	 * @return El valor de seccionSeleccionada
	 */
	public int getSeccionSeleccionada() {
	 	
		return seccionSeleccionada;
	}

	/**
	 * Asigna el valor de seccionSeleccionada
	 * @param seccionSeleccionada El valor por establecer para seccionSeleccionada
	 */
	public void setSeccionSeleccionada(int seccionSeleccionada) {
		this.seccionSeleccionada = seccionSeleccionada;
	}
}
