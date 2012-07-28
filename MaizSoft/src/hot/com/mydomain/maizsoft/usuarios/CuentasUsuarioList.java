package com.mydomain.maizsoft.usuarios;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("cuentasUsuarioList")
public class CuentasUsuarioList extends EntityQuery<CuentasUsuario> {

	private static final String EJBQL = "select cuentasUsuario from CuentasUsuario cuentasUsuario";

	private CuentasUsuario cuentasUsuario = new CuentasUsuario();

	public CuentasUsuarioList() {
		setEjbql(EJBQL);
	}

	public CuentasUsuario getCuentasUsuario() {
		return cuentasUsuario;
	}
}
