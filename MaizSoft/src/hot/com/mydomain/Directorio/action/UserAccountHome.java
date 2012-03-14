package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;


import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("userAccountHome")
public class UserAccountHome extends EntityHome<UserAccount> {

	public void setUserAccountId(Long id) {
		setId(id);
	}

	public Long getUserAccountId() {
		return (Long) getId();
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

	/* (non-Javadoc)
	 * @see org.jboss.seam.framework.EntityHome#create()
	 */
	
	@Factory("listaTipoDocumentos")
	public TipoDocumento[] getTipoDocumentos(){
		return TipoDocumento.values();
	}
}
