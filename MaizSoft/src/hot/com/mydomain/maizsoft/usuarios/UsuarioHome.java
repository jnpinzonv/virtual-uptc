package com.mydomain.maizsoft.usuarios;

import com.mydomain.Directorio.model.*;
import com.mydomain.maizsoft.academia.EnteUniversitarioHome;
import com.mydomain.maizsoft.tipos.TipoHome;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.security.management.action.UserAction;

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

	public void saveUsuario() {
		
		userAction.save();
		persist();
		CuentasUsuario nuevoCuenta = new CuentasUsuario();
		nuevoCuenta.setUsuarios(getInstance());
		Query q = getEntityManager()
				.createQuery(
						"select u from UserAccount u where u.username=#{userAction.username}");
		nuevoCuenta.setUserAccounts((UserAccount) q.getSingleResult());
		getEntityManager().persist(nuevoCuenta);
	}
	
	public String crearUsuario(){
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

		Query q = getEntityManager()
				.createQuery("select t from Tipo t where t.tipo=2");
		List<Tipo> listaTiposEnteUniversitarios = (List<Tipo>)q.getResultList();
	
		return listaTiposEnteUniversitarios;
	}
	
	

}
