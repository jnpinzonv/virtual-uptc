/**
 * 
 */
package com.mydomain.maizsoft.curso;

import java.security.spec.EllipticCurve;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;

import sun.util.logging.resources.logging;


import com.mydomain.Directorio.model.Curso;
import com.mydomain.Directorio.model.EnteUniversitario;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.Usuario;
import com.mydomain.maizsoft.academia.EnteUniversitarioHome;


/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Name("gestorMatriculasBean")
@Stateless
public class GestorMatriculasBean implements IGestorMatriculas {
	
	
	@In(create=true)
	
	Usuario usuario;

	@In(create=true)
	@Out
	EnteUniversitarioHome enteUniversitarioHome;
	
	@In(create=true)
	@Out
	ListaEscuelasMatricula listaEscuelasMatricula;
	
	
	
	@In(create=true)	
	private Curso curso;
	
	@In(required=false)	
	private GrupoCurso grupoCurso;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private LinkedList<Usuario> usuarios;
	
	
	private LinkedList<Curso> listaCursos;

	
	
	
	/**
	 * @return the listaEscuelasMatricula
	 */
	public ListaEscuelasMatricula getListaEscuelasMatricula() {
		return listaEscuelasMatricula;
	}

	/**
	 * @param listaEscuelasMatricula the listaEscuelasMatricula to set
	 */
	public void setListaEscuelasMatricula(
			ListaEscuelasMatricula listaEscuelasMatricula) {
		this.listaEscuelasMatricula = listaEscuelasMatricula;
	}


	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * @return the grupoCurso
	 */
	public GrupoCurso getGrupoCurso() {
		return grupoCurso;
	}

	/**
	 * @param grupoCurso the grupoCurso to set
	 */
	public void setGrupoCurso(GrupoCurso grupoCurso) {
		this.grupoCurso = grupoCurso;
	}

	/**
	 * @return the usuarios
	 */
	public LinkedList<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(LinkedList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Factory("listaEscuelasMatriculas")
	public List<EnteUniversitario> listaEntesUniversitarios() {
	
			
		Query q = 
				entityManager.createNamedQuery("entesUniversitariosPorFacultad");
		q.setParameter("parametro",enteUniversitarioHome.getInstance().getIdEnteUniversitario());
		List<EnteUniversitario> listaEntesUniversitarios = (List<EnteUniversitario>) q
				.getResultList();		
		
		return listaEntesUniversitarios;
	}
	
	@Factory("listaCursoMatricula")
	public List<Curso> listaCursoMatricula(){
		System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + enteUniversitarioHome.getInstance().getNombreEnteUniversitario() );
		if(enteUniversitarioHome.getInstance().getEnteUniversitario()==null)
			System.out.println(enteUniversitarioHome.getInstance().getEnteUniversitario()+".................................................");
		Query q = 
				entityManager.createNamedQuery("cursosPorEscuela");
		if(enteUniversitarioHome.getInstance().getEnteUniversitario()!=null)
		q.setParameter("parametro",15l);
		else
			q.setParameter("parametro",15l);
		List<Curso> listaCursoMatricula = (List<Curso>) q
				.getResultList();		
		
		return listaCursoMatricula;
	}
	
	
	
	

	
	
	

}
