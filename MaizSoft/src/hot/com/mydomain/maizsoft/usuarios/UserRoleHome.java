package com.mydomain.maizsoft.usuarios;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("userRoleHome")
public class UserRoleHome extends EntityHome<UserRole> {

	public void setUserRoleId(Long id) {
		setId(id);
	}

	public Long getUserRoleId() {
		return (Long) getId();
	}

	@Override
	protected UserRole createInstance() {
		UserRole userRole = new UserRole();
		return userRole;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public UserRole getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
