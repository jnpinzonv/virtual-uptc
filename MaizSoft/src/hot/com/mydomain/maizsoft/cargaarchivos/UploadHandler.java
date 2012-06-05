/**
 * 
 */
package com.mydomain.maizsoft.cargaarchivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import com.mydomain.Directorio.model.ConfiguracionesSistema;

/**
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 * @Version${date
 */
@Name("uploadHandler")
@Stateless
@Scope(ScopeType.EVENT)
public class UploadHandler implements IUploadHandler {

	@Logger
	private Log log;

	@PersistenceContext
	private EntityManager entityManager;

	private byte[] file;

	private String nombreArchivo;
	
	@In(create=true)
	private ICargaMasivaUsuarios cargaMasivaUsuariosBean;
	
	@In
	Identity identity;

	public void handleUpload() throws IOException {

		//	System.out.println(identity.);
		ConfiguracionesSistema path = entityManager.find(
				ConfiguracionesSistema.class, 1l);
		ConfiguracionesSistema pathExcel = entityManager.find(
				ConfiguracionesSistema.class, 2l);
		
		File f = new File(path.getDetallesPropiedad()+"\\"+ pathExcel.getDetallesPropiedad(), nombreArchivo);
		log.info(f);
		FileOutputStream fo = new FileOutputStream(f);
		fo.write(file);
		fo.flush();
		fo.close();
		cargarExcel();
	}

	/**
	 * Realiza la carga usuarios de un archivo tipo excel 
	 */
	public void cargarExcel() {
		
		ConfiguracionesSistema path = entityManager.find(
				ConfiguracionesSistema.class, 1l);
		ConfiguracionesSistema pathExcel = entityManager.find(
				ConfiguracionesSistema.class, 2l);
		//cargaMasivaUsuariosBean=(ICargaMasivaUsuarios) Component.getInstance(CargaMasivaUsuariosBean.class);
		cargaMasivaUsuariosBean.setRutaCargaUsuarios(path
				.getDetallesPropiedad()+"//"+
				 pathExcel.getDetallesPropiedad()+"//"+
				 nombreArchivo);
		
		cargaMasivaUsuariosBean.cargaMasivaUsuarios();
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
	 * @param nombreArchivo
	 *            the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

}
