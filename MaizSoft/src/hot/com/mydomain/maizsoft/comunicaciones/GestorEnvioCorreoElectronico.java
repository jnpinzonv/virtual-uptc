/**
 * 
 */
package com.mydomain.maizsoft.comunicaciones;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Descripcion: Esta Clase se encarga de ... Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 20/07/2012
 */
public class GestorEnvioCorreoElectronico {

	private String usernameCorreo;

	private String passwordCorreo;

	private Properties props;

	private String remite;

	private String para;

	private String asunto;

	private String cuerpoMensaje;

	/**
	 * @param usernameCorreo
	 * @param passwordCorreo
	 * @param props
	 * @param remite
	 * @param para
	 * @param asunto
	 * @param cuerpoMensaje
	 */
	GestorEnvioCorreoElectronico(String usernameCorreo, String passwordCorreo,
			Properties props, String remite, String para, String asunto,
			String cuerpoMensaje) {
		super();
		this.usernameCorreo = usernameCorreo;
		this.passwordCorreo = passwordCorreo;
		this.props = props;
		this.remite = remite;
		this.para = para;
		this.asunto = asunto;
		this.cuerpoMensaje = cuerpoMensaje;
	}

	/**
	 * 
	 */
	public GestorEnvioCorreoElectronico() {
		
	}

	/**
	 * Se obtiene el valor de usernameCorreo
	 * 
	 * @return El valor de usernameCorreo
	 */
	public String getUsernameCorreo() {
		return usernameCorreo;
	}

	/**
	 * Asigna el valor de usernameCorreo
	 * 
	 * @param usernameCorreo
	 *            El valor por establecer para usernameCorreo
	 */
	public void setUsernameCorreo(String usernameCorreo) {
		this.usernameCorreo = usernameCorreo;
	}

	/**
	 * Se obtiene el valor de passwordCorreo
	 * 
	 * @return El valor de passwordCorreo
	 */
	public String getPasswordCorreo() {
		return passwordCorreo;
	}

	/**
	 * Asigna el valor de passwordCorreo
	 * 
	 * @param passwordCorreo
	 *            El valor por establecer para passwordCorreo
	 */
	public void setPasswordCorreo(String passwordCorreo) {
		this.passwordCorreo = passwordCorreo;
	}

	/**
	 * Se obtiene el valor de props
	 * 
	 * @return El valor de props
	 */
	public Properties getProps() {
		return props;
	}

	/**
	 * Asigna el valor de props
	 * 
	 * @param props
	 *            El valor por establecer para props
	 */
	public void setProps(Properties props) {
		this.props = props;
	}

	/**
	 * Se obtiene el valor de remite
	 * 
	 * @return El valor de remite
	 */
	public String getRemite() {
		return remite;
	}

	/**
	 * Asigna el valor de remite
	 * 
	 * @param remite
	 *            El valor por establecer para remite
	 */
	public void setRemite(String remite) {
		this.remite = remite;
	}

	/**
	 * Se obtiene el valor de para
	 * 
	 * @return El valor de para
	 */
	public String getPara() {
		return para;
	}

	/**
	 * Asigna el valor de para
	 * 
	 * @param para
	 *            El valor por establecer para para
	 */
	public void setPara(String para) {
		this.para = para;
	}

	/**
	 * Se obtiene el valor de asunto
	 * 
	 * @return El valor de asunto
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * Asigna el valor de asunto
	 * 
	 * @param asunto
	 *            El valor por establecer para asunto
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	/**
	 * Se obtiene el valor de cuerpoMensaje
	 * 
	 * @return El valor de cuerpoMensaje
	 */
	public String getCuerpoMensaje() {
		return cuerpoMensaje;
	}

	/**
	 * Asigna el valor de cuerpoMensaje
	 * 
	 * @param cuerpoMensaje
	 *            El valor por establecer para cuerpoMensaje
	 */
	public void setCuerpoMensaje(String cuerpoMensaje) {
		this.cuerpoMensaje = cuerpoMensaje;
	}

	public void addPorps(String auth, String valorAuth, String enable,
			String valorEnable, String host, String valorHost, String port,
			String valorPort) {
		props.put(auth, valorAuth);
		props.put(enable, valorEnable);
		props.put(host, valorHost);
		props.put(port, valorPort);
		
		
	}

	public void enviarEmail() throws AddressException, MessagingException {

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(usernameCorreo,
								passwordCorreo);
					}
				});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(remite));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(para));
		message.setSubject(asunto);
		message.setText(cuerpoMensaje);
  
		Transport.send(message);

	}

}
