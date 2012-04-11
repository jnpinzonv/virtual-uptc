package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("gestorBibliotecasList")
public class GestorBibliotecasList extends EntityQuery<GestorBibliotecas> {

	private static final String EJBQL = "select gestorBibliotecas from GestorBibliotecas gestorBibliotecas";

	private static final String[] RESTRICTIONS = {
			"lower(gestorBibliotecas.descripcionBiblioteca) like lower(concat(#{gestorBibliotecasList.gestorBibliotecas.descripcionBiblioteca},'%'))",
			"lower(gestorBibliotecas.nombreBiblioteca) like lower(concat(#{gestorBibliotecasList.gestorBibliotecas.nombreBiblioteca},'%'))",
			"lower(gestorBibliotecas.passwordBiblioteca) like lower(concat(#{gestorBibliotecasList.gestorBibliotecas.passwordBiblioteca},'%'))",
			"lower(gestorBibliotecas.urlBiblioteca) like lower(concat(#{gestorBibliotecasList.gestorBibliotecas.urlBiblioteca},'%'))",
			"lower(gestorBibliotecas.usernameBiblioteca) like lower(concat(#{gestorBibliotecasList.gestorBibliotecas.usernameBiblioteca},'%'))",};

	private GestorBibliotecas gestorBibliotecas = new GestorBibliotecas();

	public GestorBibliotecasList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public GestorBibliotecas getGestorBibliotecas() {
		return gestorBibliotecas;
	}
}
