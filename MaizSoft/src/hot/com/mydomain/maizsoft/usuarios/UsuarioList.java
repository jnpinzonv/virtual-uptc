package com.mydomain.maizsoft.usuarios;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("usuarioList")
public class UsuarioList extends EntityQuery<Usuario> {

	private static final String EJBQL = "select usuario from Usuario usuario";

	private static final String[] RESTRICTIONS = {
			"lower(usuario.apellidos) like lower(concat(#{usuarioList.usuario.apellidos},'%'))",
			"lower(usuario.correoElectronico) like lower(concat(#{usuarioList.usuario.correoElectronico},'%'))",
			"lower(usuario.primerNombre) like lower(concat(#{usuarioList.usuario.primerNombre},'%'))",
			"lower(usuario.segundoNombre) like lower(concat(#{usuarioList.usuario.segundoNombre},'%'))",};

	private Usuario usuario = new Usuario();

	public UsuarioList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
