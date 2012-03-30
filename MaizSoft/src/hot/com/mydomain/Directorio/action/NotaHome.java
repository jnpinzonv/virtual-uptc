package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("notaHome")
public class NotaHome extends EntityHome<Nota> {

	@In(create = true)
	ActividadHome actividadHome;

	public void setNotaIdNota(Long id) {
		setId(id);
	}

	public Long getNotaIdNota() {
		return (Long) getId();
	}

	@Override
	protected Nota createInstance() {
		Nota nota = new Nota();
		return nota;
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
		return true;
	}

	public Nota getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
