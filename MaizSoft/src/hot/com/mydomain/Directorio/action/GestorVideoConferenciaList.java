package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gestorVideoConferenciaList")
public class GestorVideoConferenciaList
		extends
			EntityQuery<GestorVideoConferencia> {

	private static final String EJBQL = "select gestorVideoConferencia from GestorVideoConferencia gestorVideoConferencia";

	private static final String[] RESTRICTIONS = {
			"lower(gestorVideoConferencia.descripcionVideoConferencia) like lower(concat(#{gestorVideoConferenciaList.gestorVideoConferencia.descripcionVideoConferencia},'%'))",
			"lower(gestorVideoConferencia.horaVideoConferencia) like lower(concat(#{gestorVideoConferenciaList.gestorVideoConferencia.horaVideoConferencia},'%'))",
			"lower(gestorVideoConferencia.tituloVideoConferencia) like lower(concat(#{gestorVideoConferenciaList.gestorVideoConferencia.tituloVideoConferencia},'%'))",};

	private GestorVideoConferencia gestorVideoConferencia = new GestorVideoConferencia();

	public GestorVideoConferenciaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GestorVideoConferencia getGestorVideoConferencia() {
		return gestorVideoConferencia;
	}
}
