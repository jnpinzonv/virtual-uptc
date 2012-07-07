package com.mydomain.maizsoft.curso;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.Query;

import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.framework.EntityHome;

import com.mydomain.Directorio.model.Curso;
import com.mydomain.Directorio.model.GestorEnlacesExternos;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.GrupoUsuarios;
import com.mydomain.Directorio.model.HistorialNotas;

@Name("grupoCursoHome")

public class GrupoCursoHome extends EntityHome<GrupoCurso> {

	public final static int MAX_SEMANAS=20;
	
	@In(create = true)
	CursoHome cursoHome;
	
	@DataModel("listaGrupos")
	private List<GrupoCurso> listaGrupos;
	
	FacesContext facesContext;
	
	
	@DataModelSelection
	GrupoCurso seleccionado;

	public void setGrupoCursoIdGrupo(Long id) {
		setId(id);
	}

	public Long getGrupoCursoIdGrupo() {
		return (Long) getId();
	}

	@Override
	protected GrupoCurso createInstance() {
		GrupoCurso grupoCurso = new GrupoCurso();
		return grupoCurso;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Curso cursoGrupo = cursoHome.getDefinedInstance();
		if (cursoGrupo != null) {
			getInstance().setCursoGrupo(cursoGrupo);
		}
	}

	public boolean isWired() {
		if (getInstance().getCursoGrupo() == null)
			return false;
		return true;
	}

	public GrupoCurso getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<GestorEnlacesExternos> getEnlacesExternos() {
		return getInstance() == null
				? null
				: new ArrayList<GestorEnlacesExternos>(getInstance()
						.getEnlacesExternos());
	}
	public List<GrupoUsuarios> getGrupoUsuarios() {
		return getInstance() == null ? null : new ArrayList<GrupoUsuarios>(
				getInstance().getGrupoUsuarios());
	}
	public List<HistorialNotas> getListaHistorialNotas() {
		return getInstance() == null ? null : new ArrayList<HistorialNotas>(
				getInstance().getListaHistorialNotas());
	}
	
	@Factory ("listaSemanaMaxima")
	public List<Integer> getMaximoSemanas(){
		ArrayList<Integer> maximo = new ArrayList<Integer>();
		
		for (int i = 1; i < MAX_SEMANAS+1; i++) {
			maximo.add(i);
		}
		
		return maximo;
	}


	/**
	 * Se obtiene el valor de listaGrupos
	 * @return El valor de listaGrupos
	 */
	public List<GrupoCurso> getListaGrupos() {
		Query q = getEntityManager().createNamedQuery("gruposTotalCurso");
		listaGrupos=q.getResultList();
		return listaGrupos;
	}

	/**
	 * Asigna el valor de listaGrupos
	 * @param listaGrupos El valor por establecer para listaGrupos
	 */
	public void setListaGrupos(List<GrupoCurso> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public List<GrupoCurso> listaGrupos(){
		Query q = getEntityManager().createNamedQuery("gruposTotalCurso");
		listaGrupos=q.getResultList();
		return listaGrupos;
	}
	/**
	 * Se obtiene el valor de seleccionado
	 * @return El valor de seleccionado
	 */
	public GrupoCurso getSeleccionado() {
		return seleccionado;
	}

	/**
	 * Asigna el valor de seleccionado
	 * @param seleccionado El valor por establecer para seleccionado
	 */
	public void setSeleccionado(GrupoCurso seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	
	public String selecionado(long grupo){
		
		instance=seleccionado;
		System.out.println(grupo+ "holaaaaaaaaaaaaaa");
		//System.out.println(instance.getIdGrupo()+ "hola mundooooooooooooooooooooo");
		System.out.println(facesContext.getCurrentInstance().getExternalContext().getRequestMap().get("grupoCursoIdGrupo")+ "holooooooooooooooo");

		return"/CuerpoCurso.xhtml";
		
	}
	
	

}
