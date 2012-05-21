package com.mydomain.Directorio.action;

import java.util.List;

import javax.persistence.Query;

import com.mydomain.Directorio.model.*;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorRepositoriosVirtualesHome")
public class GestorRepositoriosVirtualesHome
		extends
			EntityHome<GestorRepositoriosVirtuales> {

	@In(create = true)
	TipoHome tipoHome;

	public void setGestorRepositoriosVirtualesIdRepositorio(Long id) {
		setId(id);
	}

	public Long getGestorRepositoriosVirtualesIdRepositorio() {
		return (Long) getId();
	}

	@Override
	protected GestorRepositoriosVirtuales createInstance() {
		GestorRepositoriosVirtuales gestorRepositoriosVirtuales = new GestorRepositoriosVirtuales();
		return gestorRepositoriosVirtuales;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Tipo tipos = tipoHome.getDefinedInstance();
		if (tipos != null) {
			getInstance().setTipos(tipos);
		}
	}

	public boolean isWired() {
		if (getInstance().getTipos() == null)
			return false;
		return true;
	}

	public GestorRepositoriosVirtuales getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}
	
	@Factory("listaTiposRepositoriosVirtuales")
	public List<Tipo> listaTiposEntesUniversitarios() {

		Query q = getEntityManager()
				.createQuery("select t from Tipo t where t.tipo=21");
		List<Tipo> listaTiposEnteUniversitarios = (List<Tipo>)q.getResultList();
	
		return listaTiposEnteUniversitarios;
	}

}
