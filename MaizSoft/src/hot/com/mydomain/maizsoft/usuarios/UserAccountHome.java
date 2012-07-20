package com.mydomain.maizsoft.usuarios;

import com.mydomain.Directorio.model.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.security.Credentials;

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

	public List<CuentasUsuario> getCuentasUsuarios() {
		return getInstance() == null ? null : new ArrayList<CuentasUsuario>(
				getInstance().getCuentasUsuarios());
	}
	
	
	public String usuarioPorUsername(){
		Credentials cre= (Credentials) Component.getInstance(Credentials.class);
		Query q = getEntityManager().createQuery(ConsultasJpql.USUARIO_POR_USERNAME);
		q.setParameter("parametro",cre.getUsername());
		Usuario nuevo = (Usuario) q.getSingleResult();
		
		String variable= nuevo.getPrimerNombre()+ " "+ nuevo.getApellidos();
				return  variable;
	}
	

}
