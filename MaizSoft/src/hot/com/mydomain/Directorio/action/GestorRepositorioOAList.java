package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gestorRepositorioOAList")
public class GestorRepositorioOAList extends EntityQuery<GestorRepositorioOA> {

	private static final String EJBQL = "select gestorRepositorioOA from GestorRepositorioOA gestorRepositorioOA";

	private static final String[] RESTRICTIONS = {
			"lower(gestorRepositorioOA.descripcionRepositorio) like lower(concat(#{gestorRepositorioOAList.gestorRepositorioOA.descripcionRepositorio},'%'))",
			"lower(gestorRepositorioOA.nombreRepositorio) like lower(concat(#{gestorRepositorioOAList.gestorRepositorioOA.nombreRepositorio},'%'))",
			"lower(gestorRepositorioOA.passwordRepositorio) like lower(concat(#{gestorRepositorioOAList.gestorRepositorioOA.passwordRepositorio},'%'))",
			"lower(gestorRepositorioOA.urlRepositorio) like lower(concat(#{gestorRepositorioOAList.gestorRepositorioOA.urlRepositorio},'%'))",
			"lower(gestorRepositorioOA.usernameRepositorio) like lower(concat(#{gestorRepositorioOAList.gestorRepositorioOA.usernameRepositorio},'%'))",};

	private GestorRepositorioOA gestorRepositorioOA = new GestorRepositorioOA();

	public GestorRepositorioOAList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GestorRepositorioOA getGestorRepositorioOA() {
		return gestorRepositorioOA;
	}
}
