package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("userAccountHome")
public class UserAccountHome extends EntityHome<UserAccount> {

	@In(create = true)
	EnteUniversitarioHome enteUniversitarioHome;
	@In(create = true)
	TipoHome tipoHome;

	public void setUserAccountId(Long id) {
		setId(id);
	}

	public Long getUserAccountId() {
		return (Long) getId();
	}

	@Override
	protected UserAccount createInstance() {
		UserAccount userAccount = new UserAccount();
		return userAccount;
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

	public UserAccount getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
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

}
