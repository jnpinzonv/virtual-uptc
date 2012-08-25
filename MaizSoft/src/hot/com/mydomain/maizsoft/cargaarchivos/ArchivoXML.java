/**
 * 
 */
package com.mydomain.maizsoft.cargaarchivos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 25/08/2012 
 */
public abstract class ArchivoXML {
	
	private String nombre;
	
	private String path;
	
	private FileOutputStream archivo;
	
	/**
	 * 
	 */
	public ArchivoXML() {
		super();
		nombre ="";
		path ="";
		archivo=null;
	}

	/**
	 * Se obtiene el valor de nombre
	 * @return El valor de nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna el valor de nombre
	 * @param nombre El valor por establecer para nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Se obtiene el valor de path
	 * @return El valor de path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Asigna el valor de path
	 * @param path El valor por establecer para path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Se obtiene el valor de archivo
	 * @return El valor de archivo
	 */
	public FileOutputStream getArchivo() {
		return archivo;
	}

	/**
	 * Asigna el valor de archivo
	 * @param archivo El valor por establecer para archivo
	 */
	public void setArchivo(FileOutputStream archivo) {
		this.archivo = archivo;
	}
	
	public void open() throws FileNotFoundException{
		archivo = new FileOutputStream(path+nombre);
	}
	
	public void close() throws IOException {
		archivo.close();
	}
	
	public abstract void  write();
	
	
	public abstract void read();

}
