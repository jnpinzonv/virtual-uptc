package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("facultadHome")
public class FacultadHome extends EntityHome<Facultad> {

	public void setFacultadIdFacultad(Long id) {
		setId(id);
	}

	public Long getFacultadIdFacultad() {
		return (Long) getId();
	}

	@Override
	protected Facultad createInstance() {
		Facultad facultad = new Facultad();
		return facultad;
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

	public Facultad getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Escuela> getListaEscuela() {
		return getInstance() == null ? null : new ArrayList<Escuela>(
				getInstance().getListaEscuela());
	}

}
