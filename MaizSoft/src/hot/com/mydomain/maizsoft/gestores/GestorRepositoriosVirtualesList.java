package com.mydomain.maizsoft.gestores;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gestorRepositoriosVirtualesList")
public class GestorRepositoriosVirtualesList
		extends
			EntityQuery<GestorRepositoriosVirtuales> {

	private static final String EJBQL = "select gestorRepositoriosVirtuales from GestorRepositoriosVirtuales gestorRepositoriosVirtuales";

	private static final String[] RESTRICTIONS = {
			"lower(gestorRepositoriosVirtuales.descripcionRepositorio) like lower(concat(#{gestorRepositoriosVirtualesList.gestorRepositoriosVirtuales.descripcionRepositorio},'%'))",
			"lower(gestorRepositoriosVirtuales.nombreRepositorio) like lower(concat(#{gestorRepositoriosVirtualesList.gestorRepositoriosVirtuales.nombreRepositorio},'%'))",
			"lower(gestorRepositoriosVirtuales.passwordRepositorio) like lower(concat(#{gestorRepositoriosVirtualesList.gestorRepositoriosVirtuales.passwordRepositorio},'%'))",
			"lower(gestorRepositoriosVirtuales.urlRepositorio) like lower(concat(#{gestorRepositoriosVirtualesList.gestorRepositoriosVirtuales.urlRepositorio},'%'))",
			"lower(gestorRepositoriosVirtuales.usernameRepositorio) like lower(concat(#{gestorRepositoriosVirtualesList.gestorRepositoriosVirtuales.usernameRepositorio},'%'))",};

	private GestorRepositoriosVirtuales gestorRepositoriosVirtuales = new GestorRepositoriosVirtuales();

	public GestorRepositoriosVirtualesList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
	}

	public GestorRepositoriosVirtuales getGestorRepositoriosVirtuales() {
		return gestorRepositoriosVirtuales;
	}
}
