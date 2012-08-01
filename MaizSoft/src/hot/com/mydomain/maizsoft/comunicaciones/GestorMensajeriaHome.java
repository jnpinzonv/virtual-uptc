package com.mydomain.maizsoft.comunicaciones;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.security.Credentials;

import com.mydomain.Directorio.model.Actividad;
import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.GestorMensajeria;
import com.mydomain.Directorio.model.GrupoUsuarios;
import com.mydomain.Directorio.model.NotaActividad;
import com.mydomain.Directorio.model.ReceptorMensajes;
import com.mydomain.Directorio.model.Tipo;
import com.mydomain.Directorio.model.Usuario;
import com.mydomain.maizsoft.academia.ActividadHome;
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
	ActividadHome actividadHome;

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

	public List<GrupoUsuarios> listaGrupoUsuarios() {
		Query q = getEntityManager().createQuery(
				ConsultasJpql.GRUPO_USUARIOS_SELECIONADO);

		List<GrupoUsuarios> nuevo = (List<GrupoUsuarios>) q.getResultList();
		return nuevo;

	}

	@Factory("listaUsuarioCursos")
	public List<SelectItem> listaUsuariosCurso() {

		// q.setParameter("parametro",
		// "#{cursoActualBean.seleccionado.idGrupo}"));
		List<GrupoUsuarios> listaGruposUsuarios = listaGrupoUsuarios();

		if (listaGruposUsuarios.size() == 0) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Algo malo a sucedido :-( por favor vuelva a seleccionar el curso");
		}

		List<SelectItem> sItems = new ArrayList<SelectItem>();
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		for (GrupoUsuarios sObj : listaGruposUsuarios) {
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
		nuevoG.setMensaje(prepocesar(nuevoG.getMensaje(),40));
		nuevoG.setAsunto(prepocesar(nuevoG.getAsunto(), 10));
		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);

		Query q = getEntityManager().createQuery(
				ConsultasJpql.USUARIO_POR_USERNAME).setParameter("parametro",
				cre.getUsername());
		Usuario deUsuario = (Usuario) q.getSingleResult();
		nuevoG.setDeUsuario(deUsuario);
		Calendar calendar = Calendar.getInstance();

		for (Usuario sObj : someObjects) {
			ReceptorMensajes nuevo = new ReceptorMensajes();
			nuevo.setUserAccount(sObj);
			nuevoG.setTipo(getEntityManager().find(Tipo.class, 9L));
			nuevo.setGestorMensajeria(nuevoG);
			nuevo.setLeido(false);
			nuevoG.setFechaEnvio(calendar.getTime());

			getEntityManager().persist(nuevoG);
			getEntityManager().persist(nuevo);
		}
	}

	@Factory("listaMensajesPorUsuario")
	public List<GestorMensajeria> listaMensajesPorUsuario() {

		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);

		Query q = getEntityManager().createQuery(
				ConsultasJpql.LISTA_MENSAJES_USUARIO);
		q.setParameter("parametro", cre.getUsername());
		List<GestorMensajeria> lista = (List<GestorMensajeria>) q
				.getResultList();

		return lista;
	}

	@Factory("listaMensajesEnviadosPorUsuario")
	public List<GestorMensajeria> listaMensajesEnviadosPorUsuario() {

		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);

		Query q = getEntityManager().createQuery(
				ConsultasJpql.LISTA_MENSAJES_ENVIADOS_USUARIO);
		q.setParameter("parametro", cre.getUsername());
		List<GestorMensajeria> lista = (List<GestorMensajeria>) q
				.getResultList();

		return lista;
	}
	
	public String irForo() {
		listaGrupoUsuarios();
		return "/ForoEdit.seam";
	}

	public String prepocesar(String nuevo, int maximo) {

		int subFinal = maximo;

		StringBuffer mensaje = new StringBuffer();
		int i = 0;

		while (i < nuevo.length()) {

			if (subFinal > nuevo.length())
				subFinal = nuevo.length();

			String nuw = nuevo.substring(i, subFinal);

			mensaje.append(nuw);
			mensaje.append("</br>");
			i = subFinal;
			subFinal += 30;

		}
		return mensaje.toString();
	}

	public void saveForo() {
		List<GrupoUsuarios> listaEntesUniversitarios = listaGrupoUsuarios();

		GestorMensajeria nuevoG = instance;
		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);

		Query q = getEntityManager().createQuery(
				ConsultasJpql.USUARIO_POR_USERNAME).setParameter("parametro",
				cre.getUsername());
		Usuario deUsuario = (Usuario) q.getSingleResult();
		nuevoG.setDeUsuario(deUsuario);
		Calendar calendar = Calendar.getInstance();
		Actividad nuevaActividad = actividadHome.getInstance();
		nuevaActividad.setTipo(getEntityManager().find(Tipo.class, 11L));
		nuevaActividad.setDescripcionActividad(gestorMensajeriaHome.instance
				.getMensaje());
		nuevaActividad.setFechaCreacion(calendar.getTime());

		for (GrupoUsuarios sObj : listaEntesUniversitarios) {
			ReceptorMensajes nuevo = new ReceptorMensajes();
			nuevo.setUserAccount(sObj.getUserGrupoCurso());
			nuevoG.setTipo(getEntityManager().find(Tipo.class, 7L));
			nuevo.setGestorMensajeria(nuevoG);
			nuevo.setLeido(false);
			nuevoG.setFechaEnvio(calendar.getTime());

			NotaActividad nuevaNota = new NotaActividad();
			nuevaNota.setActividad(nuevaActividad);
			nuevaNota.setGestorMensajeria(nuevoG);
			nuevaNota.setUsuario(sObj.getUserGrupoCurso());
			nuevaNota.setGrupoCurso(sObj);
			nuevaNota.setNota(4.3);

			getEntityManager().persist(nuevoG);
			getEntityManager().persist(nuevo);
			getEntityManager().persist(nuevaActividad);
			getEntityManager().persist(nuevaNota);

		}

	}

}
