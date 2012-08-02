/**
 * 
 */
package com.mydomain.maizsoft.cargaarchivos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 02/08/2012 
 */
public class EstractorArchivos {
	
	
	private final static int BUFFER = 2048;
	
	
	public void descomprimirArchivoZip(String rutaDestino, String archivo){
		
		try {
			File dirDestino = new File(rutaDestino);
			BufferedOutputStream dest = null;
			FileInputStream fis = new FileInputStream(archivo);
			ZipInputStream zis = new ZipInputStream(
					new BufferedInputStream(fis));
			FileOutputStream fos = null;
			ZipEntry entry;
			int count;
			int index = 0;
			byte data[] = new byte[BUFFER];
			String rutaarchivo = null;
			while ((entry = zis.getNextEntry()) != null) {
				System.out.println("Extracting: " + entry);
				rutaarchivo = entry.getName();
				// tenemos que quitar el primer directorio
				index = rutaarchivo.indexOf("/");
				rutaarchivo = rutaarchivo.substring(index + 1);
				if (rutaarchivo.trim().length() > 0) {
					// write the files to the disk
					try {
						dest = null;
						File fileDest = new File(dirDestino.getAbsolutePath()
								+ "/" + rutaarchivo);
						if (entry.isDirectory()) {
							fileDest.mkdirs();
						} else {
							if (fileDest.getParentFile().exists() == false)
								fileDest.getParentFile().mkdirs();
							fos = new FileOutputStream(fileDest);
							dest = new BufferedOutputStream(fos, BUFFER);
							while ((count = zis.read(data, 0, BUFFER)) != -1) {
								dest.write(data, 0, count);
							}
							dest.flush();
						}
					} finally {
						try {
							if (dest != null)
								dest.close();
						} catch (Exception e) {
							;
						}
					}
				}
			}
			zis.close();
		} catch (Exception e) {
			System.out.println("Algo malo a sucedido :-(");
		}

		
	}

	
}
