package com.mydomain.maizsoft.comunicaciones;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.security.Credentials;

import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.GestorMensajeria;
import com.mydomain.Directorio.model.ReceptorMensajes;
import com.mydomain.Directorio.model.Usuario;
import com.mydomain.maizsoft.usuarios.UsuarioHome;

@Name("receptorMensajesHome")
public class ReceptorMensajesHome extends EntityHome<ReceptorMensajes> {

	@In(create = true)
	GestorMensajeriaHome gestorMensajeriaHome;
	@In(create = true)
	UsuarioHome usuarioHome;

	public void setReceptorMensajesIdReceptormenajes(Long id) {
		setId(id);
	}

	public Long getReceptorMensajesIdReceptormenajes() {
		return (Long) getId();
	}

	@Override
	protected ReceptorMensajes createInstance() {
		ReceptorMensajes receptorMensajes = new ReceptorMensajes();
		return receptorMensajes;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		GestorMensajeria gestorMensajeria = gestorMensajeriaHome
				.getDefinedInstance();
		if (gestorMensajeria != null) {
			getInstance().setGestorMensajeria(gestorMensajeria);
		}
		Usuario userAccount = usuarioHome.getDefinedInstance();
		if (userAccount != null) {
			getInstance().setUserAccount(userAccount);
		}
	}

	public boolean isWired() {
		if (getInstance().getGestorMensajeria() == null)
			return false;
		if (getInstance().getUserAccount() == null)
			return false;
		return true;
	}

	public ReceptorMensajes getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}
	
	@Factory("listaMensajesNoLeidos")
	public List<GestorMensajeria> listaMensajesNoLeidos(){
		
		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);
		
		Query q = getEntityManager().createQuery(
				ConsultasJpql.MENSAJES_NO_LEIDOS);
		q.setParameter("parametro", cre.getUsername());
//		List<GestorMensajeria> lista = (List<GestorMensajeria>) q
//				.getResultList();
//	
		
		return q.getResultList();
	}

}
