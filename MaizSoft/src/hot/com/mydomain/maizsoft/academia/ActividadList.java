package com.mydomain.maizsoft.academia;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

@Name("actividadList")
public class ActividadList extends EntityQuery<Actividad> {

	private static final String EJBQL = "select actividad from Actividad actividad";

	private static final String[] RESTRICTIONS = {"lower(actividad.descripcionActividad) like lower(concat(#{actividadList.actividad.descripcionActividad},'%'))",};

	private Actividad actividad = new Actividad();

	public ActividadList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		
	}

	public Actividad getActividad() {
		return actividad;
	}
	
	
}
