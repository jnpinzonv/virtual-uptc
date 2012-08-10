/**
 * 
 */
package com.mydomain.maizsoft.academia;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.faces.FacesMessages;

import com.mydomain.Directorio.model.Actividad;
import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.NotaActividad;
import com.mydomain.Directorio.model.Tipo;

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

	String addFor(Long id);

	/**
	 * Se obtiene el valor de listaSeccionesCurso
	 * @return El valor de listaSeccionesCurso
	 */

	public List<Actividad> getListaActividadesDivision(Long idTipo) ;

	

	
	



	/**
	 * Se obtiene el valor de listaActividadesCurso
	 * @return El valor de listaActividadesCurso
	 */
	public List<Actividad> getListaActividadesCurso();



	/**
	 * Asigna el valor de listaActividadesCurso
	 * @param listaActividadesCurso El valor por establecer para listaActividadesCurso
	 */
	public void setListaActividadesCurso(List<Actividad> listaActividadesCurso) ;



	/**
	 * Se obtiene el valor de actividadSeleccionada
	 * @return El valor de actividadSeleccionada
	 */
	 Tipo getActividadSeleccionada();
	 



	/**
	 * Asigna el valor de actividadSeleccionada
	 * @param actividadSeleccionada El valor por establecer para actividadSeleccionada
	 */
	 void setActividadSeleccionada(Tipo actividadSeleccionada);

	 

	/**
	 * Se obtiene el valor de actividad
	 * @return El valor de actividad
	 */
			Actividad getActividad() ;



	/**
	 * Asigna el valor de actividad
	 * @param actividad El valor por establecer para actividad
	 */
	 void setActividad(Actividad actividad);

	
	 List<Tipo> listaActividades();
	 
	 String addListaActividades();
	 
	 
	 public List<NotaActividad> getListaNota();



		/**
		 * Asigna el valor de listaNota
		 * @param listaNota El valor por establecer para listaNota
		 */
		public void setListaNota(List<NotaActividad> listaNota) ;
		
		

		/**
		 * Se obtiene el valor de listaActividades
		 * @return El valor de listaActividades
		 */
		@Factory("listaActividades")
		public List<Actividad> getListaActividades();



		/**
		 * Asigna el valor de listaActividades
		 * @param listaActividades El valor por establecer para listaActividades
		 */
		public void setListaActividades(List<Actividad> listaActividades);



		/**
		 * Se obtiene el valor de selectActividades
		 * @return El valor de selectActividades
		 */
		
		public Actividad getSelectActividades() ;



		/**
		 * Asigna el valor de selectActividades
		 * @param selectActividades El valor por establecer para selectActividades
		 */
		public void setSelectActividades(Actividad selectActividades) ;



		/**
		 * Se obtiene el valor de notaActividadHome
		 * @return El valor de notaActividadHome
		 */
		public NotaActividadHome getNotaActividadHome() ;



		/**
		 * Asigna el valor de notaActividadHome
		 * @param notaActividadHome El valor por establecer para notaActividadHome
		 */
		public void setNotaActividadHome(NotaActividadHome notaActividadHome) ;
		
		
		public long getIdForo();



		/**
		 * Asigna el valor de idForo
		 * @param idForo El valor por establecer para idForo
		 */
		public void setIdForo(long idForo);
		
		public List<NotaActividad> listaNotaActi();


		
		

	 
	
}
