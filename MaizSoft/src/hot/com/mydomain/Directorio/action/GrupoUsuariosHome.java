package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("grupoUsuariosHome")
public class GrupoUsuariosHome extends EntityHome<GrupoUsuarios> {

	@In(create = true)
	GrupoCursoHome grupoCursoHome;
	@In(create = true)
	UsuarioHome usuarioHome;
	@In(create = true)
	CuentasUsuarioHome cuentasUsuarioHome;

	public void setGrupoUsuariosIdGrupoUsuarios(Long id) {
		setId(id);
	}

	public Long getGrupoUsuariosIdGrupoUsuarios() {
		return (Long) getId();
	}

	@Override
	protected GrupoUsuarios createInstance() {
		GrupoUsuarios grupoUsuarios = new GrupoUsuarios();
		return grupoUsuarios;
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
		Usuario userGrupoCurso = usuarioHome.getDefinedInstance();
		if (userGrupoCurso != null) {
			getInstance().setUserGrupoCurso(userGrupoCurso);
		}
		CuentasUsuario userRole = cuentasUsuarioHome.getDefinedInstance();
		if (userRole != null) {
			getInstance().setUserRole(userRole);
		}
	}

	public boolean isWired() {
		if (getInstance().getGrupoCurso() == null)
			return false;
		return true;
	}

	public GrupoUsuarios getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<NotaActividad> getNotaActividades() {
		return getInstance() == null ? null : new ArrayList<NotaActividad>(
				getInstance().getNotaActividades());
	}

}
