package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorBibliotecasHome")
public class GestorBibliotecasHome extends EntityHome<GestorBibliotecas> {

	public void setGestorBibliotecasIdBiblioteca(Long id) {
		setId(id);
	}

	public Long getGestorBibliotecasIdBiblioteca() {
		return (Long) getId();
	}

	@Override
	protected GestorBibliotecas createInstance() {
		GestorBibliotecas gestorBibliotecas = new GestorBibliotecas();
		return gestorBibliotecas;
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

	public GestorBibliotecas getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
