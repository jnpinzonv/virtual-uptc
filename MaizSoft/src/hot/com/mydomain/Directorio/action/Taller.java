package com.mydomain.Directorio.action;

import java.util.List;

import javax.ejb.Local;

@Local
public interface Taller {

	public Long crearResgistro();
	public void modificarResgistro();
	public void eliminarResgistro();

	public String findResgistroById();

}
