package com.mydomain.maizsoft.comunicaciones;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.security.Credentials;

import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.CuentasUsuario;
import com.mydomain.Directorio.model.GestorMensajeria;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.GrupoUsuarios;
import com.mydomain.Directorio.model.NotaActividad;
import com.mydomain.Directorio.model.ReceptorMensajes;
import com.mydomain.Directorio.model.Tipo;
import com.mydomain.Directorio.model.Usuario;
import com.mydomain.maizsoft.curso.GrupoCursoHome;
import com.mydomain.maizsoft.tipos.TipoHome;
import com.mydomain.maizsoft.usuarios.UsuarioHome;

@Name("gestorMensajeriaHome")
public class GestorMensajeriaHome extends EntityHome<GestorMensajeria> {

	@In(create = true)
	UsuarioHome usuarioHome;
	@In(create = true)
	GestorMensajeriaHome gestorMensajeriaHome;
	@In(create = true)
	TipoHome tipoHome;

	@In(create = true)
	GrupoCursoHome grupoCursoHome;



	public void setGestorMensajeriaIdMensaje(Long id) {
		setId(id);
	}

	public Long getGestorMensajeriaIdMensaje() {
		return (Long) getId();
	}

	@Override
	protected GestorMensajeria createInstance() {
		GestorMensajeria gestorMensajeria = new GestorMensajeria();
		return gestorMensajeria;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Usuario deUsuario = usuarioHome.getDefinedInstance();
		if (deUsuario != null) {
			getInstance().setDeUsuario(deUsuario);
		}
		Tipo tipo = tipoHome.getDefinedInstance();
		if (tipo != null) {
			getInstance().setTipo(tipo);
		}
	}

	public boolean isWired() {
		if (getInstance().getDeUsuario() == null)
			return false;
		if (getInstance().getTipo() == null)
			return false;
		return true;
	}

	public GestorMensajeria getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GestorMensajeria> getListaGestorMensajeria() {
		return getInstance() == null ? null : new ArrayList<GestorMensajeria>(
				getInstance().getListaGestorMensajeria());
	}

	public List<NotaActividad> getNotaActividad() {
		return getInstance() == null ? null : new ArrayList<NotaActividad>(
				getInstance().getNotaActividad());
	}

	@Factory("listaUsuarioCursos")
	public List<SelectItem> listaUsuariosCurso() {

		Query q = getEntityManager()
				.createQuery(
						"select t from GrupoUsuarios t where t.grupoCurso.idGrupo=#{cursoActualBean.seleccionado.idGrupo}");

		// q.setParameter("parametro",
		// "#{cursoActualBean.seleccionado.idGrupo}"));
		List<GrupoUsuarios> listaEntesUniversitarios = (List<GrupoUsuarios>) q
				.getResultList();

		List<SelectItem> sItems = new ArrayList<SelectItem>();
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		for (GrupoUsuarios sObj : listaEntesUniversitarios) {
			listaUsuarios.add(sObj.getUserGrupoCurso());
		}

		for (Usuario sObj : listaUsuarios) {
			String var = sObj.getPrimerNombre() + " " + sObj.getApellidos();
			SelectItem sItem = new SelectItem(sObj, var);
			sItems.add(sItem);
		}
		return sItems;
	}

	public void saveMensaje() {
		List<Usuario> someObjects = instance.getListaUsuarios();
		GestorMensajeria nuevoG = instance;
		Calendar calendar = Calendar.getInstance();
		
		for (Usuario sObj : someObjects) {
			ReceptorMensajes nuevo = new ReceptorMensajes();
			nuevo.setUserAccount(sObj);
			nuevoG.setTipo(getEntityManager().find(Tipo.class, 9L));
			nuevo.setGestorMensajeria(nuevoG);
			nuevoG.setFechaEnvio(calendar.getTime());
			nuevoG.setDeUsuario(sObj);

			getEntityManager().persist(nuevoG);
			getEntityManager().persist(nuevo);
		}
	}
	
	@Factory ("listaMensajesPorUsuario")
	public List<GestorMensajeria> listaMensajesPorUsuario(){
		
		Credentials cre=(Credentials)Component.getInstance(Credentials.class);
		
		Query q = getEntityManager().createQuery(ConsultasJpql.LISTA_MENSAJES_USUARIO);
		q.setParameter("parametro", cre.getUsername());
		
		
		
		return (List<GestorMensajeria>)q.getResultList();
	}

}
