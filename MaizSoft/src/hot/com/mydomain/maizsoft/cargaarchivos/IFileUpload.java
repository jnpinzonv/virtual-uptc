/**
 * 
 */
package com.mydomain.maizsoft.cargaarchivos;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.ejb.Local;

import org.richfaces.event.UploadEvent;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Local
public interface IFileUpload {

	
	 public void paint(OutputStream stream, Object object) throws IOException;
	 
	 public void listener(UploadEvent event) throws Exception;
	 
	 public String clearUploadData();
	 
	 public long getTimeStamp();
	 
	 public ArrayList<File> getFiles();
	 
	 public int getSize();
	 
	 public void setFiles(ArrayList<File> files);
	 
	 public int getUploadsAvailable();
	 
	 public void setUploadsAvailable(int uploadsAvailable);
	 
	 public boolean isAutoUpload();
	 
	 public void setAutoUpload(boolean autoUpload);
	 
	 public boolean isUseFlash();
	 
	 public void setUseFlash(boolean useFlash);
}
