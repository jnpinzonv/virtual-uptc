package com.mydomain.maizsoft.cargaarchivos;

import java.io.File;
import java.io.IOException;

import javax.ejb.Stateless;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.management.action.UserAction;

import com.mydomain.Directorio.model.Usuario;


@Name("cargaMasivaUsuariosBean")
@Stateless
public class CargaMasivaUsuariosBean implements ICargaMasivaUsuarios {
	@Logger
	private Log log;

	@In
	StatusMessages statusMessages;
	@In(create=true)
	private UserAction userAction;
	@In(create=true)
	private Usuario usuario;
	
	private String rutaCargaUsuarios;

	public void cargaMasivaUsuarios() {
		// implement your business logic here
		log.info("CargaMasivaUsuarios.cargaMasivaUsuarios() action called");
		statusMessages.add("cargaMasivaUsuarios");

		//Ubicaci�n del archivo XLS
		//String archivo = "C:/Users/Nicolas/Desktop/pruebaMasiva.xls";

		//Creamos un Workbook para cargar el XLS en memoria 
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(rutaCargaUsuarios));
			//Elegimos la primera hoja
			Sheet sheet = workbook.getSheet(0);
			//inicializo el objeto que leer� el valor de la celda
			Cell celdaCurso = null;
			//Este String guardar� el valor de la celda
			String valorCeldaCurso = null;

			//Obtengo el n�mero de filas ocupadas en la hoja
			int rows = sheet.getRows();
			System.out.println(rows+"filasssssssssss");
			//Obtengo el n�mero de columnas ocupadas en la hoja
			int cols = sheet.getColumns();
			System.out.println(cols+"colssssssssssssss");

			//Para efectos de ejemplo recorremos las columnas de cada fila
			for (int x = 0; x < rows; x++) {
				for (int y = 0; y < cols; y++) {
					//Obtenemos el valor de la celda de la columna Y y fila X
					celdaCurso = sheet.getCell(y, x);
					//Obtenemos el valor de la celda
					valorCeldaCurso = celdaCurso.getContents();
					//userAction.setPassword()
				}
				

			}

			workbook.close();
		} catch (BiffException e) {
			log.info("errorr1" + e.getMessage() + " " + e.getCause());
			statusMessages.add("cargaMasivaUsuarios1");
		} catch (IOException e) {
			log.info("errorr2");
			statusMessages.add("cargaMasivaUsuarios2");
		}

	}
	
	public void preCargaUsuarios(){
		
	}

	/**
	 * @return the rutaCargaUsuarios
	 */
	public String getRutaCargaUsuarios() {
		return rutaCargaUsuarios;
	}

	/**
	 * @param rutaCargaUsuarios the rutaCargaUsuarios to set
	 */
	public void setRutaCargaUsuarios(String rutaCargaUsuarios) {
		this.rutaCargaUsuarios = rutaCargaUsuarios;
	}
	
	
	

	// add additional action methods

}
