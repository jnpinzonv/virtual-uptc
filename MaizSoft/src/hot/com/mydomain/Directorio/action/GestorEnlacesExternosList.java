package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gestorEnlacesExternosList")
public class GestorEnlacesExternosList
		extends
			EntityQuery<GestorEnlacesExternos> {

	private static final String EJBQL = "select gestorEnlacesExternos from GestorEnlacesExternos gestorEnlacesExternos";

	private static final String[] RESTRICTIONS = {
			"lower(gestorEnlacesExternos.descripcionEnlace) like lower(concat(#{gestorEnlacesExternosList.gestorEnlacesExternos.descripcionEnlace},'%'))",
			"lower(gestorEnlacesExternos.nombreEnlace) like lower(concat(#{gestorEnlacesExternosList.gestorEnlacesExternos.nombreEnlace},'%'))",
			"lower(gestorEnlacesExternos.urlEnlace) like lower(concat(#{gestorEnlacesExternosList.gestorEnlacesExternos.urlEnlace},'%'))",};

	private GestorEnlacesExternos gestorEnlacesExternos = new GestorEnlacesExternos();

	public GestorEnlacesExternosList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GestorEnlacesExternos getGestorEnlacesExternos() {
		return gestorEnlacesExternos;
	}
}
