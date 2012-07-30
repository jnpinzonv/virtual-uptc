package com.mydomain.maizsoft.usuarios;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.management.action.UserAction;

import com.mydomain.Directorio.action.StringEncrypter;
import com.mydomain.Directorio.model.ConstantesLog;
import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.CuentasUsuario;
import com.mydomain.Directorio.model.EnteUniversitario;
import com.mydomain.Directorio.model.GestorMensajeria;
import com.mydomain.Directorio.model.GrupoUsuarios;
import com.mydomain.Directorio.model.HistorialNotas;
import com.mydomain.Directorio.model.ReceptorMensajes;
import com.mydomain.Directorio.model.Tipo;
import com.mydomain.Directorio.model.UserAccount;
import com.mydomain.Directorio.model.Usuario;
import com.mydomain.maizsoft.academia.EnteUniversitarioHome;
import com.mydomain.maizsoft.tipos.TipoHome;

@Name("usuarioHome")
public class UsuarioHome extends EntityHome<Usuario> {

	@In(create = true)
	EnteUniversitarioHome enteUniversitarioHome;
	@In(create = true)
	TipoHome tipoHome;

	@In(create = true)
	UserAction userAction;

	public void setUsuarioId(Long id) {
		setId(id);
	}

	public Long getUsuarioId() {
		return (Long) getId();
	}

	@Override
	protected Usuario createInstance() {
		Usuario usuario = new Usuario();
		return usuario;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		EnteUniversitario enteUniversitarios = enteUniversitarioHome
				.getDefinedInstance();
		if (enteUniversitarios != null) {
			getInstance().setEnteUniversitarios(enteUniversitarios);
		}
		Tipo tipo = tipoHome.getDefinedInstance();
		if (tipo != null) {
			getInstance().setTipo(tipo);
		}
	}

	public boolean isWired() {
		if (getInstance().getEnteUniversitarios() == null)
			return false;
		if (getInstance().getTipo() == null)
			return false;
		return true;
	}

	public Usuario getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<CuentasUsuario> getCuentasUsuario() {
		return getInstance() == null ? null : new ArrayList<CuentasUsuario>(
				getInstance().getCuentasUsuario());
	}

	public List<GrupoUsuarios> getGrupoUsuarios() {
		return getInstance() == null ? null : new ArrayList<GrupoUsuarios>(
				getInstance().getGrupoUsuarios());
	}

	public List<HistorialNotas> getHistorialNotas() {
		return getInstance() == null ? null : new ArrayList<HistorialNotas>(
				getInstance().getHistorialNotas());
	}

	public List<ReceptorMensajes> getMensajes() {
		return getInstance() == null ? null : new ArrayList<ReceptorMensajes>(
				getInstance().getMensajes());
	}

	public List<GestorMensajeria> getUsuarioEmisor() {
		return getInstance() == null ? null : new ArrayList<GestorMensajeria>(
				getInstance().getUsuarioEmisor());
	}

	public String saveUsuario() {

		Calendar calendar = Calendar.getInstance();
		List<String> nueva = new ArrayList<String>();
		nueva.add(instance.getRole());
		Date fecha = calendar.getTime();
		instance.setFechaCreacion(fecha);
		userAction.setRoles(nueva);
		userAction.save();
		persist();
		CuentasUsuario nuevoCuenta = new CuentasUsuario();
		nuevoCuenta.setUsuarios(getInstance());
		Query q = getEntityManager()
				.createQuery(
						"select u from UserAccount u where u.username=#{userAction.username}");

		UserAccount nuevo2 = (UserAccount) q.getSingleResult();
		nuevo2.setFechaCreacion(fecha);
		String secretString = userAction.getPassword();
		String passPhrase = ConstantesLog.NOMBRE_PLATAFORMA;

		// Create encrypter/decrypter class
		StringEncrypter desEncrypter = new StringEncrypter(passPhrase);

		// Encrypt the string
		String desEncrypted = desEncrypter.encrypt(secretString);
		nuevo2.setCampoGenerarPassword(desEncrypted);
		getEntityManager().merge(nuevo2);
		nuevoCuenta.setUserAccounts((UserAccount) q.getSingleResult());
		getEntityManager().persist(nuevoCuenta);

		try {
		} catch (RuntimeException e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Se produjo un error al guardar el Usuario, posible causa: El usuario ya existe en el sistema");
			return "";
		}
		return "/UsuarioList.seam";
	}

	public String crearUsuario() {
		userAction.createUser();
		return "/admin/UsuarioEdit.xhtml";
	}

	@Factory("listaEntesUniversitariosEscuelas")
	public List<EnteUniversitario> listaEntesUniversitarios() {
		Query q = getEntityManager()
				.createQuery(
						"select t from EnteUniversitario t where t.tipoEnteUniversitario=20");
		List<EnteUniversitario> listaEntesUniversitarios = (List<EnteUniversitario>) q
				.getResultList();
		return listaEntesUniversitarios;

	}

	@Factory("listaTiposDocumento")
	public List<Tipo> listaTiposEntesUniversitarios() {

		Query q = getEntityManager().createQuery(
				"select t from Tipo t where t.tipo=2");
		List<Tipo> listaTiposEnteUniversitarios = (List<Tipo>) q
				.getResultList();

		return listaTiposEnteUniversitarios;
	}

	public File rutaImagen() {

		String nueva = "css/images/gis.png";
		File nuevoi =null;
		URL nu=null;
		try {

			Credentials cre = (Credentials) Component
					.getInstance(Credentials.class);
			Query q = getEntityManager().createQuery(
					ConsultasJpql.USUARIO_POR_USERNAME);
			q.setParameter("parametro", cre.getUsername());
			Usuario nuevo = (Usuario) q.getSingleResult();
			if (nuevo.getFotoUser() == null)
				nueva = "css/images/gis.png";
			else{
				nueva = nuevo.getFotoUser();
				nuevoi = new File(nueva);
			}
		} catch (RuntimeException e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Algo malo a sucedido :-( ");
		}

		return nuevoi;

	}

}
