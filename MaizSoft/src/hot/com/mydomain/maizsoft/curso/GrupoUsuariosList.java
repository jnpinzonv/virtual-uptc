package com.mydomain.maizsoft.curso;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("grupoUsuariosList")
public class GrupoUsuariosList extends EntityQuery<GrupoUsuarios> {

	private static final String EJBQL = "select grupoUsuarios from GrupoUsuarios grupoUsuarios";

	private static final String[] RESTRICTIONS = {};

	private GrupoUsuarios grupoUsuarios = new GrupoUsuarios();

	public GrupoUsuariosList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GrupoUsuarios getGrupoUsuarios() {
		return grupoUsuarios;
	}
}
