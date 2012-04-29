package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tipoHome")
public class TipoHome extends EntityHome<Tipo> {

	@In(create = true)
	TipoHome tipoHome;

	public void setTipoIdTipo(Long id) {
		setId(id);
	}

	public Long getTipoIdTipo() {
		return (Long) getId();
	}

	@Override
	protected Tipo createInstance() {
		Tipo tipo = new Tipo();
		return tipo;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Tipo getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Actividad> getActividad() {
		return getInstance() == null ? null : new ArrayList<Actividad>(
				getInstance().getActividad());
	}
	public List<EnteUniversitario> getEnteUniversitarios() {
		return getInstance() == null ? null : new ArrayList<EnteUniversitario>(
				getInstance().getEnteUniversitarios());
	}
	public List<GestorCargaArchivos> getGestorCargaArchivos() {
		return getInstance() == null
				? null
				: new ArrayList<GestorCargaArchivos>(getInstance()
						.getGestorCargaArchivos());
	}
	public List<GestorRepositoriosVirtuales> getGestorRepositoriosVirtuales() {
		return getInstance() == null
				? null
				: new ArrayList<GestorRepositoriosVirtuales>(getInstance()
						.getGestorRepositoriosVirtuales());
	}
	public List<GestorMensajeria> getListaGestorMensajeria() {
		return getInstance() == null ? null : new ArrayList<GestorMensajeria>(
				getInstance().getListaGestorMensajeria());
	}
	public List<Tipo> getListaTipo() {
		return getInstance() == null ? null : new ArrayList<Tipo>(getInstance()
				.getListaTipo());
	}
	public List<UserAccount> getUserAccount() {
		return getInstance() == null ? null : new ArrayList<UserAccount>(
				getInstance().getUserAccount());
	}

}
