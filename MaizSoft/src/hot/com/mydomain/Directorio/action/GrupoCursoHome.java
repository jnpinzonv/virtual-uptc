package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("grupoCursoHome")
public class GrupoCursoHome extends EntityHome<GrupoCurso> {

	@In(create = true)
	CursoHome cursoHome;

	public void setGrupoCursoIdGrupo(Long id) {
		setId(id);
	}

	public Long getGrupoCursoIdGrupo() {
		return (Long) getId();
	}

	@Override
	protected GrupoCurso createInstance() {
		GrupoCurso grupoCurso = new GrupoCurso();
		return grupoCurso;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Curso cursoGrupo = cursoHome.getDefinedInstance();
		if (cursoGrupo != null) {
			getInstance().setCursoGrupo(cursoGrupo);
		}
	}

	public boolean isWired() {
		return true;
	}

	public GrupoCurso getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Actividad> getActividades() {
		return getInstance() == null ? null : new ArrayList<Actividad>(
				getInstance().getActividades());
	}
	public List<UserAccount> getListaUsuarios() {
		return getInstance() == null ? null : new ArrayList<UserAccount>(
				getInstance().getListaUsuarios());
	}

}
