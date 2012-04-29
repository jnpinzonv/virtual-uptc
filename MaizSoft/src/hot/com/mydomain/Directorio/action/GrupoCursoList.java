package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("grupoCursoList")
public class GrupoCursoList extends EntityQuery<GrupoCurso> {

	private static final String EJBQL = "select grupoCurso from GrupoCurso grupoCurso";

	private static final String[] RESTRICTIONS = {"lower(grupoCurso.semestre) like lower(concat(#{grupoCursoList.grupoCurso.semestre},'%'))",};

	private GrupoCurso grupoCurso = new GrupoCurso();

	public GrupoCursoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GrupoCurso getGrupoCurso() {
		return grupoCurso;
	}
}
