/**
 * 
 */
package com.mydomain.maizsoft.usuarios;

import java.util.Properties;

import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.security.Restrict;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.security.management.action.UserAction;
import org.jboss.seam.security.management.action.UserSearch;

import com.mydomain.Directorio.action.StringEncrypter;
import com.mydomain.Directorio.model.ConfiguracionesSistema;
import com.mydomain.Directorio.model.ConstantesLog;
import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.UserAccount;
import com.mydomain.Directorio.model.Usuario;
import com.mydomain.maizsoft.comunicaciones.GestorEnvioCorreoElectronico;

/**
 * Descripcion: Esta Clase se encarga de ...
 * Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
 * Grupo de Investigacion Ingenieria Software (GIS)
 * Semillero de Investigacion Moviles Sabatt (SIMS)
 * Universidad Pedagogica y Tecnologica de Colombia
 * @version 20/07/2012 
 */
@Name("gestionarOlvidoContraseniaBean")
@Stateless
public class GestionarOlvidoContraseniaBean implements IGestionarOlvidoContrasenia{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@In(create=true)
	private UserAccount userAccount;
	
	@In(create=true)
	private Usuario usuario;
	
	@In(create=true)
	UserAction userAction;
	
	
	

	
	
	public  long aleatorio(int max,int min){
		return (long)(Math.random()*(max-min))+min;		
}
	
	public String usuarioValido(){	
	
				
		Query q =entityManager.createQuery(ConsultasJpql.USUARIO_POR_MAIL);
		q.setParameter("parametro",usuario.getCorreoElectronico());
		
		Query q1 =entityManager.createQuery(ConsultasJpql.USUARIO_POR_USERNAME);
		q1.setParameter("parametro",userAccount.getUsername());
		
	
		
		Usuario u1= (Usuario) q.getSingleResult();
		Usuario u2= (Usuario) q1.getSingleResult();
		
		if(u1.equals(u2)){
			
			Query q3 =entityManager.createQuery(ConsultasJpql.USERACCOUNT_POR_USERNAME);
			q3.setParameter("parametro",userAccount.getUsername());
			UserAccount u =(UserAccount)q3.getSingleResult();
			  String passPhrase   = ConstantesLog.NOMBRE_PLATAFORMA;
		        // Create encrypter/decrypter class
		        StringEncrypter desEncrypter = new StringEncrypter(passPhrase);
		     
		        // Decrypt the string
		        String desDecrypted       = desEncrypter.decrypt(u.getCampoGenerarPassword());
			
		        enviarEmail(u1.getCorreoElectronico(), desDecrypted);			
		}
		else{
			
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Los parametros NO son validos, por favor intente de nuevo :)");
			return "";
		}
		try {
		} catch (RuntimeException e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Los parametros NO existen, por favor intente de nuevo :)");
			return "";
		}
		return "/login.seam";
		
	}
	/* (non-Javadoc)
	 * @see com.mydomain.maizsoft.usuarios.IGestionarOlvidoContrasenia#enviarEmail()
	 */
	
	public void enviarEmail(String para, String clave) {
	
		GestorEnvioCorreoElectronico nuevo= new GestorEnvioCorreoElectronico();
		nuevo.setAsunto(getConfiguracion("asuntoMail").getDetallesPropiedad());
		nuevo.setCuerpoMensaje(getConfiguracion("cuerpoMensaje").getDetallesPropiedad() + clave);
		nuevo.setUsernameCorreo(getConfiguracion("correoElectronico").getDetallesPropiedad());
		nuevo.setPasswordCorreo(getConfiguracion("contraseniaCorreo").getDetallesPropiedad());
		nuevo.setRemite(getConfiguracion("correoElectronico").getDetallesPropiedad());
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", getConfiguracion("mail.smtp.auth").getDetallesPropiedad());
		props.put("mail.smtp.starttls.enable",getConfiguracion("mail.smtp.starttls.enable").getDetallesPropiedad());
		props.put("mail.smtp.host", getConfiguracion("mail.smtp.host").getDetallesPropiedad());
		props.put("mail.smtp.port", getConfiguracion("mail.smtp.port").getDetallesPropiedad());
			
		nuevo.setProps(props);
		nuevo.setPara(para);
		
		try {
			nuevo.enviarEmail();
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Mensaje Enviado... :)");
		} catch (AddressException e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Se produjo un error al enviar el correo, posible causa: La dirección correo no es valida :(");
		} catch (MessagingException e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Se produjo un error técnico :(");
		}
		
		
		
		
	}
	
	
	public ConfiguracionesSistema getConfiguracion(String nombrePropiedad){
	
		Query q =entityManager.createQuery(ConsultasJpql.CONFIGURACIONES_SISTEMA_POR_PROPIEDAD);
		q.setParameter("parametro",nombrePropiedad);
		
		return (ConfiguracionesSistema) q.getSingleResult();
	}

}
