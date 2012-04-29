package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorNoticiasHome")
public class GestorNoticiasHome extends EntityHome<GestorNoticias> {

	public void setGestorNoticiasIdNoticia(Long id) {
		setId(id);
	}

	public Long getGestorNoticiasIdNoticia() {
		return (Long) getId();
	}

	@Override
	protected GestorNoticias createInstance() {
		GestorNoticias gestorNoticias = new GestorNoticias();
		return gestorNoticias;
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

	public GestorNoticias getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
