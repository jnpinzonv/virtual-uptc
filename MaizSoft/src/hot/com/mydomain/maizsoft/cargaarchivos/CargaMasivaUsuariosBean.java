package com.mydomain.maizsoft.cargaarchivos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.drools.common.PropagationContextImpl;
import org.drools.spi.PropagationContext;
import org.jboss.seam.Component;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.contexts.Context;
import org.jboss.seam.core.ConversationPropagation;
import org.jboss.seam.core.PropagationType;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.management.IdentityManagementException;
import org.jboss.seam.security.management.action.UserAction;

import com.mydomain.Directorio.model.CuentasUsuario;
import com.mydomain.Directorio.model.EnteUniversitario;
import com.mydomain.Directorio.model.Tipo;
import com.mydomain.Directorio.model.UserAccount;
import com.mydomain.Directorio.model.Usuario;

@Name("cargaMasivaUsuariosBean")
@Stateless
public class CargaMasivaUsuariosBean implements ICargaMasivaUsuarios {
	@Logger
	private Log log;

	@In
	StatusMessages statusMessages;
	@In(create = true)
	private UserAction userAction;

	

	@PersistenceContext
	private EntityManager entityManager;

	@In(create = true)
	private PreCargaUsuarios preCargaUsuarios;

	private String rutaCargaUsuarios;
	
	public void cargaMasivaUsuarios() {
		
		// implement your business logic here
		log.info("CargaMasivaUsuarios.cargaMasivaUsuarios() action called");
		statusMessages.add("cargaMasivaUsuarios");

		// Ubicaci�n del archivo XLS

		// Creamos un Workbook para cargar el XLS en memoria
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(rutaCargaUsuarios));
			// Elegimos la primera hoja
			Sheet sheet = workbook.getSheet(0);

			// Obtengo el n�mero de filas ocupadas en la hoja
			int rows = sheet.getRows();

			// userAction.createUser();

			// Para efectos de ejemplo recorremos las columnas de cada fila
			for (int x = 2; x < rows; x++) {
				// for (int y = 0; y < cols; y++) {
				// Obtenemos el valor de la celda de la columna Y y fila X

				try {
					Usuario nuevo = new Usuario();
					nuevo.setPrimerNombre(sheet.getCell(0, x).getContents());
					nuevo.setSegundoNombre(sheet.getCell(1, x).getContents());
					nuevo.setApellidos(sheet.getCell(2, x).getContents());
					nuevo.setCodigoUsuarios(sheet.getCell(3, x).getContents());
					nuevo.setCorreoElectronico(sheet.getCell(4, x)
							.getContents());
					nuevo.setDocumentoIdentidad(Long.parseLong(sheet.getCell(5,
							x).getContents()));
					Tipo tipo = buscarTipoIdentificacion(sheet.getCell(6, x)
							.getContents());
					nuevo.setTipo(tipo);

					UserAction action = new UserAction();
					action.setUsername(sheet.getCell(7, x).getContents());
					action.setPassword(sheet.getCell(8, x).getContents());

					EnteUniversitario enteUniversitarios = buscarEnteUniversitario(sheet
							.getCell(9, x).getContents());
					nuevo.setEnteUniversitarios(enteUniversitarios);
					ArrayList<String> nuevoR = new ArrayList<String>();
					nuevoR.add(sheet.getCell(10, x).getContents());
					action.setRoles(nuevoR);
					preCargaUsuarios.getUsuarios().add(nuevo);
					preCargaUsuarios.getUserActions().add(action);

				} catch (Exception e) {
					log.info("Error " + e.getMessage() + " "+"linea #"+ x);
					
				}
			}

			workbook.close();
		} catch (BiffException e) {
			log.info("Error " + e.getMessage() + " " + e.getCause());
			statusMessages.add("cargaMasivaUsuarios");
		} catch (IOException e) {
			log.info("Error " + e.getMessage() + " " + e.getCause());
			statusMessages.add("cargaMasivaUsuarios");
		}

		try {
			saveUsuarios();
		} catch (Exception e) {
			
			 log.info("Error " + e.getMessage() + " " + e.getCause()+ " NO ingreso por el Link de Carga");
				statusMessages.add("NO ingreso por el Link de Carga");
		}

	}

	public void saveUsuarios() throws Exception{		
			
		
		for (int i = 0; i < preCargaUsuarios.getUsuarios().size(); i++) {
			try {
			UserAction nuevoU =preCargaUsuarios.getUserActions().get(i);
			userAction.setUsername(nuevoU.getUsername());
			userAction.setPassword(nuevoU.getPassword());
			userAction.setConfirm(nuevoU.getPassword());
			userAction.setEnabled(true);
			userAction.setRoles(nuevoU.getRoles());
			userAction.save();
			Usuario nuevo = preCargaUsuarios.getUsuarios().get(i);			
			entityManager.persist(nuevo);
			CuentasUsuario nuevoCuenta = new CuentasUsuario();
			nuevoCuenta.setUsuarios(nuevo);
		
			
			Query q = entityManager
					.createQuery("select u from UserAccount u where u.username=:parametro");
			q.setParameter("parametro", nuevoU.getUsername());
			nuevoCuenta.setUserAccounts((UserAccount) q.getSingleResult());
			entityManager.persist(nuevoCuenta);
		} catch (IdentityManagementException e) {
			log.info("Error " + e.getMessage() + " " + e.getCause()+ " Duplicado Username");
			statusMessages.add("Duplicado Username");
		}
		}
		
	}
	
	public EnteUniversitario buscarEnteUniversitario(String parametro) {
		Query q = entityManager
				.createQuery("select t from EnteUniversitario t where t.codigoEnteUniversitario=:parametro");
		q.setParameter("parametro", parametro);

		return (EnteUniversitario) q.getSingleResult();
		
	}

	public Tipo buscarTipoIdentificacion(String parametro) {
		Query q = entityManager
				.createQuery("select t from Tipo t where t.nombre=:parametro");
		q.setParameter("parametro", parametro);

		return (Tipo) q.getSingleResult();
	}

	
	public String crearUsuario(){
		
		userAction.createUser();		
		return "/admin/cargaMasivaUsuarios.xhtml";
	}
	/**
	 * @return the rutaCargaUsuarios
	 */
	public String getRutaCargaUsuarios() {
		return rutaCargaUsuarios;
	}

	/**
	 * @param rutaCargaUsuarios
	 *            the rutaCargaUsuarios to set
	 */
	public void setRutaCargaUsuarios(String rutaCargaUsuarios) {
		this.rutaCargaUsuarios = rutaCargaUsuarios;
	}

	// add additional action methods

}
