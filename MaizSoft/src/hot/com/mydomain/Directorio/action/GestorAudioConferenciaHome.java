package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorAudioConferenciaHome")
public class GestorAudioConferenciaHome
		extends
			EntityHome<GestorAudioConferencia> {

	@In(create = true)
	GrupoCursoHome grupoCursoHome;
	@In(create = true)
	UserAccountHome userAccountHome;

	public void setGestorAudioConferenciaIdAudioConferencia(Long id) {
		setId(id);
	}

	public Long getGestorAudioConferenciaIdAudioConferencia() {
		return (Long) getId();
	}

	@Override
	protected GestorAudioConferencia createInstance() {
		GestorAudioConferencia gestorAudioConferencia = new GestorAudioConferencia();
		return gestorAudioConferencia;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		GrupoCurso grupoCursoAudio = grupoCursoHome.getDefinedInstance();
		if (grupoCursoAudio != null) {
			getInstance().setGrupoCursoAudio(grupoCursoAudio);
		}
		UserAccount usuarioCreador = userAccountHome.getDefinedInstance();
		if (usuarioCreador != null) {
			getInstance().setUsuarioCreador(usuarioCreador);
		}
	}

	public boolean isWired() {
		return true;
	}

	public GestorAudioConferencia getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
