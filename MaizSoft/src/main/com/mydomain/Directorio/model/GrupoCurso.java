/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Size;

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
	
	private String semestre;
	
	private Set<GestorEnlacesExternos> enlacesExternos;

	private Set<GrupoUsuarios> grupoUsuarios;
	
	private Set<HistorialNotas> listaHistorialNotas;
	/**
	 * @return the idGrupo
	 */
	@Id
	@NotNull
	public Long getIdGrupo() {
		return idGrupo;
	}

	/**
	 * @param idGrupo the idGrupo to set
	 */
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	
	/**
	 * @return the cupos
	 */
	@Column(name="cupos")
	@NotNull
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
	@NotNull
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
	@NotNull
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
	 * @return the enlacesExternos
	 */
	@OneToMany(mappedBy="grupoCurso",cascade=CascadeType.ALL)
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
	 * @return the listaHistorialNotas
	 */
	@OneToMany(mappedBy="grupoCurso",cascade=CascadeType.ALL)
	public Set<HistorialNotas> getListaHistorialNotas() {
		if(listaHistorialNotas==null){
			return new HashSet<HistorialNotas>();
		}
		return listaHistorialNotas;
	}

	/**
	 * @param listaHistorialNotas the listaHistorialNotas to set
	 */
	public void setListaHistorialNotas(Set<HistorialNotas> listaHistorialNotas) {
		this.listaHistorialNotas = listaHistorialNotas;
	}

	/**
	 * @return the grupoUsuarios
	 */
	@OneToMany(mappedBy="grupoCurso",cascade=CascadeType.ALL)
	public Set<GrupoUsuarios> getGrupoUsuarios() {
		return grupoUsuarios;
	}

	/**
	 * @param grupoUsuarios the grupoUsuarios to set
	 */
	public void setGrupoUsuarios(Set<GrupoUsuarios> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

	/**
	 * @return the semestre
	 */
	@NotNull
	@Length(max=20)
	public String getSemestre() {
		return semestre;
	}

	/**
	 * @param semestre the semestre to set
	 */
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	
	
	
	
	

}
