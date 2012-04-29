package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("historialNotasList")
public class HistorialNotasList extends EntityQuery<HistorialNotas> {

	private static final String EJBQL = "select historialNotas from HistorialNotas historialNotas";

	private static final String[] RESTRICTIONS = {};

	private HistorialNotas historialNotas = new HistorialNotas();

	public HistorialNotasList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public HistorialNotas getHistorialNotas() {
		return historialNotas;
	}
}
