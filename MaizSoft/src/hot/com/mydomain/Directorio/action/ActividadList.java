package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("actividadList")
public class ActividadList extends EntityQuery<Actividad> {

	private static final String EJBQL = "select actividad from Actividad actividad";

	private static final String[] RESTRICTIONS = {"lower(actividad.descripcionActividad) like lower(concat(#{actividadList.actividad.descripcionActividad},'%'))",};

	private Actividad actividad = new Actividad();

	public ActividadList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Actividad getActividad() {
		return actividad;
	}
}
