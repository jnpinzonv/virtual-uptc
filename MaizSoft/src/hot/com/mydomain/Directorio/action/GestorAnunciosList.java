package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gestorAnunciosList")
public class GestorAnunciosList extends EntityQuery<GestorAnuncios> {

	private static final String EJBQL = "select gestorAnuncios from GestorAnuncios gestorAnuncios";

	private static final String[] RESTRICTIONS = {
			"lower(gestorAnuncios.descripcion) like lower(concat(#{gestorAnunciosList.gestorAnuncios.descripcion},'%'))",
			"lower(gestorAnuncios.nombre) like lower(concat(#{gestorAnunciosList.gestorAnuncios.nombre},'%'))",};

	private GestorAnuncios gestorAnuncios = new GestorAnuncios();

	public GestorAnunciosList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GestorAnuncios getGestorAnuncios() {
		return gestorAnuncios;
	}
}
