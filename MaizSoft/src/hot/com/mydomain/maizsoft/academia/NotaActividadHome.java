package com.mydomain.maizsoft.academia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.Query;

import com.mydomain.Directorio.model.*;
import com.mydomain.maizsoft.comunicaciones.GestorMensajeriaHome;
import com.mydomain.maizsoft.curso.GrupoUsuariosHome;
import com.mydomain.maizsoft.gestores.GestorCargaArchivosHome;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.security.Credentials;

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

	@Factory("notasActividad")
	public List<NotaActividad> listanotasActividad(Long idActividad) {

		Query q = null;
		List<NotaActividad> nueva = null;
		q = getEntityManager().createQuery(ConsultasJpql.NOTAS_ACTIVIDAD);
		q.setParameter("parametro", idActividad);

		nueva = (List<NotaActividad>) q.getResultList();

		return nueva;
	}
	
	@Factory("listaActividadesDes")
	public List<Actividad> getListaActividadesDivision() {
			Query q =null;
			try {
				
			
		 q = getEntityManager().createQuery(
				ConsultasJpql.ACTIVIADES_POR_DIVISION);
		q.setParameter("parametro", instance.getTipo().getIdTipo());
			} catch (Exception e) {
				return new ArrayList<Actividad>();
			}
		return (List<Actividad>) q.getResultList();
	}
		
		
		
		
		public String placebo(Long id){
			
			return"";
		}
		
	
	public void actualizarNota(Long idActividad,double nota){
		
		NotaActividad notaActividad = getEntityManager().find(NotaActividad.class, idActividad);
		notaActividad.setNota(nota);
		getEntityManager().merge(notaActividad);
	}
	
	@Factory("notasUsuario")
	public List<NotasUsuario> listaNotas(){
		Query q = null;
		List<NotasUsuario> nueva=new ArrayList<NotasUsuario>();
		Credentials crede = (Credentials) Component.getInstance(Credentials.class);
		Query q1 = getEntityManager().createQuery(ConsultasJpql.USUARIO_POR_USERNAME);
		q1.setParameter("parametro", crede.getUsername());
		Usuario usu = (Usuario) q1.getSingleResult();
		q = getEntityManager().createNativeQuery(ConsultasJpql.NOTAS_ESTUDIANTE);
		q.setParameter("parametro", usu.getId());	
		
		Iterator results =q.getResultList().iterator();
			
		while ( results.hasNext() ) {
		Object[] row = (Object[]) results.next();
		NotasUsuario nuevoA=new NotasUsuario();
		nuevoA.setNombreAsignatura((String) row[0]);
		nuevoA.setNota((Double) row[1]);
		
		nueva.add(nuevoA);		
	}
		return nueva;
}
	
	
	@Factory("notasHistorialUsuario")
	public List<HistorialNotas> listaHistorialNotas(){
		Query q = null;
		
		Credentials crede = (Credentials) Component.getInstance(Credentials.class);
		Query q1 = getEntityManager().createQuery(ConsultasJpql.USUARIO_POR_USERNAME);
		q1.setParameter("parametro", crede.getUsername());
		Usuario usu = (Usuario) q1.getSingleResult();
		q = getEntityManager().createQuery(ConsultasJpql.HISTORIAL_NOTAS);
		q.setParameter("parametro", usu.getId());	
		
		return q.getResultList();
}

	public List<NotaActividad> listaNotasActividad(){
		Credentials crede = (Credentials) Component.getInstance(Credentials.class);
		Query q1 = getEntityManager().createQuery(ConsultasJpql.ACTIVIDAD_NOTAS_ESTUDIANTE);
		q1.setParameter("parametro", crede.getUsername());
		
		return q1.getResultList();
	}
}