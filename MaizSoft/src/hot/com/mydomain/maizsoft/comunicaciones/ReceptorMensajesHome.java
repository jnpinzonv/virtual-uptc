package com.mydomain.maizsoft.comunicaciones;

import com.mydomain.Directorio.model.*;
import com.mydomain.maizsoft.usuarios.UsuarioHome;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("receptorMensajesHome")
public class ReceptorMensajesHome extends EntityHome<ReceptorMensajes> {

	@In(create = true)
	GestorMensajeriaHome gestorMensajeriaHome;
	@In(create = true)
	UsuarioHome usuarioHome;

	public void setReceptorMensajesIdReceptormenajes(Long id) {
		setId(id);
	}

	public Long getReceptorMensajesIdReceptormenajes() {
		return (Long) getId();
	}

	@Override
	protected ReceptorMensajes createInstance() {
		ReceptorMensajes receptorMensajes = new ReceptorMensajes();
		return receptorMensajes;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		GestorMensajeria gestorMensajeria = gestorMensajeriaHome
				.getDefinedInstance();
		if (gestorMensajeria != null) {
			getInstance().setGestorMensajeria(gestorMensajeria);
		}
		Usuario userAccount = usuarioHome.getDefinedInstance();
		if (userAccount != null) {
			getInstance().setUserAccount(userAccount);
		}
	}

	public boolean isWired() {
		if (getInstance().getGestorMensajeria() == null)
			return false;
		if (getInstance().getUserAccount() == null)
			return false;
		return true;
	}

	public ReceptorMensajes getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
