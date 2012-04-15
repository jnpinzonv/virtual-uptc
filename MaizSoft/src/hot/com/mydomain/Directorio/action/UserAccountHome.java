package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("userAccountHome")
public class UserAccountHome extends EntityHome<UserAccount> {

	@In(create = true)
	GrupoCursoHome grupoCursoHome;
	@In(create = true)
	GestorAnunciosHome gestorAnunciosHome;

	public void setUserAccountId(Long id) {
		setId(id);
	}

	public Long getUserAccountId() {
		return (Long) getId();
	}

	@Override
	protected UserAccount createInstance() {
		UserAccount userAccount = new UserAccount();
		return userAccount;
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
		GestorAnuncios gestorAnuncios = gestorAnunciosHome.getDefinedInstance();
		if (gestorAnuncios != null) {
			getInstance().setGestorAnuncios(gestorAnuncios);
		}
	}

	public boolean isWired() {
		return true;
	}

	public UserAccount getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GestorAudioConferencia> getAudioConferencias() {
		return getInstance() == null
				? null
				: new ArrayList<GestorAudioConferencia>(getInstance()
						.getAudioConferencias());
	}
	public List<GestorAgenda> getEventosAgenda() {
		return getInstance() == null ? null : new ArrayList<GestorAgenda>(
				getInstance().getEventosAgenda());
	}
	public List<GestorMensajeria> getUsuarioEmisor() {
		return getInstance() == null ? null : new ArrayList<GestorMensajeria>(
				getInstance().getUsuarioEmisor());
	}
	public List<GestorVideoConferencia> getVideoConferencias() {
		return getInstance() == null
				? null
				: new ArrayList<GestorVideoConferencia>(getInstance()
						.getVideoConferencias());
	}
	
	@org.jboss.seam.annotations.Factory ("listaTipoDocumento")	
	public TipoDocumento[] getListaTipoDocumento(){		
			return TipoDocumento.values();
	}

}
