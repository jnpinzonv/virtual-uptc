package com.mydomain.maizsoft.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.framework.EntityHome;

import com.mydomain.Directorio.model.ConfiguracionesSistema;
import com.mydomain.Directorio.model.ConsultasJpql;
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
		/*
		 * CuentasUsuario userRole = cuentasUsuarioHome.getDefinedInstance();
		 * 
		 * if (userRole != null) { getInstance().setUserRole(userRole); }
		 */

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
			ConfiguracionesSistema padre = getEntityManager().find(
					ConfiguracionesSistema.class, 3l);

			q.setParameter("parametro",
					Long.parseLong(padre.getDetallesPropiedad()));

			listaEntesUniversitarios = (List<EnteUniversitario>) q
					.getResultList();
		} else {

			q.setParameter("parametro", instance.getEnteUniversitarioPadre()
					.getIdEnteUniversitario());

			ConfiguracionesSistema padre = getEntityManager().find(
					ConfiguracionesSistema.class, 3l);
			padre.setDetallesPropiedad(instance.getEnteUniversitarioPadre()
					.getIdEnteUniversitario() + "");
			getEntityManager().merge(padre);
			getEntityManager().flush();

			listaEntesUniversitarios = (List<EnteUniversitario>) q
					.getResultList();
		}
		return listaEntesUniversitarios;
	}

	@Factory("listaGruposPorCurso")
	public List<GrupoCurso> listagGruposPorCurso() {

		List<GrupoCurso> listaGruposPorCurso = new ArrayList<GrupoCurso>();
		Query q = getEntityManager().createNamedQuery("gruposPorCurso");
		if (instance.getCurso() == null) {
			ConfiguracionesSistema curso = getEntityManager().find(
					ConfiguracionesSistema.class, 5l);
			q.setParameter("parametro",
					Long.parseLong(curso.getDetallesPropiedad()));
			listaGruposPorCurso = (List<GrupoCurso>) q.getResultList();
		} else {

			q.setParameter("parametro", instance.getCurso().getCodigo());
			ConfiguracionesSistema padre = getEntityManager().find(
					ConfiguracionesSistema.class, 5l);
			padre.setDetallesPropiedad(instance.getCurso().getCodigo() + "");
			getEntityManager().merge(padre);
			getEntityManager().flush();
			listaGruposPorCurso = (List<GrupoCurso>) q.getResultList();
		}
		return listaGruposPorCurso;
	}

	@Factory("listaCursoMatricula")
	public List<Curso> listaCursoMatricula() {

		List<Curso> listaCursoMatricula = new ArrayList<Curso>();
		Query q = getEntityManager().createNamedQuery("cursosPorEscuela");
		if (instance.getEnteUniversitarioHijo() == null) {
			ConfiguracionesSistema hijo = getEntityManager().find(
					ConfiguracionesSistema.class, 4l);
			q.setParameter("parametro",
					Long.parseLong(hijo.getDetallesPropiedad()));
			listaCursoMatricula = (List<Curso>) q.getResultList();
		} else {

			q.setParameter("parametro", instance.getEnteUniversitarioHijo()
					.getIdEnteUniversitario());
			ConfiguracionesSistema padre = getEntityManager().find(
					ConfiguracionesSistema.class, 4l);
			padre.setDetallesPropiedad(instance.getEnteUniversitarioHijo()
					.getIdEnteUniversitario() + "");
			getEntityManager().merge(padre);
			getEntityManager().flush();
			listaCursoMatricula = (List<Curso>) q.getResultList();
		}
		return listaCursoMatricula;
	}

	@Factory("listaUsuariosEscuela")
	public List<SelectItem> listaUsuariosEscuela() {
		List<SelectItem> sItems = new ArrayList<SelectItem>();
		List<Usuario> listaUsuariosEscuela = new ArrayList<Usuario>();
		Query q = getEntityManager().createQuery(
				ConsultasJpql.USUARIOS_POR_ROL_Y_ENTEUNIVERSITARIO);
		if (instance.getEnteUniversitarioHijo() == null) {
			ConfiguracionesSistema curso = getEntityManager().find(
					ConfiguracionesSistema.class, 4l);
			ConfiguracionesSistema role = getEntityManager().find(
					ConfiguracionesSistema.class, 7l);
			q.setParameter("roles", instance.getRole());

			q.setParameter("escuela",
					Long.parseLong(curso.getDetallesPropiedad()));
			listaUsuariosEscuela = (List<Usuario>) q.getResultList();
		} else {
			ConfiguracionesSistema padre = getEntityManager().find(
					ConfiguracionesSistema.class, 7l);
			q.setParameter("roles", instance.getRole());
			q.setParameter("escuela", instance.getEnteUniversitarioHijo()
					.getIdEnteUniversitario());

			listaUsuariosEscuela = (List<Usuario>) q.getResultList();
		}
		List<Usuario> someObjects = listaUsuariosEscuela;
		for (Usuario sObj : someObjects) {
			String var = sObj.getCodigoUsuarios() + "   "
					+ sObj.getPrimerNombre() + " " + sObj.getApellidos();
			SelectItem sItem = new SelectItem(sObj, var);
			sItems.add(sItem);
		}
		return sItems;
	}

	public String saveMatricula() {

		if (instance.getUsuarios().size() > 0) {
			List<Usuario> someObjects = instance.getUsuarios();
			GrupoCurso gr = instance.getGrupoCurso();
			for (Usuario sObj : someObjects) {
				GrupoUsuarios nuevo = new GrupoUsuarios();
				nuevo.setUserGrupoCurso(sObj);
				nuevo.setGrupoCurso(gr);
				Query q = getEntityManager().createNamedQuery(
						"buscarCuentaPorUsuario");
				q.setParameter("parametro", sObj.getDocumentoIdentidad());
				CuentasUsuario nueva = (CuentasUsuario) q.getSingleResult();
				nuevo.setUserRole(nueva);
				getEntityManager().persist(nuevo);
			}
		}
		else{
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Se produjo un error al matricular el Usuario, posible causa: no existe ning�n usuario seleccionado");
		}

		
		return "/CursoList.xhtml";
	}

}
