package com.mydomain.Directorio.action;

import java.util.Calendar;

import javax.ejb.Stateless;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import com.mydomain.Directorio.model.ConstantesLog;

@Stateless
@Name("authenticator")
public class AuthenticatorBean implements Authenticator
{
    @Logger private Log log;

    @In(create= true)
    Identity identity;
    @In(create= true)
    Credentials credentials;

    public boolean authenticate()
    {
    	System.out.println("pass");
    	identity.login();
    	System.out.println("paso");
    	
        log.info("authenticating {0}", credentials.getUsername());
        //write your authentication logic here,
        //return true if the authentication was
        //successful, false otherwise
//        crearLog();
       if ("admin".equals(credentials.getUsername()))
        {
            identity.addRole("admin");
            return true;
        }
     return false;
        
        
    }
    
//    public void crearLog() {
//		Calendar calendar = Calendar.getInstance();		
//		Credentials cre = (Credentials) Component
//				.getInstance(Credentials.class);
//		log.info("<--" + "[" + ConstantesLog.NOMBRE_PLATAFORMA + "]"
//				+ "Acci�n:" + "[" + ConstantesLog.INGRESO_PLATAFORMA + "]"
//				+ "Tipo:" + "[" + "N/A" + "]"
//				+ "Sobre el grupo con ID:" + "[" + "N/A" + "]"
//				+ "Realizada por:" + "[" + cre.getUsername() + "]"
//				+ "en la fecha:" + "[" + calendar.getTime() + "]" + "-->",
//				cre.getUsername());		
//	}

}
