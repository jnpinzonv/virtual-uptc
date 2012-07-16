package com.mydomain.maizsoft.academia;

import com.mydomain.Directorio.model.*;
import com.mydomain.maizsoft.tipos.TipoHome;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.security.Credentials;

@Name("actividadHome")
public class ActividadHome extends EntityHome<Actividad> {

	@In(create = true)
	TipoHome tipoHome;

	public void setActividadIdActividad(Long id) {
		setId(id);
	}

	public Long getActividadIdActividad() {
		return (Long) getId();
	}

	@Override
	protected Actividad createInstance() {
		Actividad actividad = new Actividad();
		return actividad;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Tipo tipo = tipoHome.getDefinedInstance();
		if (tipo != null) {
			getInstance().setTipo(tipo);
		}
	}

	public boolean isWired() {
		if (getInstance().getTipo() == null)
			return false;
		return true;
	}

	public Actividad getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GestorAnuncios> getGestorAnuncios() {
		return getInstance() == null ? null : new ArrayList<GestorAnuncios>(
				getInstance().getGestorAnuncios());
	}
	public List<NotaActividad> getListaNotaActividades() {
		return getInstance() == null ? null : new ArrayList<NotaActividad>(
				getInstance().getListaNotaActividades());
	}
	
	@Factory("listaTiposActividades")
	public List<Tipo> listaTiposEntesUniversitarios() {

		Query q = getEntityManager()
				.createQuery("select t from Tipo t where t.tipo=10");
		List<Tipo> listaTiposEnteUniversitarios = (List<Tipo>)q.getResultList();
	
		return listaTiposEnteUniversitarios;
	}
	
	public List<GrupoUsuarios> listaGrupoUsuarios(){
		Query q = getEntityManager().createQuery(
				ConsultasJpql.GRUPO_USUARIOS_SELECIONADO);
		return (List<GrupoUsuarios>) q
				.getResultList();
		
	}
	
	public void saveActividad(){
		
		List<GrupoUsuarios> listaEntesUniversitarios = listaGrupoUsuarios();	
		
		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);

		Query q = getEntityManager().createQuery(
				ConsultasJpql.USUARIO_POR_USERNAME).setParameter("parametro",
				cre.getUsername());
		Calendar calendar = Calendar.getInstance();
	
		instance.setFechaCreacion(calendar.getTime());
		Usuario usuario=(Usuario)q.getSingleResult();
		instance.setUsuario(usuario);
		GestorCargaArchivos archivo=new GestorCargaArchivos();
		if(instance.isAdjuntarArchivo()==true){
			
			archivo.setDescripcion(instance.getDescripcionActividad());
			archivo.setNombre(instance.getNombreArchivo());
			archivo.setRuta(instance.getRutaArchivo());
			archivo.setTipo(getEntityManager().find(Tipo.class,12L));
			getEntityManager().persist(archivo);		
			
	}
		
		for (GrupoUsuarios sObj : listaEntesUniversitarios) {
			
			NotaActividad nuevaNota= new NotaActividad();
			nuevaNota.setActividad(instance);	
			nuevaNota.setUsuario(sObj.getUserGrupoCurso());
			nuevaNota.setGrupoCurso(sObj);
			nuevaNota.setNota(0.0);	
			
			if((instance.isAdjuntarArchivo()==true)&&sObj.getUserGrupoCurso().getId()==usuario.getId()){
				nuevaNota.setGestorCargaArchivos(archivo);
			}
			
			getEntityManager().persist(instance);
			getEntityManager().persist(nuevaNota);
			
		}
		
	
	}
}
