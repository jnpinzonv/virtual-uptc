package com.mydomain.maizsoft.cargaarchivos;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
public interface ICargaMasivaUsuarios {
	// seam-gen method
	public void cargaMasivaUsuarios();

	/**
	 * @return the rutaCargaUsuarios
	 */
	public String getRutaCargaUsuarios();
	
	public void setRutaCargaUsuarios(String rutaCargaUsuarios);
	
	public void saveUsuarios() throws Exception;
	
	public String crearUsuario();
	

}
