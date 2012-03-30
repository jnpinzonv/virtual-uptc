package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("escuelaHome")
public class EscuelaHome extends EntityHome<Escuela> {

	@In(create = true)
	FacultadHome facultadHome;

	public void setEscuelaIdEscuela(Long id) {
		setId(id);
	}

	public Long getEscuelaIdEscuela() {
		return (Long) getId();
	}

	@Override
	protected Escuela createInstance() {
		Escuela escuela = new Escuela();
		return escuela;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Facultad facultad = facultadHome.getDefinedInstance();
		if (facultad != null) {
			getInstance().setFacultad(facultad);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Escuela getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Curso> getListaCursosOfrecidos() {
		return getInstance() == null ? null : new ArrayList<Curso>(
				getInstance().getListaCursosOfrecidos());
	}

}
