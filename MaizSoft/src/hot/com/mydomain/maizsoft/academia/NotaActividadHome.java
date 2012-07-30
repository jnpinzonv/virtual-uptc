package com.mydomain.maizsoft.academia;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.Query;

import com.mydomain.Directorio.model.*;
import com.mydomain.maizsoft.comunicaciones.GestorMensajeriaHome;
import com.mydomain.maizsoft.curso.GrupoUsuariosHome;
import com.mydomain.maizsoft.gestores.GestorCargaArchivosHome;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("notaActividadHome")
public class NotaActividadHome extends EntityHome<NotaActividad> {

	@In(create = true)
	ActividadHome actividadHome;
	@In(create = true)
	GestorCargaArchivosHome gestorCargaArchivosHome;
	@In(create = true)
	GestorMensajeriaHome gestorMensajeriaHome;
	@In(create = true)
	GrupoUsuariosHome grupoUsuariosHome;

	public void setNotaActividadIdNotaActividad(Long id) {
		setId(id);
	}

	public Long getNotaActividadIdNotaActividad() {
		return (Long) getId();
	}

	@Override
	protected NotaActividad createInstance() {
		NotaActividad notaActividad = new NotaActividad();
		return notaActividad;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Actividad actividad = actividadHome.getDefinedInstance();
		if (actividad != null) {
			getInstance().setActividad(actividad);
		}
		GestorCargaArchivos gestorCargaArchivos = gestorCargaArchivosHome
				.getDefinedInstance();
		if (gestorCargaArchivos != null) {
			getInstance().setGestorCargaArchivos(gestorCargaArchivos);
		}
		GestorMensajeria gestorMensajeria = gestorMensajeriaHome
				.getDefinedInstance();
		if (gestorMensajeria != null) {
			getInstance().setGestorMensajeria(gestorMensajeria);
		}
		GrupoUsuarios grupoCurso = grupoUsuariosHome.getDefinedInstance();
		if (grupoCurso != null) {
			getInstance().setGrupoCurso(grupoCurso);
		}
	}

	public boolean isWired() {
		if (getInstance().getActividad() == null)
			return false;
		if (getInstance().getGrupoCurso() == null)
			return false;
		return true;
	}

	public NotaActividad getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	
	
	public void saveActividad(){		
		Query q = getEntityManager().createQuery("select c from GrupoCurso c where c.idGrupo = #{cursoActualBean.seleccionado.idGrupo}");
		GrupoCurso nuevo= (GrupoCurso)q.getSingleResult();		
	}
	
	@Factory("notasActividad")
	public List<NotaActividad> listanotasActividad(Long idActividad) {
		System.out.println("holaaaaaaaaaaaaaaa"+ idActividad);
		Query q = null;
		List<NotaActividad> nueva=null;
			q = getEntityManager().createQuery(
					ConsultasJpql.NOTAS_ACTIVIDAD);
			q.setParameter("parametro",idActividad);
						
		nueva=(List<NotaActividad>)q.getResultList();
			
		return nueva;	
		}
}
