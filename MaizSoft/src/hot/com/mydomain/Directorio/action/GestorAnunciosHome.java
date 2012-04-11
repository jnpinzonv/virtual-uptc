package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorAnunciosHome")
public class GestorAnunciosHome extends EntityHome<GestorAnuncios> {

	@In(create = true)
	GrupoCursoHome grupoCursoHome;
	@In(create = true)
	UserAccountHome userAccountHome;

	public void setGestorAnunciosIdAnuncio(Long id) {
		setId(id);
	}

	public Long getGestorAnunciosIdAnuncio() {
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
		GrupoCurso grupoCursoAnuncio = grupoCursoHome.getDefinedInstance();
		if (grupoCursoAnuncio != null) {
			getInstance().setGrupoCursoAnuncio(grupoCursoAnuncio);
		}
		UserAccount userAccountAnuncio = userAccountHome.getDefinedInstance();
		if (userAccountAnuncio != null) {
			getInstance().setUserAccountAnuncio(userAccountAnuncio);
		}
	}

	public boolean isWired() {
		return true;
	}

	public GestorAnuncios getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
