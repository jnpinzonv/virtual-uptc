package com.mydomain.maizsoft.academia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;

import com.mydomain.Directorio.model.Actividad;
import com.mydomain.Directorio.model.ConfiguracionesSistema;
import com.mydomain.Directorio.model.ConstantesLog;
import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.EstadisticasGenerales;
import com.mydomain.Directorio.model.GestorCargaArchivos;
import com.mydomain.Directorio.model.GestorEnlacesExternos;
import com.mydomain.Directorio.model.GestorMensajeria;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.GrupoUsuarios;
import com.mydomain.Directorio.model.NotaActividad;
import com.mydomain.Directorio.model.NumeroDivisiones;
import com.mydomain.Directorio.model.ReceptorMensajes;
import com.mydomain.Directorio.model.Tipo;
import com.mydomain.Directorio.model.Usuario;
import com.mydomain.maizsoft.cargaarchivos.CargaArchivosBean;
import com.mydomain.maizsoft.cargaarchivos.ICargaArchivos;
import com.mydomain.maizsoft.comunicaciones.GestorEnvioCorreoElectronico;
import com.mydomain.maizsoft.gestores.GestorCargaArchivosHome;
import com.mydomain.maizsoft.tipos.TipoHome;

@Name("actividadHome")
public class ActividadHome extends EntityHome<Actividad> {

	@Logger
	private Log log;

	@In(create = true)
	TipoHome tipoHome;

	@In(create = true)
	GestorCargaArchivosHome gestorCargaArchivosHome;

	@In(create = true)
	ICargaArchivos cargaArchivosBean;

	Long idCurso;

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

	public List<NotaActividad> getListaNotaActividades() {
		return getInstance() == null ? null : new ArrayList<NotaActividad>(
				getInstance().getListaNotaActividades());
	}

	@Factory("listaTiposActividades")
	public List<Tipo> listaTiposEntesUniversitarios() {

		Query q = getEntityManager().createQuery(
				"select t from Tipo t where t.tipo=10");
		List<Tipo> listaTiposEnteUniversitarios = (List<Tipo>) q
				.getResultList();

		return listaTiposEnteUniversitarios;
	}

	public List<GrupoUsuarios> listaGrupoUsuarios(Long param) {
		Query q = getEntityManager().createQuery(
				ConsultasJpql.GRUPO_USUARIOS_SELECIONADO);
		// q.setParameter("parametro",param);
		return (List<GrupoUsuarios>) q.getResultList();

	}

	public String grupoSelecionado() {
		GrupoCurso g = null;
		try {

			Query q = getEntityManager().createQuery(
					ConsultasJpql.GRUPO_SELECCIONDADO);
			g = (GrupoCurso) q.getSingleResult();
		} catch (Exception e) {
			return "";
		}
		// q.setParameter("parametro",param);
		return g.getCursoGrupo().getNombreAsignatura();

	}

	public String saveActividad(int pasarSeccion, long idCursoSeleccionado) {

		List<GrupoUsuarios> listaGrupos = listaGrupoUsuarios(idCursoSeleccionado);
		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);

		Query q = getEntityManager().createQuery(
				ConsultasJpql.USUARIO_POR_USERNAME).setParameter("parametro",
				cre.getUsername());
		Calendar calendar = Calendar.getInstance();

		instance.setFechaCreacion(calendar.getTime());
		Usuario usuario = (Usuario) q.getSingleResult();
		instance.setUsuario(usuario);

		crearNotaActividad(listaGrupos, usuario);

		NumeroDivisiones division = new NumeroDivisiones();
		division.setActividad(instance);
		division.setGrupoCurso(listaGrupos.get(0).getGrupoCurso());
		division.setNumeroDivision(pasarSeccion);
		getEntityManager().persist(division);

		if (instance.getTipo().getIdTipo() == 17) {
			crearGestorEnlaces(instance, listaGrupos.get(0).getGrupoCurso());
		}

		if (instance.isAlertaMail() == true) {
			enviarEmail(listaGrupos, instance);
		}

		
		try {
			crearLog(listaGrupos.get(0).getGrupoCurso());

		} catch (RuntimeException e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Algo malo a sucedido :-(  por favor vuelva a seleccionar el curso");
			return "";
		}

		instance = null;
		return "/CuerpoCurso.xhtml";
	}

	public GestorMensajeria crearForo(List<GrupoUsuarios> usuarios, Usuario usuario) {
		System.out.println("Holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		Calendar calendar = Calendar.getInstance();
		GestorMensajeria nuevoG = new GestorMensajeria();
		nuevoG.setAsunto(instance.getNombreActividad());
		nuevoG.setMensaje(instance.getDescripcionActividad());
		nuevoG.setDeUsuario(usuario);
		nuevoG.setTipo(getEntityManager().find(Tipo.class, 7L));
		nuevoG.setFechaEnvio(calendar.getTime());
		getEntityManager().persist(nuevoG);
		
		for (GrupoUsuarios sObj : usuarios) {
			ReceptorMensajes nuevo = new ReceptorMensajes();
			nuevo.setUserAccount(sObj.getUserGrupoCurso());			
			nuevo.setGestorMensajeria(nuevoG);
			if(usuario.getId()==sObj.getUserGrupoCurso().getId())
			nuevo.setLeido(true);
			else
			nuevo.setLeido(false);						
			getEntityManager().persist(nuevo);		
		}
		
		
		return nuevoG;
	}

	public GestorEnvioCorreoElectronico crearConfiguracion(Actividad actividad) {

		GestorEnvioCorreoElectronico nuevo = new GestorEnvioCorreoElectronico();
		nuevo.setAsunto("Notificaciï¿½n de nueva Actividad en Plataforma virtual ");

		String mensaje = "Senor(a): Usuario \n"
				+ "Se a creado una nueva actividad o recurso en su plataforma Virtual de Aprendizaje \n"
				+ "realizado por: " + actividad.getUsuario().getPrimerNombre()
				+ " " + actividad.getUsuario().getApellidos() + "\n"
				+ "fecha de creaciï¿½n: " + actividad.getFechaCreacion();
		nuevo.setCuerpoMensaje(mensaje);
		nuevo.setUsernameCorreo(getConfiguracion("correoElectronico")
				.getDetallesPropiedad());
		nuevo.setPasswordCorreo(getConfiguracion("contraseniaCorreo")
				.getDetallesPropiedad());
		nuevo.setRemite(getConfiguracion("correoElectronico")
				.getDetallesPropiedad());

		Properties props = new Properties();
		props.put("mail.smtp.auth", getConfiguracion("mail.smtp.auth")
				.getDetallesPropiedad());
		props.put("mail.smtp.starttls.enable",
				getConfiguracion("mail.smtp.starttls.enable")
						.getDetallesPropiedad());
		props.put("mail.smtp.host", getConfiguracion("mail.smtp.host")
				.getDetallesPropiedad());
		props.put("mail.smtp.port", getConfiguracion("mail.smtp.port")
				.getDetallesPropiedad());

		nuevo.setProps(props);

		return nuevo;
	}

	public void enviarEmail(List<GrupoUsuarios> usuarios, Actividad actividad) {

		GestorEnvioCorreoElectronico nuevo = crearConfiguracion(actividad);

		for (GrupoUsuarios grupoUsuarios : usuarios) {
			try {
				nuevo.setPara(grupoUsuarios.getUserGrupoCurso()
						.getCorreoElectronico());
				nuevo.enviarEmail();

			} catch (AddressException e) {
				FacesMessages mensaje = (FacesMessages) Component
						.getInstance(FacesMessages.class);
				mensaje.add("No es posible enviar Alerta al Usuario:"
						+ grupoUsuarios.getUserGrupoCurso().getCodigoUsuarios()
						+ " posible causa: La direcciï¿½n correo no es valida :(");
			} catch (MessagingException e) {
				FacesMessages mensaje = (FacesMessages) Component
						.getInstance(FacesMessages.class);
				mensaje.add("Se produjo un error técnico :(");
			}
		}

	}

	public ConfiguracionesSistema getConfiguracion(String nombrePropiedad) {

		Query q = getEntityManager().createQuery(
				ConsultasJpql.CONFIGURACIONES_SISTEMA_POR_PROPIEDAD);
		q.setParameter("parametro", nombrePropiedad);

		return (ConfiguracionesSistema) q.getSingleResult();
	}

	public void crearGestorEnlaces(Actividad instance, GrupoCurso curso) {
		GestorEnlacesExternos nuevoGestor = new GestorEnlacesExternos();
		nuevoGestor.setDescripcionEnlace(instance.getDescripcionActividad());
		nuevoGestor.setGrupoCurso(curso);
		nuevoGestor.setNombreEnlace(instance.getNombreEnlace());
		nuevoGestor.setUrlEnlace(instance.getUrlExterna());

		getEntityManager().persist(nuevoGestor);
	}

	public void crearNotaActividad(List<GrupoUsuarios> listaGrupos,
			Usuario usuario) {

		GestorCargaArchivos archivo = new GestorCargaArchivos();
		if (instance.isAdjuntarArchivo() == true) {

			archivo.setDescripcion(instance.getDescripcionActividad());
			archivo.setNombre(instance.getNombreArchivo());
			archivo.setRuta(instance.getRutaArchivo());
			archivo.setTipo(getEntityManager().find(Tipo.class, 12L));
			getEntityManager().persist(archivo);

		}

		if (instance.getTipo().getIdTipo() == 18) {
			archivo.setDescripcion(instance.getDescripcionActividad());
			archivo.setNombre(gestorCargaArchivosHome.getInstance().getNombre());

			archivo.setTipo(getEntityManager().find(Tipo.class, 18L));
			if (instance.getTipoObjeto().equals("1")) {
				archivo.setRuta(instance.getUrlExterna());
				archivo.setNombre(instance.getNombreActividad());
			} else if (instance.getTipoObjeto().equals("Archivo")) {
				archivo.setRuta(gestorCargaArchivosHome.getInstance().getRuta());
				archivo.setNombre(instance.getNombreArchivo());
			} else {

				archivo.setRuta(gestorCargaArchivosHome.getInstance().getRuta());

			}

			getEntityManager().persist(archivo);
		}
		GestorMensajeria nuevo=null;
		if (instance.getTipo().getIdTipo() == 11) 
	    nuevo=crearForo(listaGrupos, usuario);
		
		for (GrupoUsuarios sObj : listaGrupos) {

			NotaActividad nuevaNota = new NotaActividad();
			nuevaNota.setActividad(instance);
			nuevaNota.setUsuario(sObj.getUserGrupoCurso());
			nuevaNota.setGrupoCurso(sObj);
			nuevaNota.setNota(0.0);

			if ((instance.isAdjuntarArchivo() == true)
					&& sObj.getUserGrupoCurso().getId() == usuario.getId()) {
				nuevaNota.setGestorCargaArchivos(archivo);
			}
			if (instance.getTipo().getIdTipo() == 18) {
				nuevaNota.setGestorCargaArchivos(archivo);
			}

			if (instance.isEvaluable() == false) {
				instance.setPorcentaje(0.0);
			}
			
			if (instance.getTipo().getIdTipo() == 11) {
				nuevaNota.setGestorMensajeria(nuevo);
			}


			getEntityManager().persist(instance);
			getEntityManager().persist(nuevaNota);

		}
	}

	public String rutaObjetosAprendizaje() {

		ConfiguracionesSistema path = getEntityManager().find(
				ConfiguracionesSistema.class, 1l);
		ConfiguracionesSistema pathOA = getEntityManager().find(
				ConfiguracionesSistema.class, 18l);
		Credentials credentials = (Credentials) Component
				.getInstance(Credentials.class);

		String pathFinal = path.getDetallesPropiedad() + "//"
				+ pathOA.getDetallesPropiedad() + "//"
				+ credentials.getUsername();
		return pathFinal;
	}

	public List<Actividad> getListaActividadesDivision(Long idTipo) {

		Query q = null;
		List<Actividad> nueva = null;
		try {
			q = getEntityManager().createQuery(
					ConsultasJpql.ACTIVIADES_POR_DIVISION);
			q.setParameter("parametro", idTipo);

			nueva = (List<Actividad>) q.getResultList();

		} catch (Exception e) {
			return null;
		}

		return nueva;

	}

	public void crearLog(GrupoCurso grupo) {
		Calendar calendar = Calendar.getInstance();
		EstadisticasGenerales nueva = new EstadisticasGenerales();
		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);
		log.info("<--" + "[" + ConstantesLog.NOMBRE_PLATAFORMA + "]"
				+ "Acciï¿½n:" + "[" + ConstantesLog.CREAR_ACTIVIDAD + "]"
				+ "Tipo:" + "[" + instance.getTipo().getNombre() + "]"
				+ "Sobre el grupo con ID:" + "[" + grupo.getIdGrupo() + "]"
				+ "Realizada por:" + "[" + cre.getUsername() + "]"
				+ "en la fecha:" + "[" + calendar.getTime() + "]" + "-->",
				cre.getUsername());

		nueva.setAccionElemento(ConstantesLog.CREAR_ACTIVIDAD);
		nueva.setFechaSuceso(calendar.getTime());
		nueva.setLogin(cre.getUsername());
		nueva.setTipo(instance.getTipo().getNombre());
		nueva.setIdGrupoCurso(grupo.getIdGrupo());
		getEntityManager().persist(nueva);
	}

	public String cursoActual(Long actual) {

		instance.setIdCursoSeleccionado(actual);

		return "/ActividadEdit.xhtml";
	}

	/**
	 * Se obtiene el valor de idCurso
	 * 
	 * @return El valor de idCurso
	 */
	public Long getIdCurso() {
		return idCurso;
	}

	/**
	 * Asigna el valor de idCurso
	 * 
	 * @param idCurso
	 *            El valor por establecer para idCurso
	 */
	public void masIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String saveActividadEstudiante() {

		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);

		Query q2 = getEntityManager().createQuery(
				ConsultasJpql.USUARIO_POR_USERNAME).setParameter("parametro",
				cre.getUsername());
		Usuario usuario = (Usuario) q2.getSingleResult();
		Query q = getEntityManager().createQuery(
				ConsultasJpql.AGREGAR_ACTIVIDAD_PARA_NOTA);
		q.setParameter("parametro", usuario.getId());
		q.setParameter("parametro2", instance.getIdActividad());

		NotaActividad notaActividad = (NotaActividad) q.getSingleResult();
		
		if (instance.getTipo().getIdTipo() == 11) {

		}

		else if (instance.getTipo().getIdTipo() == 12) {

			GestorCargaArchivos archivo = new GestorCargaArchivos();
			archivo.setDescripcion(instance.getDescripcionActividad());
			archivo.setNombre(cargaArchivosBean.getNombreArchivo());
			archivo.setRuta(cargaArchivosBean.getRutaFinal());
			archivo.setTipo(getEntityManager().find(Tipo.class, 12L));
			getEntityManager().persist(archivo);
			notaActividad.setGestorCargaArchivos(archivo);
		}

		else if (instance.getTipo().getIdTipo() == 13) {
			notaActividad.setJustificacion(instance.getJustificacion());
		}

		getEntityManager().merge(notaActividad);
		getEntityManager().flush();

		return "/CuerpoCurso.xhtml";
	}
	
	
	public List<ReceptorMensajes> getListaReceptoresForos(Long idActividad){
		Query q = getEntityManager().createQuery(ConsultasJpql.ACTIVIDAD_NOTA_ACTIVIDAD);
		q.setParameter("parametro", idActividad);
		List<Long> n= q.getResultList();
		
		Query q2 = getEntityManager().createQuery(ConsultasJpql.LISTA_FOROS_POR_PARTICIPACION);
		q2.setParameter("parametro", n.get(0));
		
		return q2.getResultList();
	}
}
