/**
 * 
 */
package com.mydomain.maizsoft.curso;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Local;


import com.mydomain.Directorio.model.Curso;
import com.mydomain.Directorio.model.EnteUniversitario;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.Usuario;
import com.mydomain.maizsoft.academia.EnteUniversitarioHome;


/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Local
public interface IGestorMatriculas {
	

	
	
	
	/**
	 * @return the curso
	 */
	public Curso getCurso();

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Curso curso) ;

	/**
	 * @return the grupoCurso
	 */
	public GrupoCurso getGrupoCurso() ;

	/**
	 * @param grupoCurso the grupoCurso to set
	 */
	public void setGrupoCurso(GrupoCurso grupoCurso) ;

	/**
	 * @return the usuarios
	 */
	public LinkedList<Usuario> getUsuarios() ;

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(LinkedList<Usuario> usuarios);
	
	public List<EnteUniversitario> listaEntesUniversitarios();
	

	/**
	 * @return the listaEscuelasMatricula
	 */
	public ListaEscuelasMatricula getListaEscuelasMatricula() ;

	/**
	 * @param listaEscuelasMatricula the listaEscuelasMatricula to set
	 */
	public void setListaEscuelasMatricula(
			ListaEscuelasMatricula listaEscuelasMatricula) ;
	
	public List<Curso> listaCursoMatricula();

}
