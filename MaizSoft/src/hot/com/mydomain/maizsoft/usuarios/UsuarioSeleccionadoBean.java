/**
 * 
 */
package com.mydomain.maizsoft.usuarios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.security.Credentials;

import com.mydomain.Directorio.model.Actividad;
import com.mydomain.Directorio.model.ConsultasJpql;
import com.mydomain.Directorio.model.GestorMensajeria;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.Usuario;

/**
 * Descripcion: Esta Clase se encarga de ... Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 27/07/2012
 */
@Stateless
@Name("usuarioSeleccionadoBean")
public class UsuarioSeleccionadoBean implements IUsuarioSeleccionado {


	private List<Usuario> listaUsuarioSeleccionado;

	
	private Usuario usuarioSeleccionado;

	@PersistenceContext
	EntityManager entityManager;

	
	


	/* (non-Javadoc)
	 * @see com.mydomain.maizsoft.usuarios.IUsuarioSeleccionado#getListaUsuarioSeleccionado()
	 */
	@Factory("listaUsuarioSeleccionado")
	public List<Usuario> getListaUsuarioSeleccionado() {

		try {

			Credentials cre = (Credentials) Component
					.getInstance(Credentials.class);
			Query q = entityManager
					.createQuery(ConsultasJpql.USUARIO_POR_USERNAME);
			q.setParameter("parametro", cre.getUsername());
			Usuario nuevo = (Usuario) q.getSingleResult();

			List<Usuario> nue = new ArrayList<Usuario>();
			nue.add(nuevo);

			listaUsuarioSeleccionado = nue;

		} catch (RuntimeException e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Algo malo a sucedido :-( ");
		}

		return listaUsuarioSeleccionado;
	}

	
	/* (non-Javadoc)
	 * @see com.mydomain.maizsoft.usuarios.IUsuarioSeleccionado#getUsuarioSeleccionado()
	 */
	public Usuario getUsuarioSeleccionado() {
		
		return usuarioSeleccionado;
	}

	
	/* (non-Javadoc)
	 * @see com.mydomain.maizsoft.usuarios.IUsuarioSeleccionado#setUsuarioSeleccionado(com.mydomain.Directorio.model.Usuario)
	 */
	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	
	/* (non-Javadoc)
	 * @see com.mydomain.maizsoft.usuarios.IUsuarioSeleccionado#setListaUsuarioSeleccionado(java.util.List)
	 */
	public void setListaUsuarioSeleccionado(
			List<Usuario> listaUsuarioSeleccionado) {
		this.listaUsuarioSeleccionado = listaUsuarioSeleccionado;
	}

	public String rutaImagen() {

		String nueva = "css/images/gis.png";
		
		try {

			Credentials cre = (Credentials) Component
					.getInstance(Credentials.class);
			Query q = entityManager.createQuery(
					ConsultasJpql.USUARIO_POR_USERNAME);
			q.setParameter("parametro", cre.getUsername());
			Usuario nuevo = (Usuario) q.getSingleResult();
			if (nuevo.getFotoUser() == null)
				nueva = "css/images/gis.png";
			else{
				nueva = nuevo.getFotoUser();				
			}
		} catch (RuntimeException e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Algo malo a sucedido :-( ");
		}

		return nueva;

	}
	
	
	public String hayMensajes(){
		List<GestorMensajeria> nuevo=new ArrayList<GestorMensajeria>();
		
		try {
		Credentials cre = (Credentials) Component
				.getInstance(Credentials.class);
		Query q = entityManager.createQuery(
				ConsultasJpql.USUARIO_POR_USERNAME);
		q.setParameter("parametro", cre.getUsername());
		Usuario nuev = (Usuario) q.getSingleResult();
		
		Query q2 = entityManager.createQuery(
				ConsultasJpql.MENSAJES_NO_LEIDOS);
		q2.setParameter("parametro", nuev.getId());
			nuevo = (List<GestorMensajeria>) q2.getResultList();
		
				
		} catch (Exception e) {
			return "/css/images/mensajes.png";
		}
		
		if(nuevo.size()!=0){
		
			return "/css/images/mensajes2.png";
			
		}			
		return "/css/images/mensajes.png";
	}
	
	
	public String hayActividadesPendientes(){
		
		List<Actividad> nuev = new ArrayList<Actividad>();		
		try{	
			Credentials cre = (Credentials) Component
					.getInstance(Credentials.class);
		
			
		Query q = entityManager.createNativeQuery(
				ConsultasJpql.ACTIVIDADES_NO_VENCIDAS_ESTUDIANTE2);
			
		q.setParameter(1,cre.getUsername());
	//	q.setParameter(2, nuevo.getId());
		 nuev = (List<Actividad>) q.getResultList();
		
		if(nuev.size()==0){
			return "/css/images/calendario.png";
		}
		
		} catch (Exception e) {
			return "/css/images/calendario.png";
		}
		
		
			return "/css/images/calendario2.png";
	}
	
}
