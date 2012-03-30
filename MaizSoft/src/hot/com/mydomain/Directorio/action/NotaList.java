package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("notaList")
public class NotaList extends EntityQuery<Nota> {

	private static final String EJBQL = "select nota from Nota nota";

	private static final String[] RESTRICTIONS = {};

	private Nota nota = new Nota();

	public NotaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Nota getNota() {
		return nota;
	}
}
