package com.mydomain.maizsoft.academia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import com.mydomain.Directorio.model.*;
import com.mydomain.maizsoft.curso.GrupoCursoHome;
import com.mydomain.maizsoft.usuarios.UsuarioHome;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.security.Credentials;

@Name("historialNotasHome")
public class HistorialNotasHome extends EntityHome<HistorialNotas> {

	@In(create = true)
	GrupoCursoHome grupoCursoHome;
	@In(create = true)
	UsuarioHome usuarioHome;

	public void setHistorialNotasIdHistorialNotas(Long id) {
		setId(id);
	}

	public Long getHistorialNotasIdHistorialNotas() {
		return (Long) getId();
	}

	@Override
	protected HistorialNotas createInstance() {
		HistorialNotas historialNotas = new HistorialNotas();
		return historialNotas;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		GrupoCurso grupoCurso = grupoCursoHome.getDefinedInstance();
		if (grupoCurso != null) {
			getInstance().setGrupoCurso(grupoCurso);
		}
		Usuario userAccount = usuarioHome.getDefinedInstance();
		if (userAccount != null) {
			getInstance().setUserAccount(userAccount);
		}
	}

	public boolean isWired() {
		if (getInstance().getGrupoCurso() == null)
			return false;
		if (getInstance().getUserAccount() == null)
			return false;
		return true;
	}

	public HistorialNotas getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public String cierreSemestre() {
		Query q = null;
		List<NotasUsuario> nueva = new ArrayList<NotasUsuario>();
		Credentials crede = (Credentials) Component
				.getInstance(Credentials.class);
		Query q1 = getEntityManager().createQuery(
				ConsultasJpql.LISTA_USUARIOS_ESTUDIANTES);

		List<Usuario> usu = (List<Usuario>) q1.getResultList();
		for (Usuario usuario : usu) {

			q = getEntityManager().createNativeQuery(
					ConsultasJpql.NOTAS_ESTUDIANTE_HISTORIAL);
			q.setParameter("parametro", usuario.getId());

			Iterator results = q.getResultList().iterator();

			while (results.hasNext()) {
				Object[] row = (Object[]) results.next();
				HistorialNotas nuevoA = new HistorialNotas();
				long idGrupo=Long.parseLong(row[0].toString());
				GrupoCurso grupoCurso = getEntityManager().find(
						GrupoCurso.class,idGrupo );
				nuevoA.setGrupoCurso(grupoCurso);
				nuevoA.setNota((Double) row[1]);
				nuevoA.setSemestre((String) row[2]);
				nuevoA.setUserAccount(usuario);
				getEntityManager().persist(nuevoA);
			}

		}
		return "";
	}
}
