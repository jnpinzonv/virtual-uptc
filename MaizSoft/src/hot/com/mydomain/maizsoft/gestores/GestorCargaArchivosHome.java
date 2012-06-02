package com.mydomain.maizsoft.gestores;

import com.mydomain.Directorio.model.*;
import com.mydomain.maizsoft.tipos.TipoHome;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("gestorCargaArchivosHome")
public class GestorCargaArchivosHome extends EntityHome<GestorCargaArchivos> {

	@In(create = true)
	TipoHome tipoHome;

	public void setGestorCargaArchivosIdGestorCargaArchivos(Long id) {
		setId(id);
	}

	public Long getGestorCargaArchivosIdGestorCargaArchivos() {
		return (Long) getId();
	}

	@Override
	protected GestorCargaArchivos createInstance() {
		GestorCargaArchivos gestorCargaArchivos = new GestorCargaArchivos();
		return gestorCargaArchivos;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Tipo tipo = tipoHome.getDefinedInstance();
		if (tipo != null) {
			getInstance().setTipo(tipo);
		}
	}

	public boolean isWired() {
		if (getInstance().getTipo() == null)
			return false;
		return true;
	}

	public GestorCargaArchivos getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<NotaActividad> getNotaActividad() {
		return getInstance() == null ? null : new ArrayList<NotaActividad>(
				getInstance().getNotaActividad());
	}

}
