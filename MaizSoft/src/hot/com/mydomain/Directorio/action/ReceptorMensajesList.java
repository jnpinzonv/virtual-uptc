package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("receptorMensajesList")
public class ReceptorMensajesList extends EntityQuery<ReceptorMensajes> {

	private static final String EJBQL = "select receptorMensajes from ReceptorMensajes receptorMensajes";

	private static final String[] RESTRICTIONS = {};

	private ReceptorMensajes receptorMensajes = new ReceptorMensajes();

	public ReceptorMensajesList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ReceptorMensajes getReceptorMensajes() {
		return receptorMensajes;
	}
}
