package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gestorAgendaList")
public class GestorAgendaList extends EntityQuery<GestorAgenda> {

	private static final String EJBQL = "select gestorAgenda from GestorAgenda gestorAgenda";

	private static final String[] RESTRICTIONS = {"lower(gestorAgenda.agendaDescripcion) like lower(concat(#{gestorAgendaList.gestorAgenda.agendaDescripcion},'%'))",};

	private GestorAgenda gestorAgenda = new GestorAgenda();

	public GestorAgendaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GestorAgenda getGestorAgenda() {
		return gestorAgenda;
	}
}
