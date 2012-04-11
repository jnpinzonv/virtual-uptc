package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gestorAudioConferenciaList")
public class GestorAudioConferenciaList
		extends
			EntityQuery<GestorAudioConferencia> {

	private static final String EJBQL = "select gestorAudioConferencia from GestorAudioConferencia gestorAudioConferencia";

	private static final String[] RESTRICTIONS = {
			"lower(gestorAudioConferencia.descripcionAudioConferencia) like lower(concat(#{gestorAudioConferenciaList.gestorAudioConferencia.descripcionAudioConferencia},'%'))",
			"lower(gestorAudioConferencia.horaAudioConferencia) like lower(concat(#{gestorAudioConferenciaList.gestorAudioConferencia.horaAudioConferencia},'%'))",
			"lower(gestorAudioConferencia.tituloAudioConferencia) like lower(concat(#{gestorAudioConferenciaList.gestorAudioConferencia.tituloAudioConferencia},'%'))",};

	private GestorAudioConferencia gestorAudioConferencia = new GestorAudioConferencia();

	public GestorAudioConferenciaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GestorAudioConferencia getGestorAudioConferencia() {
		return gestorAudioConferencia;
	}
}
