package com.mydomain.maizsoft.tipos;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tipoList")
public class TipoList extends EntityQuery<Tipo> {

	private static final String EJBQL = "select tipo from Tipo tipo";

	private static final String[] RESTRICTIONS = {
			"lower(tipo.descripcion) like lower(concat(#{tipoList.tipo.descripcion},'%'))",
			"lower(tipo.nombre) like lower(concat(#{tipoList.tipo.nombre},'%'))",};

	private Tipo tipo = new Tipo();

	public TipoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tipo getTipo() {
		return tipo;
	}
}
