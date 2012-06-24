package com.mydomain.maizsoft.curso;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.Query;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

import com.mydomain.Directorio.model.CuentasUsuario;
import com.mydomain.Directorio.model.Curso;
import com.mydomain.Directorio.model.EnteUniversitario;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.GrupoUsuarios;
import com.mydomain.Directorio.model.NotaActividad;
import com.mydomain.Directorio.model.Usuario;
import com.mydomain.maizsoft.usuarios.CuentasUsuarioHome;
import com.mydomain.maizsoft.usuarios.UsuarioHome;

@Name("grupoUsuariosHome")
public class GrupoUsuariosHome extends EntityHome<GrupoUsuarios> {

	@In(create = true)
	GrupoCursoHome grupoCursoHome;
	@In(create = true)
	UsuarioHome usuarioHome;
	@In(create = true)
	CuentasUsuarioHome cuentasUsuarioHome;

	public void setGrupoUsuariosIdGrupoUsuarios(Long id) {
		setId(id);
	}

	public Long getGrupoUsuariosIdGrupoUsuarios() {
		return (Long) getId();
	}

	@Override
	protected GrupoUsuarios createInstance() {
		GrupoUsuarios grupoUsuarios = new GrupoUsuarios();
		return grupoUsuarios;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		GrupoCurso grupoCurso = grupoCursoHome.getDefinedInstance();
		if (grupoCurso != null) {
			getInstance().setGrupoCurso(grupoCurso);
		}
		Usuario userGrupoCurso = usuarioHome.getDefinedInstance();
		if (userGrupoCurso != null) {
			getInstance().setUserGrupoCurso(userGrupoCurso);
		}
		CuentasUsuario userRole = cuentasUsuarioHome.getDefinedInstance();
		if (userRole != null) {
			getInstance().setUserRole(userRole);
		}
	}

	public boolean isWired() {
		if (getInstance().getGrupoCurso() == null)
			return false;
		return true;
	}

	public GrupoUsuarios getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<NotaActividad> getNotaActividades() {
		return getInstance() == null ? null : new ArrayList<NotaActividad>(
				getInstance().getNotaActividades());
	}

	@Factory("listaEscuelasMatriculas")
	public List<EnteUniversitario> listaEntesUniversitarios() {
		List<EnteUniversitario> listaEntesUniversitarios = new ArrayList<EnteUniversitario>();
		Query q = getEntityManager().createNamedQuery(
				"entesUniversitariosPorFacultad");
		if (instance.getEnteUniversitarioPadre() == null) {
			q.setParameter("parametro", 7L);
			listaEntesUniversitarios = (List<EnteUniversitario>) q
					.getResultList();
		} else {

			q.setParameter("parametro", instance.getEnteUniversitarioPadre()
					.getIdEnteUniversitario());
			listaEntesUniversitarios = (List<EnteUniversitario>) q
					.getResultList();
		}
		return listaEntesUniversitarios;
	}
	
	@Factory("listaGruposPorCurso")
	public List<GrupoCurso> listagGruposPorCurso() {
		if (instance.getCurso()!= null)
		System.out.println(instance.getCurso().getCodigo()+ "gdfshdsf");
		List<GrupoCurso> listaGruposPorCurso = new ArrayList<GrupoCurso>();
		Query q = getEntityManager().createNamedQuery(
				"gruposPorCurso");
		if (instance.getCurso()== null) {
			q.setParameter("parametro", 456L);
			listaGruposPorCurso = (List<GrupoCurso>) q
					.getResultList();
		} else {

			q.setParameter("parametro", instance.getCurso().getCodigo());
			listaGruposPorCurso = (List<GrupoCurso>) q
					.getResultList();
		}
		return listaGruposPorCurso;
	}

	@Factory("listaCursoMatricula")
	public List<Curso> listaCursoMatricula() {

		List<Curso> listaCursoMatricula = new ArrayList<Curso>();
		Query q = getEntityManager().createNamedQuery("cursosPorEscuela");
		if (instance.getEnteUniversitarioHijo() == null) {
			q.setParameter("parametro", 15L);
			listaCursoMatricula = (List<Curso>) q.getResultList();
		} else {
			q.setParameter("parametro", instance.getEnteUniversitarioHijo()
					.getIdEnteUniversitario());
			listaCursoMatricula = (List<Curso>) q.getResultList();
		}
		return listaCursoMatricula;
	}
	
	
	
	@Factory("listaUsuariosEscuela")
	public List<SelectItem> listaUsuariosEscuela() {

		List<Usuario> listaUsuariosEscuela = new ArrayList<Usuario>();
		Query q = getEntityManager().createNamedQuery("usuariosPorEscuela");
		if (instance.getEnteUniversitarioHijo() == null) {
			q.setParameter("parametro", 15L);
			listaUsuariosEscuela = (List<Usuario>) q.getResultList();
		} else {
			q.setParameter("parametro", instance.getEnteUniversitarioHijo()
					.getIdEnteUniversitario());
			listaUsuariosEscuela = (List<Usuario>) q.getResultList();
		}
		
		 List<Usuario> someObjects = listaUsuariosEscuela;
	      List<SelectItem> sItems = new ArrayList<SelectItem>(); 
	      for(Usuario sObj : someObjects){
	          SelectItem sItem = new SelectItem(sObj, sObj.getApellidos());
	          sItems.add(sItem);
	         
	      }
		
		return sItems;
	}
	
	
	public List<SelectItem> getLeftSideValues(){
		
		Query q = getEntityManager().createNamedQuery("usuariosPorEscuela");
		
			q.setParameter("parametro", 15L);
			
	      List<Usuario> someObjects = q.getResultList();
	      List<SelectItem> sItems = new ArrayList<SelectItem>(); 
	      for(Usuario sObj : someObjects){
	          SelectItem sItem = new SelectItem(sObj, sObj.getApellidos());
	          sItems.add(sItem);
	          System.out.println(sItem);
	      }
	      return sItems;
	}
	
	public void saveMatricula(){
		List<Usuario> someObjects=instance.getUsuarios();
		 for(Usuario sObj : someObjects){
			System.out.println(sObj.getCodigoUsuarios());
		}
	}

}
