package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorAnunciosHome")
public class GestorAnunciosHome extends EntityHome<GestorAnuncios> {

	@In(create = true)
	ActividadHome actividadHome;

	public void setGestorAnunciosIdGestorAnuncios(Long id) {
		setId(id);
	}

	public Long getGestorAnunciosIdGestorAnuncios() {
		return (Long) getId();
	}

	@Override
	protected GestorAnuncios createInstance() {
		GestorAnuncios gestorAnuncios = new GestorAnuncios();
		return gestorAnuncios;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Actividad actividad = actividadHome.getDefinedInstance();
		if (actividad != null) {
			getInstance().setActividad(actividad);
		}
	}

	public boolean isWired() {
		if (getInstance().getActividad() == null)
			return false;
		return true;
	}

	public GestorAnuncios getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
