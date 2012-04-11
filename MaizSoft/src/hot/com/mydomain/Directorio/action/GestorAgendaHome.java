package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorAgendaHome")
public class GestorAgendaHome extends EntityHome<GestorAgenda> {

	@In(create = true)
	UserAccountHome userAccountHome;

	public void setGestorAgendaIdAgenda(Long id) {
		setId(id);
	}

	public Long getGestorAgendaIdAgenda() {
		return (Long) getId();
	}

	@Override
	protected GestorAgenda createInstance() {
		GestorAgenda gestorAgenda = new GestorAgenda();
		return gestorAgenda;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		UserAccount userAccountAgenda = userAccountHome.getDefinedInstance();
		if (userAccountAgenda != null) {
			getInstance().setUserAccountAgenda(userAccountAgenda);
		}
	}

	public boolean isWired() {
		return true;
	}

	public GestorAgenda getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
