package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("enteUniversitarioHome")
public class EnteUniversitarioHome extends EntityHome<EnteUniversitario> {

	@In(create = true)
	EnteUniversitarioHome enteUniversitarioHome;
	@In(create = true)
	TipoHome tipoHome;

	public void setEnteUniversitarioIdEnteUniversitario(Long id) {
		setId(id);
	}

	public Long getEnteUniversitarioIdEnteUniversitario() {
		return (Long) getId();
	}

	@Override
	protected EnteUniversitario createInstance() {
		EnteUniversitario enteUniversitario = new EnteUniversitario();
		return enteUniversitario;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Tipo tipoEnteUniversitario = tipoHome.getDefinedInstance();
		if (tipoEnteUniversitario != null) {
			getInstance().setTipoEnteUniversitario(tipoEnteUniversitario);
		}
	}

	public boolean isWired() {
		if (getInstance().getTipoEnteUniversitario() == null)
			return false;
		return true;
	}

	public EnteUniversitario getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Curso> getListaCursosOfrecidos() {
		return getInstance() == null ? null : new ArrayList<Curso>(
				getInstance().getListaCursosOfrecidos());
	}
	public List<EnteUniversitario> getListaEnteUniversitarios() {
		return getInstance() == null ? null : new ArrayList<EnteUniversitario>(
				getInstance().getListaEnteUniversitarios());
	}
	public List<UserAccount> getListaUserAccounts() {
		return getInstance() == null ? null : new ArrayList<UserAccount>(
				getInstance().getListaUserAccounts());
	}

}
