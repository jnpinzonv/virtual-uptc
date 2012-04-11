package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorVideoConferenciaHome")
public class GestorVideoConferenciaHome
		extends
			EntityHome<GestorVideoConferencia> {

	@In(create = true)
	GrupoCursoHome grupoCursoHome;
	@In(create = true)
	UserAccountHome userAccountHome;

	public void setGestorVideoConferenciaIdvideoConferencia(Long id) {
		setId(id);
	}

	public Long getGestorVideoConferenciaIdvideoConferencia() {
		return (Long) getId();
	}

	@Override
	protected GestorVideoConferencia createInstance() {
		GestorVideoConferencia gestorVideoConferencia = new GestorVideoConferencia();
		return gestorVideoConferencia;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		GrupoCurso grupoCursoVideo = grupoCursoHome.getDefinedInstance();
		if (grupoCursoVideo != null) {
			getInstance().setGrupoCursoVideo(grupoCursoVideo);
		}
		UserAccount usuarioCreador = userAccountHome.getDefinedInstance();
		if (usuarioCreador != null) {
			getInstance().setUsuarioCreador(usuarioCreador);
		}
	}

	public boolean isWired() {
		return true;
	}

	public GestorVideoConferencia getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
