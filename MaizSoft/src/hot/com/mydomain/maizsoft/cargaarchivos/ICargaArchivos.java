/**
 * 
 */
package com.mydomain.maizsoft.cargaarchivos;

import java.io.IOException;

import javax.ejb.Local;

/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 15/07/2012 
 */
@Local
public interface ICargaArchivos {
	
public void handleUpload() throws IOException;
	
	public byte[] getFile();
	
	public void setFile(byte[] file);
	
	public String getNombreArchivo();

	
	public void setNombreArchivo(String nombreArchivo) ;

}
