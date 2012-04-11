package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorMensajeriaHome")
public class GestorMensajeriaHome extends EntityHome<GestorMensajeria> {

	@In(create = true)
	UserAccountHome userAccountHome;

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
	}

	public boolean isWired() {
		return true;
	}

	public GestorMensajeria getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
