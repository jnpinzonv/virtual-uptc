package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("semestreList")
public class SemestreList extends EntityQuery<Semestre> {

	private static final String EJBQL = "select semestre from Semestre semestre";

	private static final String[] RESTRICTIONS = {};

	private Semestre semestre = new Semestre();

	public SemestreList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Semestre getSemestre() {
		return semestre;
	}
}
