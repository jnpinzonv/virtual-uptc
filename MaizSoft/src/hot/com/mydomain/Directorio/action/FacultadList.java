package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("facultadList")
public class FacultadList extends EntityQuery<Facultad> {

	private static final String EJBQL = "select facultad from Facultad facultad";

	private static final String[] RESTRICTIONS = {
			"lower(facultad.descripcionFacultad) like lower(concat(#{facultadList.facultad.descripcionFacultad},'%'))",
			"lower(facultad.nombreFacultad) like lower(concat(#{facultadList.facultad.nombreFacultad},'%'))",};

	private Facultad facultad = new Facultad();

	public FacultadList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Facultad getFacultad() {
		return facultad;
	}
}
