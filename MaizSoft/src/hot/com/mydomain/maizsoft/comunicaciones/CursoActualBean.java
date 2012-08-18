/**
 * 
 */
package com.mydomain.maizsoft.comunicaciones;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;

import com.mydomain.Directorio.model.ConstantesLog;
import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.EstadisticasGenerales;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.Usuario;

/**
 * Descripcion: Esta Clase se encarga de ... Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 2/07/2012
 */
@Name("cursoActualBean")
@Stateless
public class CursoActualBean implements ICursoActual {

	@Logger
	private Log log;

	public static Long select = -1L;
	@PersistenceContext
	EntityManager entityManager;

	@DataModel(value = "listaGrupos")
	private List<GrupoCurso> listaGrupos;

	@DataModelSelection(value = "listaGrupos")
	@Out(required = false)
	private GrupoCurso seleccionado;

	/**
	 * Se obtiene el valor de listaGrupos
	 * 
	 * @return El valor de listaGrupos
	 */
	@Factory("listaGrupos")
	public List<GrupoCurso> getListaGrupos() {
		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);

		Query q1 = entityManager
				.createQuery(ConsultasJpql.USUARIO_POR_USERNAME);
		q1.setParameter("parametro", cre.getUsername());

		Usuario us = (Usuario) q1.getSingleResult();

		Query q = entityManager
				.createQuery(ConsultasJpql.GRUPOS_CURSOS_POR_USUARIO);
		q.setParameter("parametro", us.getId());
		listaGrupos = q.getResultList();

		return listaGrupos;
	}

	/**
	 * Asigna el valor de listaGrupos
	 * 
	 * @param listaGrupos
	 *            El valor por establecer para listaGrupos
	 */
	public void setListaGrupos(List<GrupoCurso> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	/**
	 * Se obtiene el valor de seleccionado
	 * 
	 * @return El valor de seleccionado
	 */
	public GrupoCurso getSeleccionado() {
		// grupoCurso=entityManager.find(GrupoCurso.class,
		// seleccionado.getIdGrupo());
		return seleccionado;
	}

	/**
	 * Asigna el valor de seleccionado
	 * 
	 * @param seleccionado
	 *            El valor por establecer para seleccionado
	 */
	public void setSeleccionado(GrupoCurso seleccionado) {
		this.seleccionado = seleccionado;
	}

	public Long selecionado(long grupo) {

		if (grupo != 0)
			select = grupo;

		crearLog(grupo);

		return grupo;

	}

	public void crearLog(long grupo) {
		Calendar calendar = Calendar.getInstance();
		EstadisticasGenerales nueva = new EstadisticasGenerales();
		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);
		log.info(
				"<--" + "[" + ConstantesLog.NOMBRE_PLATAFORMA + "]" + "Acción:"
						+ "[" + ConstantesLog.CREAR_ACTIVIDAD + "]" + "Tipo:"
						+ "[" + "N/A" + "]" + "Sobre el grupo con ID:" + "["
						+ grupo + "]" + "Realizada por:" + "["
						+ cre.getUsername() + "]" + "en la fecha:" + "["
						+ calendar.getTime() + "]" + "-->", cre.getUsername());

		nueva.setAccionElemento(ConstantesLog.CURSO_VISITADO);
		nueva.setFechaSuceso(calendar.getTime());
		nueva.setLogin(cre.getUsername());
		nueva.setIdGrupoCurso(grupo);
		entityManager.persist(nueva);
	}

	public String selecionadoDos(long grupo) {

		return "";

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mydomain.maizsoft.comunicaciones.ICursoActual#select()
	 */
	public Long select() {
		return select;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mydomain.maizsoft.comunicaciones.ICursoActual#crearScromIMS()
	 */
	@Override
	public void crearScromIMS() {
		// EditorFrame nuevo =new EditorFrame();
		// setVisible(true);

	}

}
