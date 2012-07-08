package com.mydomain.maizsoft.usuarios;

import com.mydomain.Directorio.model.*;
import com.mydomain.maizsoft.curso.GrupoUsuariosHome;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("cuentasUsuarioHome")
public class CuentasUsuarioHome extends EntityHome<CuentasUsuario> {

	@In(create = true)
	GrupoUsuariosHome grupoUsuariosHome;
	@In(create = true)
	UserAccountHome userAccountHome;
	@In(create = true)
	UsuarioHome usuarioHome;

	public void setCuentasUsuarioId(Long id) {
		setId(id);
	}

	public Long getCuentasUsuarioId() {
		return (Long) getId();
	}

	@Override
	protected CuentasUsuario createInstance() {
		CuentasUsuario cuentasUsuario = new CuentasUsuario();
		return cuentasUsuario;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		GrupoUsuarios grupoUsuarios = grupoUsuariosHome.getDefinedInstance();
//		if (grupoUsuarios != null) {
//			getInstance().setGrupoUsuarios(grupoUsuarios);
//		}
		UserAccount userAccounts = userAccountHome.getDefinedInstance();
		if (userAccounts != null) {
			getInstance().setUserAccounts(userAccounts);
		}
		Usuario usuarios = usuarioHome.getDefinedInstance();
		if (usuarios != null) {
			getInstance().setUsuarios(usuarios);
		}
	}

	public boolean isWired() {
		if (getInstance().getUserAccounts() == null)
			return false;
		if (getInstance().getUsuarios() == null)
			return false;
		return true;
	}

	public CuentasUsuario getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
