package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("userAccountHome")
public class UserAccountHome extends EntityHome<UserAccount> {

	@In(create = true)
	GrupoCursoHome grupoCursoHome;

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
		GrupoCurso grupoCurso = grupoCursoHome.getDefinedInstance();
		if (grupoCurso != null) {
			getInstance().setGrupoCurso(grupoCurso);
		}
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
