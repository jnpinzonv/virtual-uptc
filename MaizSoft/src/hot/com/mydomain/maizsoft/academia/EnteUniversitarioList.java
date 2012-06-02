package com.mydomain.maizsoft.academia;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("enteUniversitarioList")
public class EnteUniversitarioList extends EntityQuery<EnteUniversitario> {

	private static final String EJBQL = "select enteUniversitario from EnteUniversitario enteUniversitario";

	private static final String[] RESTRICTIONS = {
			"lower(enteUniversitario.descripcionEnteUniversitario) like lower(concat(#{enteUniversitarioList.enteUniversitario.descripcionEnteUniversitario},'%'))",
			"lower(enteUniversitario.nombreEnteUniversitario) like lower(concat(#{enteUniversitarioList.enteUniversitario.nombreEnteUniversitario},'%'))",};

	private EnteUniversitario enteUniversitario = new EnteUniversitario();

	public EnteUniversitarioList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public EnteUniversitario getEnteUniversitario() {
		return enteUniversitario;
	}
}
