package com.mydomain.maizsoft.academia;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("notaActividadList")
public class NotaActividadList extends EntityQuery<NotaActividad> {

	private static final String EJBQL = "select notaActividad from NotaActividad notaActividad";

	private static final String[] RESTRICTIONS = {"lower(notaActividad.justificacion) like lower(concat(#{notaActividadList.notaActividad.justificacion},'%'))",};

	private NotaActividad notaActividad = new NotaActividad();

	public NotaActividadList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public NotaActividad getNotaActividad() {
		return notaActividad;
	}
}
