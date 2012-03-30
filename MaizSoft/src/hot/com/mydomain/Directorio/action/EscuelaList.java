package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("escuelaList")
public class EscuelaList extends EntityQuery<Escuela> {

	private static final String EJBQL = "select escuela from Escuela escuela";

	private static final String[] RESTRICTIONS = {
			"lower(escuela.descripcionEscuela) like lower(concat(#{escuelaList.escuela.descripcionEscuela},'%'))",
			"lower(escuela.nombreEscuela) like lower(concat(#{escuelaList.escuela.nombreEscuela},'%'))",};

	private Escuela escuela = new Escuela();

	public EscuelaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Escuela getEscuela() {
		return escuela;
	}
}
