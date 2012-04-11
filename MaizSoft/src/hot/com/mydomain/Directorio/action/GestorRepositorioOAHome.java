package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorRepositorioOAHome")
public class GestorRepositorioOAHome extends EntityHome<GestorRepositorioOA> {

	public void setGestorRepositorioOAIdRepositorio(Long id) {
		setId(id);
	}

	public Long getGestorRepositorioOAIdRepositorio() {
		return (Long) getId();
	}

	@Override
	protected GestorRepositorioOA createInstance() {
		GestorRepositorioOA gestorRepositorioOA = new GestorRepositorioOA();
		return gestorRepositorioOA;
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

	public GestorRepositorioOA getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
