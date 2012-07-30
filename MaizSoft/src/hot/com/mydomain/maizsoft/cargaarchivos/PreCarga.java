/**
 * 
 */
package com.mydomain.maizsoft.cargaarchivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;

import com.mydomain.Directorio.model.ConfiguracionesSistema;
import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.GestorCargaArchivos;
import com.mydomain.Directorio.model.GrupoUsuarios;
import com.mydomain.maizsoft.gestores.GestorCargaArchivosHome;



/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 29/07/2012 
 */
@Name("preCarga")
@Stateless
public class PreCarga implements IPreCarga{

	
	@Logger
	private Log log;

	@PersistenceContext
	private EntityManager entityManager;

	private byte[] file;

	private String nombreArchivo;

	@In(create = true)
	private Credentials credentials;

	@In(create = true)
	GestorCargaArchivos gestorCargaArchivos;


	public List<GrupoUsuarios> listaGrupoUsuarios() {
		Query q = entityManager
				.createQuery(ConsultasJpql.GRUPO_USUARIOS_SELECIONADO);
		return (List<GrupoUsuarios>) q.getResultList();

	}

	public void handleUpload(String pathFinal) throws IOException {

		File directorio = new File(pathFinal);
		if (!directorio.exists()) {
			directorio.mkdirs();
		}

		File f = new File(pathFinal, nombreArchivo);

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
	 * @param nombreArchivo
	 *            the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	

	

	

	/* (non-Javadoc)
	 * @see com.mydomain.maizsoft.cargaarchivos.ICargaArchivos#cargarObjetoAprendizaje()
	 */

	public void cargarObjetoAprendizaje() {
		

			ConfiguracionesSistema path = entityManager.find(
					ConfiguracionesSistema.class, 1l);
			ConfiguracionesSistema pathOA = entityManager.find(
					ConfiguracionesSistema.class, 18l);
			ConfiguracionesSistema rutaSer = entityManager.find(
					ConfiguracionesSistema.class, 19l);
			String pathFinal = path.getDetallesPropiedad() + "//"
					+ pathOA.getDetallesPropiedad() + "//"
					+ credentials.getUsername();
		
			
			String rutaRelativa =  pathOA.getDetallesPropiedad() + "//"
					+ credentials.getUsername();
		gestorCargaArchivos.setNombre(nombreArchivo);
		gestorCargaArchivos.setRuta(rutaSer.getDetallesPropiedad()+rutaRelativa + "//"+nombreArchivo);
			
			try {
				handleUpload(pathFinal);
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		
	}
}
