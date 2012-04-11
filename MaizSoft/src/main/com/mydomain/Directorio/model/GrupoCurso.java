/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Nicolas
 *
 */
@Entity
@Table(name= "grupo_curso")
public class GrupoCurso {
	
	private Long idGrupo;
		
	private Integer cupos;
	
	private Integer inscritos;
	
	private Curso cursoGrupo;
	
	private Set<UserAccount> listaUsuarios;

	private Set< Actividad> actividades;
	
	private Set<GestorEnlacesExternos> enlacesExternos;
	
	private Set<GestorAnuncios> gestorAnuncios;
	
	private Set<GestorAudioConferencia> gestorAudio;
	
	private Set<GestorVideoConferencia> gestorVideo;
	/**
	 * @return the idGrupo
	 */
	@Id
	public Long getIdGrupo() {
		return idGrupo;
	}

	/**
	 * @param idGrupo the idGrupo to set
	 */
	public void setIdGrupo(Long idGrupo) {
		idGrupo = idGrupo;
	}

	
	/**
	 * @return the cupos
	 */
	@Column(name="cupos")
	public Integer getCupos() {
		return cupos;
	}

	/**
	 * @param cupos the cupos to set
	 */
	public void setCupos(Integer cupos) {
		this.cupos = cupos;
	}

	/**
	 * @return the inscritos
	 */
	@Column(name="inscritos")
	public Integer getInscritos() {
		return inscritos;
	}

	/**
	 * @param inscritos the inscritos to set
	 */
	public void setInscritos(Integer inscritos) {
		this.inscritos = inscritos;
	}

	/**
	 * @return the cursoGrupo
	 */
	@ManyToOne
	public Curso getCursoGrupo() {
		return cursoGrupo;
	}

	/**
	 * @param cursoGrupo the cursoGrupo to set
	 */
	public void setCursoGrupo(Curso cursoGrupo) {
		this.cursoGrupo = cursoGrupo;
	}

	/**
	 * @return the listaUsuarios
	 */
	@OneToMany(mappedBy="grupoCurso")
	public Set<UserAccount> getListaUsuarios() {
		if(listaUsuarios==null){
			return new HashSet<UserAccount>();
		}
		return listaUsuarios;
	}

	/**
	 * @param listaUsuarios the listaUsuarios to set
	 */
	public void setListaUsuarios(Set<UserAccount> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	/**
	 * @return the actividades
	 */
	@OneToMany(mappedBy="actividadGrupoCurso")
	public Set<Actividad> getActividades() {
		if(actividades==null){
			return new HashSet<Actividad>();
		}
		return actividades;
	}

	/**
	 * @param actividades the actividades to set
	 */
	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}

	/**
	 * @return the enlacesExternos
	 */
	@OneToMany(mappedBy="grupoCurso")
	public Set<GestorEnlacesExternos> getEnlacesExternos() {
		if(enlacesExternos==null){
			return new HashSet<GestorEnlacesExternos>();
		}
		return enlacesExternos;
	}

	/**
	 * @param enlacesExternos the enlacesExternos to set
	 */
	public void setEnlacesExternos(Set<GestorEnlacesExternos> enlacesExternos) {
		this.enlacesExternos = enlacesExternos;
	}

	/**
	 * @return the gestorAnuncios
	 */
	@OneToMany(mappedBy="grupoCursoAnuncio")
	public Set<GestorAnuncios> getGestorAnuncios() {
		if(gestorAnuncios==null){
			return new HashSet<GestorAnuncios>();
		}
		return gestorAnuncios;
	}

	/**
	 * @param gestorAnuncios the gestorAnuncios to set
	 */
	public void setGestorAnuncios(Set<GestorAnuncios> gestorAnuncios) {
		this.gestorAnuncios = gestorAnuncios;
	}

	/**
	 * @return the gestorAudio
	 */
	@OneToMany(mappedBy="grupoCursoAudio")
	public Set<GestorAudioConferencia> getGestorAudio() {
		if(gestorAudio==null){
			return new HashSet<GestorAudioConferencia>();
		}
		return gestorAudio;
	}

	/**
	 * @param gestorAudio the gestorAudio to set
	 */
	
	public void setGestorAudio(Set<GestorAudioConferencia> gestorAudio) {
		this.gestorAudio = gestorAudio;
	}

	/**
	 * @return the gestorVideo
	 */
	@OneToMany(mappedBy="grupoCursoVideo")
	public Set<GestorVideoConferencia> getGestorVideo() {
		if(gestorVideo==null){
			return new HashSet<GestorVideoConferencia>();
		}
		return gestorVideo;
	}

	/**
	 * @param gestorVideo the gestorVideo to set
	 */
	public void setGestorVideo(Set<GestorVideoConferencia> gestorVideo) {
		this.gestorVideo = gestorVideo;
	}

	
	
	
	
	

}
