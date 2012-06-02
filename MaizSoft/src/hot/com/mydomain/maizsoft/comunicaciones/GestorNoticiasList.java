package com.mydomain.maizsoft.comunicaciones;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gestorNoticiasList")
public class GestorNoticiasList extends EntityQuery<GestorNoticias> {

	private static final String EJBQL = "select gestorNoticias from GestorNoticias gestorNoticias";

	private static final String[] RESTRICTIONS = {"lower(gestorNoticias.nombreNoticia) like lower(concat(#{gestorNoticiasList.gestorNoticias.nombreNoticia},'%'))",};

	private GestorNoticias gestorNoticias = new GestorNoticias();

	public GestorNoticiasList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GestorNoticias getGestorNoticias() {
		return gestorNoticias;
	}
}
