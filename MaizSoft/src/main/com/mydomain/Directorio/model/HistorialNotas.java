/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

/**
 *@author Josué Nicolás Pinzón Villamil <jnpinzonv@hotmail.com>
 *@Version${date}
 */
@Entity
@Table(name= "historial_notas")
public class HistorialNotas {

	private Long idHistorialNotas;
	
	private Long nota;
	
	private Usuario userAccount;
	
	private GrupoCurso grupoCurso;

	/**
	 * @return the idHistorialNotas
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdHistorialNotas() {
		return idHistorialNotas;
	}

	/**
	 * @param idHistorialNotas the idHistorialNotas to set
	 */
	public void setIdHistorialNotas(Long idHistorialNotas) {
		this.idHistorialNotas = idHistorialNotas;
	}

	/**
	 * @return the nota
	 */
	@NotNull
	public Long getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(Long nota) {
		this.nota = nota;
	}

	/**
	 * @return the userAccount
	 */
	@NotNull
	@ManyToOne
	public Usuario getUserAccount() {
		return userAccount;
	}

	/**
	 * @param userAccount the userAccount to set
	 */
	public void setUserAccount(Usuario userAccount) {
		this.userAccount = userAccount;
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
	
	
	
	
	
	
}
