package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("historialNotasHome")
public class HistorialNotasHome extends EntityHome<HistorialNotas> {

	@In(create = true)
	GrupoCursoHome grupoCursoHome;
	@In(create = true)
	UsuarioHome usuarioHome;

	public void setHistorialNotasIdHistorialNotas(Long id) {
		setId(id);
	}

	public Long getHistorialNotasIdHistorialNotas() {
		return (Long) getId();
	}

	@Override
	protected HistorialNotas createInstance() {
		HistorialNotas historialNotas = new HistorialNotas();
		return historialNotas;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		GrupoCurso grupoCurso = grupoCursoHome.getDefinedInstance();
		if (grupoCurso != null) {
			getInstance().setGrupoCurso(grupoCurso);
		}
		Usuario userAccount = usuarioHome.getDefinedInstance();
		if (userAccount != null) {
			getInstance().setUserAccount(userAccount);
		}
	}

	public boolean isWired() {
		if (getInstance().getGrupoCurso() == null)
			return false;
		if (getInstance().getUserAccount() == null)
			return false;
		return true;
	}

	public HistorialNotas getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
