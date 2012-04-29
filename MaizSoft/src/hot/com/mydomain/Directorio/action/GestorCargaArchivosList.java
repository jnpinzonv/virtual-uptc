package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gestorCargaArchivosList")
public class GestorCargaArchivosList extends EntityQuery<GestorCargaArchivos> {

	private static final String EJBQL = "select gestorCargaArchivos from GestorCargaArchivos gestorCargaArchivos";

	private static final String[] RESTRICTIONS = {
			"lower(gestorCargaArchivos.descripcion) like lower(concat(#{gestorCargaArchivosList.gestorCargaArchivos.descripcion},'%'))",
			"lower(gestorCargaArchivos.nombre) like lower(concat(#{gestorCargaArchivosList.gestorCargaArchivos.nombre},'%'))",
			"lower(gestorCargaArchivos.ruta) like lower(concat(#{gestorCargaArchivosList.gestorCargaArchivos.ruta},'%'))",};

	private GestorCargaArchivos gestorCargaArchivos = new GestorCargaArchivos();

	public GestorCargaArchivosList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GestorCargaArchivos getGestorCargaArchivos() {
		return gestorCargaArchivos;
	}
}
