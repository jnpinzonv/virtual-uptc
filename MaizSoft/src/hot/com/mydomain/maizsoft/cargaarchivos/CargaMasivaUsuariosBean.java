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

@Stateless
@Name("CargaMasivaUsuarios")
public class CargaMasivaUsuariosBean implements ICargaMasivaUsuarios {
	@Logger
	private Log log;

	@In
	StatusMessages statusMessages;

	public void cargaMasivaUsuarios() {
		// implement your business logic here
		log.info("CargaMasivaUsuarios.cargaMasivaUsuarios() action called");
		statusMessages.add("cargaMasivaUsuarios");

		//Ubicaci�n del archivo XLS
		String archivo = "C:/Users/Nicolas/Desktop/pruebaMasiva.xls";

		//Creamos un Workbook para cargar el XLS en memoria 
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(new File(archivo));
			//Elegimos la primera hoja
			Sheet sheet = workbook.getSheet(0);
			//inicializo el objeto que leer� el valor de la celda
			Cell celdaCurso = null;
			//Este String guardar� el valor de la celda
			String valorCeldaCurso = null;

			//Obtengo el n�mero de filas ocupadas en la hoja
			int rows = sheet.getRows();
			//Obtengo el n�mero de columnas ocupadas en la hoja
			int cols = sheet.getColumns();

			//Para efectos de ejemplo recorremos las columnas de cada fila
			for (int x = 0; x < rows; x++) {
				for (int y = 0; y < cols; y++) {
					//Obtenemos el valor de la celda de la columna Y y fila X
					celdaCurso = sheet.getCell(y, x);
					//Obtenemos el valor de la celda
					valorCeldaCurso = celdaCurso.getContents();
					System.out.print(valorCeldaCurso + "|");
				}
				System.out.println("");

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

	// add additional action methods

}
