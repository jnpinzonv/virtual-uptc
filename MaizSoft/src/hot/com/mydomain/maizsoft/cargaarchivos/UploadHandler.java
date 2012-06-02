/**
 * 
 */
package com.mydomain.maizsoft.cargaarchivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import com.mydomain.Directorio.model.ConfiguracionesSistema;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Name("uploadHandler")
@Stateless
@Scope(ScopeType.EVENT)
public class UploadHandler implements IUploadHandler{
	
	
	
	@Logger private Log log;
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private byte[] file;	
	
	private String nombreArchivo;
	
	
	public void handleUpload() throws IOException{
	
		ConfiguracionesSistema path=entityManager.find(ConfiguracionesSistema.class,1l);
		path.getDetallesPropiedad();
		File f = new File(path.getDetallesPropiedad(),nombreArchivo);
		log.info(f);
		FileOutputStream fo = new FileOutputStream(f);
		fo.write(file);
		fo.flush();
		fo.close();
	
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	

}
