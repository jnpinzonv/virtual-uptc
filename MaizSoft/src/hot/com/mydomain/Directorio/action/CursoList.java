package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("cursoList")
public class CursoList extends EntityQuery<Curso> {

	private static final String EJBQL = "select curso from Curso curso";

	private static final String[] RESTRICTIONS = {"lower(curso.nombreAsignatura) like lower(concat(#{cursoList.curso.nombreAsignatura},'%'))",};

	private Curso curso = new Curso();

	public CursoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Curso getCurso() {
		return curso;
	}
}
