/**
 * 
 */
package com.mydomain.maizsoft.comunicaciones;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.security.Credentials;

import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.GrupoUsuarios;
import com.mydomain.Directorio.model.Usuario;
import com.mydomain.maizsoft.academia.ActividadHome;
import com.mydomain.maizsoft.curso.GrupoCursoHome;

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
		// grupoCursoHome.setInstance(seleccionado);
		// grupoCurso=entityManager.find(GrupoCurso.class,
		// seleccionado.getIdGrupo());
		// System.out.println(grupoCurso.getCupos()+ "holaaaaaaaaaaaaaa22");
		// System.out.println(instance.getIdGrupo()+
		// "hola mundooooooooooooooooooooo");
		// System.out.println(facesContext.getCurrentInstance().getExternalContext().getRequestMap().get("grupoCursoIdGrupo")+
		// "holooooooooooooooo");
		System.out.println("holaaaaaaaaaaaa datoz"+ grupo);
		return grupo;

	}
	
	public String selecionadoDos(String grupo) {
		// grupoCursoHome.setInstance(seleccionado);
		// grupoCurso=entityManager.find(GrupoCurso.class,
		// seleccionado.getIdGrupo());
		// System.out.println(grupoCurso.getCupos()+ "holaaaaaaaaaaaaaa22");
		// System.out.println(instance.getIdGrupo()+
		// "hola mundooooooooooooooooooooo");
		// System.out.println(facesContext.getCurrentInstance().getExternalContext().getRequestMap().get("grupoCursoIdGrupo")+
		// "holooooooooooooooo");
		System.out.println("holaaaaaaaaaaaa dato "+ grupo);
		return grupo;

	}

}
