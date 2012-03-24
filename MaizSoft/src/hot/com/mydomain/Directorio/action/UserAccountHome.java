package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;

import org.hibernate.search.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("userAccountHome")
public class UserAccountHome extends EntityHome<UserAccount> {

	public void setUserAccountUsername(String id) {
		setId(id);
	}

	public String getUserAccountUsername() {
		return (String) getId();
	}

	@Override
	protected UserAccount createInstance() {
		UserAccount userAccount = new UserAccount();
		return userAccount;
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

	public UserAccount getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}
	
	@org.jboss.seam.annotations.Factory ("listaTipoDocumento")
	public TipoDocumento[] getListaTipoDocumento(){
		return TipoDocumento.values();
	}

}
