package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("actividadHome")
public class ActividadHome extends EntityHome<Actividad> {

	@In(create = true)
	GrupoCursoHome grupoCursoHome;
	@In(create = true)
	NotaHome notaHome;

	public void setActividadIdActividad(Long id) {
		setId(id);
	}

	public Long getActividadIdActividad() {
		return (Long) getId();
	}

	@Override
	protected Actividad createInstance() {
		Actividad actividad = new Actividad();
		return actividad;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		GrupoCurso actividadGrupoCurso = grupoCursoHome.getDefinedInstance();
		if (actividadGrupoCurso != null) {
			getInstance().setActividadGrupoCurso(actividadGrupoCurso);
		}
		Nota nota = notaHome.getDefinedInstance();
		if (nota != null) {
			getInstance().setNota(nota);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Actividad getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
