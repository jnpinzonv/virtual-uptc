/**
 * 
 */
package com.mydomain.maizsoft.cargaarchivos;

import java.io.IOException;

import javax.ejb.Local;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Local
public interface IUploadHandler {
	public void handleUpload() throws IOException;
	
	public byte[] getFile();
	
	public void setFile(byte[] file);
	
	public String getNombreArchivo();

	
	public void setNombreArchivo(String nombreArchivo) ;
}
