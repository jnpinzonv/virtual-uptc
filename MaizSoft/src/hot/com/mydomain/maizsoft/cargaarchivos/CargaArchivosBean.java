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
import com.mydomain.Directorio.model.GrupoUsuarios;
import com.mydomain.maizsoft.academia.ActividadHome;
import com.mydomain.maizsoft.gestores.GestorCargaArchivosHome;
import com.mydomain.maizsoft.usuarios.UsuarioHome;

/**
 * Descripcion: Esta Clase se encarga de ... Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 15/07/2012
 */
@Name("cargaArchivosBean")
@Stateless
public class CargaArchivosBean implements ICargaArchivos {

	@Logger
	private Log log;

	@PersistenceContext
	private EntityManager entityManager;

	private byte[] file;

	private String nombreArchivo;

	@In(create = true)
	private Credentials credentials;

	@In(create = true)
	ActividadHome actividadHome;

	@In(create = true)
	private ICargaMasivaUsuarios cargaMasivaUsuariosBean;
	
	@In(create = true)
	private UsuarioHome usuarioHome;
	
	@In(create = true)
	private GestorCargaArchivosHome gestorCargaArchivosHome;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mydomain.maizsoft.cargaarchivos.ICargaArchivos#cargarExcel()
	 */

	public void cargarExcelArchivo() {

		try {
			ConfiguracionesSistema path = entityManager.find(
					ConfiguracionesSistema.class, 1l);
			ConfiguracionesSistema pathExcel = entityManager.find(
					ConfiguracionesSistema.class, 2l);
			String pathFinal = path.getDetallesPropiedad() + "//"
					+ pathExcel.getDetallesPropiedad();

			handleUpload(pathFinal);

			cargaMasivaUsuariosBean.setRutaCargaUsuarios(pathFinal + "//"
					+ nombreArchivo);

			cargaMasivaUsuariosBean.cargaMasivaUsuarios();
		} catch (IOException e) {

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mydomain.maizsoft.cargaarchivos.ICargaArchivos#
	 * cargarArchivoAdjuntoActividad()
	 */

	public void cargarArchivoAdjuntoActividad() {

		try {
			ConfiguracionesSistema path = entityManager.find(
					ConfiguracionesSistema.class, 1l);
			ConfiguracionesSistema pathArchivos = entityManager.find(
					ConfiguracionesSistema.class, 8l);
			String pathFinal = path.getDetallesPropiedad()
					+ "//"
					+ pathArchivos.getDetallesPropiedad()
					+ "//"
					+ listaGrupoUsuarios().get(0).getGrupoCurso()
							.getCodigoGrupo() + "//"
					+ credentials.getUsername();
			
			handleUpload(pathFinal);

			actividadHome.getInstance().setRutaArchivo(pathFinal);
			actividadHome.getInstance().setNombreArchivo(nombreArchivo);
			actividadHome.getInstance().setAdjuntarArchivo(true);
		} catch (IOException e) {

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mydomain.maizsoft.cargaarchivos.ICargaArchivos#cargarFotoUsuario()
	 */
	public void cargarFotoUsuario() {

		try {
			ConfiguracionesSistema path = entityManager.find(
					ConfiguracionesSistema.class, 1l);
			ConfiguracionesSistema pathImagenes = entityManager.find(
					ConfiguracionesSistema.class, 17l);
			String pathFinal = path.getDetallesPropiedad() + "//"
					+ pathImagenes.getDetallesPropiedad() + "//"
					+ credentials.getUsername();
			handleUpload(pathFinal);
			usuarioHome.getInstance().setFotoUser(pathFinal+ "//"+nombreArchivo);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see com.mydomain.maizsoft.cargaarchivos.ICargaArchivos#cargarObjetoAprendizaje()
	 */

	public void cargarObjetoAprendizaje() {
		

			ConfiguracionesSistema path = entityManager.find(
					ConfiguracionesSistema.class, 1l);
			ConfiguracionesSistema pathOA = entityManager.find(
					ConfiguracionesSistema.class, 18l);
			String pathFinal = path.getDetallesPropiedad() + "//"
					+ pathOA.getDetallesPropiedad() + "//"
					+ credentials.getUsername();
		
			
			String rutaRelativa =  pathOA.getDetallesPropiedad() + "//"
					+ credentials.getUsername();
			//gestorCargaArchivosHome.getInstance().setNombre(nombreArchivo);
			//gestorCargaArchivosHome.getInstance().setRuta("http://localhost/"+rutaRelativa);
			
			try {
				handleUpload(pathFinal);
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		
	}
}
