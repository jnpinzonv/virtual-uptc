package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorMensajeriaHome")
public class GestorMensajeriaHome extends EntityHome<GestorMensajeria> {

	@In(create = true)
	UserAccountHome userAccountHome;
	@In(create = true)
	GestorMensajeriaHome gestorMensajeriaHome;
	@In(create = true)
	TipoHome tipoHome;

	public void setGestorMensajeriaIdMensaje(Long id) {
		setId(id);
	}

	public Long getGestorMensajeriaIdMensaje() {
		return (Long) getId();
	}

	@Override
	protected GestorMensajeria createInstance() {
		GestorMensajeria gestorMensajeria = new GestorMensajeria();
		return gestorMensajeria;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		UserAccount deUsuario = userAccountHome.getDefinedInstance();
		if (deUsuario != null) {
			getInstance().setDeUsuario(deUsuario);
		}
		Tipo tipo = tipoHome.getDefinedInstance();
		if (tipo != null) {
			getInstance().setTipo(tipo);
		}
	}

	public boolean isWired() {
		if (getInstance().getDeUsuario() == null)
			return false;
		if (getInstance().getTipo() == null)
			return false;
		return true;
	}

	public GestorMensajeria getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GestorMensajeria> getListaGestorMensajeria() {
		return getInstance() == null ? null : new ArrayList<GestorMensajeria>(
				getInstance().getListaGestorMensajeria());
	}
	public List<NotaActividad> getNotaActividad() {
		return getInstance() == null ? null : new ArrayList<NotaActividad>(
				getInstance().getNotaActividad());
	}

}
