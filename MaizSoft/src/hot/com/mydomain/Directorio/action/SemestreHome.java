package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("semestreHome")
public class SemestreHome extends EntityHome<Semestre> {

	public void setSemestreIdSemestre(Long id) {
		setId(id);
	}

	public Long getSemestreIdSemestre() {
		return (Long) getId();
	}

	@Override
	protected Semestre createInstance() {
		Semestre semestre = new Semestre();
		return semestre;
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

	public Semestre getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Curso> getCursoSemestre() {
		return getInstance() == null ? null : new ArrayList<Curso>(
				getInstance().getCursoSemestre());
	}

}
