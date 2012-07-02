package com.mydomain.maizsoft.comunicaciones;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.Query;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.framework.EntityHome;

import com.mydomain.Directorio.model.GestorMensajeria;
import com.mydomain.Directorio.model.GrupoUsuarios;
import com.mydomain.Directorio.model.NotaActividad;
import com.mydomain.Directorio.model.Tipo;
import com.mydomain.Directorio.model.Usuario;
import com.mydomain.maizsoft.curso.GrupoCursoHome;
import com.mydomain.maizsoft.tipos.TipoHome;
import com.mydomain.maizsoft.usuarios.UsuarioHome;

@Name("gestorMensajeriaHome")
public class GestorMensajeriaHome extends EntityHome<GestorMensajeria> {

	@In(create = true)
	UsuarioHome usuarioHome;
	@In(create = true)
	GestorMensajeriaHome gestorMensajeriaHome;
	@In(create = true)
	TipoHome tipoHome;
	
	@In(create=true)	
	GrupoCursoHome grupoCursoHome;


	public void setGestorMensajeriaIdMensaje(Long id) {
		setId(id);
	}

	public Long getGestorMensajeriaIdMensaje() {
		return (Long) getId();
	}

	@Override
	protected GestorMensajeria createInstance() {
		GestorMensajeria gestorMensajeria = new GestorMensajeria();
		return gestorMensajeria;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Usuario deUsuario = usuarioHome.getDefinedInstance();
		if (deUsuario != null) {
			getInstance().setDeUsuario(deUsuario);
		}
		Tipo tipo = tipoHome.getDefinedInstance();
		if (tipo != null) {
			getInstance().setTipo(tipo);
		}
	}

	public boolean isWired() {
		if (getInstance().getDeUsuario() == null)
			return false;
		if (getInstance().getTipo() == null)
			return false;
		return true;
	}

	public GestorMensajeria getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GestorMensajeria> getListaGestorMensajeria() {
		return getInstance() == null ? null : new ArrayList<GestorMensajeria>(
				getInstance().getListaGestorMensajeria());
	}
	public List<NotaActividad> getNotaActividad() {
		return getInstance() == null ? null : new ArrayList<NotaActividad>(
				getInstance().getNotaActividad());
	}
	
	@Factory("listaUsuarioCursos")
	public List<SelectItem> listaUsuariosCurso(){
		
		
		Query q = getEntityManager().createQuery("select t from GrupoUsuarios t where t.grupoCurso.idGrupo=#{cursoActualBean.seleccionado.idGrupo}");
				
		
		//q.setParameter("parametro", "#{cursoActualBean.seleccionado.idGrupo}"));
		List<GrupoUsuarios> listaEntesUniversitarios = (List<GrupoUsuarios>)q.getResultList();
		
		
		 
		 List<SelectItem> sItems = new ArrayList<SelectItem>(); 
	      for(GrupoUsuarios sObj : listaEntesUniversitarios){
	    	  Usuario nuevo=sObj.getUserGrupoCurso();
	    	  String var=nuevo.getPrimerNombre() +" "+nuevo.getApellidos();
	          SelectItem sItem = new SelectItem(sObj, var);
	          sItems.add(sItem);
	         
	      }
		return sItems;
	}
	
	public String retornar(){
		
		return "/GestorMensajeriaEdit.seam";
	}

}
