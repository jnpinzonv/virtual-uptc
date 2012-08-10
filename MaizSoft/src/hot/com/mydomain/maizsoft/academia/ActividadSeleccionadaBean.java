/**
 * 
 */
package com.mydomain.maizsoft.academia;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;

import com.mydomain.Directorio.model.Actividad;
import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.NotaActividad;
import com.mydomain.Directorio.model.Tipo;
import com.mydomain.maizsoft.tipos.TipoHome;

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
@Stateless
@Name("actividadSeleccionadaBean")
@Scope(ScopeType.SESSION)
public class ActividadSeleccionadaBean implements IActividadSeleccionada{
	

	
	private List<Actividad> listaActividadesCurso;
	
	
	private List<NotaActividad> listaNota;
	
	
	public  long idForo=0;
	
	public static long id=0;
	
	
	//@DataModel(value = "listaActividades")
	private List<Actividad> listaActividades;

	//@DataModelSelection(value = "listaActividades")
	//@Out(required = false)
	private Actividad selectActividades;	
	

	
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Se obtiene el valor de listaSeccionesCurso
	 * @return El valor de listaSeccionesCurso
	 */

	public List<Actividad> getListaActividadesDivision(Long idTipo) {	
		
			
			Query q = entityManager.createQuery(
					ConsultasJpql.ACTIVIADES_POR_DIVISION);
			q.setParameter("parametro", idTipo);
						
			 listaActividadesCurso=(List<Actividad>)q.getResultList();
			 try {
		
		} catch (RuntimeException e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Algo malo a sucedido :-(  por favor vuelva a seleccionar el curso");
		}
		
		
		return listaActividadesCurso;
	}

	

	/* (non-Javadoc)
	 * @see com.mydomain.maizsoft.academia.IActividadSeleccionada#listaActividades()
	 */
	
	public List<Tipo> listaActividades() {
	
		Query q = entityManager.createQuery(
				ConsultasJpql.LISTA_TIPOS_ACTIVIDADES);
		
		return (List<Tipo>)q.getResultList();
	}



	/**
	 * Se obtiene el valor de listaActividadesCurso
	 * @return El valor de listaActividadesCurso
	 */
	public List<Actividad> getListaActividadesCurso() {
		return listaActividadesCurso;
	}



	/**
	 * Asigna el valor de listaActividadesCurso
	 * @param listaActividadesCurso El valor por establecer para listaActividadesCurso
	 */
	public void setListaActividadesCurso(List<Actividad> listaActividadesCurso) {
		this.listaActividadesCurso = listaActividadesCurso;
	}



	/**
	 * Se obtiene el valor de actividadSeleccionada
	 * @return El valor de actividadSeleccionada
	 */
	public Tipo getActividadSeleccionada() {
		return null;
	}



	/**
	 * Asigna el valor de actividadSeleccionada
	 * @param actividadSeleccionada El valor por establecer para actividadSeleccionada
	 */
	public  void setActividadSeleccionada(Tipo actividadSeleccionada) {
		//this.tipo = actividadSeleccionada;
	}






	



	/* (non-Javadoc)
	 * @see com.mydomain.maizsoft.academia.IActividadSeleccionada#listaActividades(java.lang.Long)
	 */
	@Override
	public String addListaActividades() {

		try {
			
		
		Query q = null;
		List<NotaActividad> nueva=null;
			q = entityManager.createQuery(
					ConsultasJpql.NOTAS_ACTIVIDAD);
			//q.setParameter("parametro",notaActividadHome.getInstance().getTipo().getIdTipo());
						
		listaNota=(List<NotaActividad>)q.getResultList();
		} catch (Exception e) {
			listaNota= new ArrayList<NotaActividad>();
		}
		return"";
	}



	/**
	 * Se obtiene el valor de listaNota
	 * @return El valor de listaNota
	 */
	public List<NotaActividad> getListaNota() {
		if(listaNota==null)
			return listaNota=new ArrayList<NotaActividad>();
		return listaNota;
	}



	/**
	 * Asigna el valor de listaNota
	 * @param listaNota El valor por establecer para listaNota
	 */
	public void setListaNota(List<NotaActividad> listaNota) {
		this.listaNota = listaNota;
	}



	/* (non-Javadoc)
	 * @see com.mydomain.maizsoft.academia.IActividadSeleccionada#getActividad()
	 */
	@Override
	public Actividad getActividad() {
		// TODO Auto-generated method stub
		return null;
	}



	/* (non-Javadoc)
	 * @see com.mydomain.maizsoft.academia.IActividadSeleccionada#setActividad(com.mydomain.Directorio.model.Actividad)
	 */
	@Override
	public void setActividad(Actividad actividad) {
		// TODO Auto-generated method stub
		
	}



	/**
	 * Se obtiene el valor de listaActividades
	 * @return El valor de listaActividades
	 */
	@Factory("listaActividadess")
	public List<Actividad> getListaActividades() {
		Query q =null;
		
			System.out.println("Lamaddooooooooooooooooooooooooooooo");
		
	 q = entityManager.createQuery(
			ConsultasJpql.ACTIVIADES_POR_DIVISION);
	q.setParameter("parametro", idForo);
	listaActividades=(List<Actividad>) q.getResultList();
	try {
		} catch (Exception e) {
			return new ArrayList<Actividad>();
		}
	return listaActividades;
	}



	/**
	 * Asigna el valor de listaActividades
	 * @param listaActividades El valor por establecer para listaActividades
	 */
	public void setListaActividades(List<Actividad> listaActividades) {
		this.listaActividades = listaActividades;
	}



	/**
	 * Se obtiene el valor de selectActividades
	 * @return El valor de selectActividades
	 */
	
	public Actividad getSelectActividades() {
		if(selectActividades==null)
			return new Actividad();
		return selectActividades;
	}



	/**
	 * Asigna el valor de selectActividades
	 * @param selectActividades El valor por establecer para selectActividades
	 */
	public void setSelectActividades(Actividad selectActividades) {
		this.selectActividades = selectActividades;
	}



	/**
	 * Se obtiene el valor de notaActividadHome
	 * @return El valor de notaActividadHome
	 */
	public NotaActividadHome getNotaActividadHome() {
		return null;
	}



	/**
	 * Asigna el valor de notaActividadHome
	 * @param notaActividadHome El valor por establecer para notaActividadHome
	 */
	public void setNotaActividadHome(NotaActividadHome notaActividadHome) {
		//this.notaActividadHome = notaActividadHome;
	}



	/**
	 * Se obtiene el valor de idForo
	 * @return El valor de idForo
	 */
	public long getIdForo() {
		//listaNotaActi();
		
		return idForo;
	}



	/**
	 * Asigna el valor de idForo
	 * @param idForo El valor por establecer para idForo
	 */
	public void setIdForo(long idForo) {
		this.idForo = idForo;
	}

	
	@Factory("listaNotasCurso")
	public List<NotaActividad> listaNotaActi(){
		Query q = null;
		
			
		System.out.println(idForo + "hola mundo");
		List<NotaActividad> nueva=null;
			q = entityManager.createQuery(
					ConsultasJpql.NOTAS_ACTIVIDAD);
			q.setParameter("parametro",getIdForo());
			try {
		} catch (Exception e) {
			return new ArrayList<NotaActividad>();
		}
			return q.getResultList();
	}
	
	public String addFor(Long id){
			System.out.println(idForo + "hola HIO");
			listaNotaActi();
		return "";
	}


}
