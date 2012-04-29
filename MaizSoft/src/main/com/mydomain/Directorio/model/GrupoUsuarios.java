/**
 * 
 */
package com.mydomain.Directorio.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name ="grupo_usuarios")
public class GrupoUsuarios {

	private Long idGrupoUsuarios;
	
	private UserAccount userGrupoCurso;
	
	private GrupoCurso grupoCurso;

	private Set<NotaActividad> notaActividades;
	
	
	
	
	
	

	/**
	 * @return the userGrupoCurso
	 */

	@ManyToOne
	public UserAccount getUserGrupoCurso() {
		return userGrupoCurso;
	}

	/**
	 * @return the idGrupoUsuarios
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdGrupoUsuarios() {
		return idGrupoUsuarios;
	}

	/**
	 * @param idGrupoUsuarios the idGrupoUsuarios to set
	 */
	public void setIdGrupoUsuarios(Long idGrupoUsuarios) {
		this.idGrupoUsuarios = idGrupoUsuarios;
	}

	/**
	 * @param userGrupoCurso the userGrupoCurso to set
	 */
	public void setUserGrupoCurso(UserAccount userGrupoCurso) {
		this.userGrupoCurso = userGrupoCurso;
	}

	/**
	 * @return the grupoCurso
	 */
	@NotNull
	@ManyToOne
	public GrupoCurso getGrupoCurso() {
		return grupoCurso;
	}

	/**
	 * @param grupoCurso the grupoCurso to set
	 */
	public void setGrupoCurso(GrupoCurso grupoCurso) {
		this.grupoCurso = grupoCurso;
	}

	/**
	 * @return the notaActividades
	 */
	@OneToMany(mappedBy="grupoCurso",cascade=CascadeType.ALL)
	public Set<NotaActividad> getNotaActividades() {
		if(notaActividades==null){
			return new HashSet<NotaActividad>();
		}
		return notaActividades;
	}

	/**
	 * @param notaActividades the notaActividades to set
	 */
	public void setNotaActividades(Set<NotaActividad> notaActividades) {
		this.notaActividades = notaActividades;
	}
	
	
	
	
}
