package com.mydomain.maizsoft.curso;

import com.mydomain.Directorio.model.*;
import com.mydomain.maizsoft.usuarios.CuentasUsuarioHome;
import com.mydomain.maizsoft.usuarios.UsuarioHome;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

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

}
