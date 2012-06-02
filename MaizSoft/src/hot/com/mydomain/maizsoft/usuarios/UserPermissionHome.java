package com.mydomain.maizsoft.usuarios;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("userPermissionHome")
public class UserPermissionHome extends EntityHome<UserPermission> {

	public void setUserPermissionId(Long id) {
		setId(id);
	}

	public Long getUserPermissionId() {
		return (Long) getId();
	}

	@Override
	protected UserPermission createInstance() {
		UserPermission userPermission = new UserPermission();
		return userPermission;
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

	public UserPermission getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
