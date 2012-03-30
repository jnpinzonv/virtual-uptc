package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("cursoHome")
public class CursoHome extends EntityHome<Curso> {

	@In(create = true)
	EscuelaHome escuelaHome;
	@In(create = true)
	SemestreHome semestreHome;

	public void setCursoCodigo(Long id) {
		setId(id);
	}

	public Long getCursoCodigo() {
		return (Long) getId();
	}

	@Override
	protected Curso createInstance() {
		Curso curso = new Curso();
		return curso;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Escuela escuelaCurso = escuelaHome.getDefinedInstance();
		if (escuelaCurso != null) {
			getInstance().setEscuelaCurso(escuelaCurso);
		}
		Semestre semestreCurso = semestreHome.getDefinedInstance();
		if (semestreCurso != null) {
			getInstance().setSemestreCurso(semestreCurso);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Curso getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GrupoCurso> getGrupoCursos() {
		return getInstance() == null ? null : new ArrayList<GrupoCurso>(
				getInstance().getGrupoCursos());
	}

}
