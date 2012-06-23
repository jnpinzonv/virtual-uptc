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
* Descripcion: Esta Clase se encarga de ...
* Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity
@Table(name= "historial_notas")
public class HistorialNotas {

	/**
	 * Variable en donde se almacena el idenificador
	 * del historial de notas de un usuario.
	 */
	private Long idHistorialNotas;
	
	/**
	 * Variable que almacena la nota o calificación obtenida
	 * por un inscrito al curso.
	 */
	private Long nota;
	
	/**
	 * Variable que almacena información relacionada a los usuarios.
	 * Instancia de la clase Usuario.
	 */
	private Usuario userAccount;
	
	/**
	 * Variable encargada de guardar información correspondiente a los
	 * grupos de los diferentes cursos.
	 */
	private GrupoCurso grupoCurso;

	/**
	 * Se obtiene el valor de idHistorialNotas
	 * @return El valor de idHistorialNotas
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdHistorialNotas() {
		return idHistorialNotas;
	}

	/**
	 * Asigna el valor de idHistorialNotas
	 * @param idHistorialNotas El valor por establecer para idHistorialNotas
	 */
	public void setIdHistorialNotas(Long idHistorialNotas) {
		this.idHistorialNotas = idHistorialNotas;
	}

	/**
	 * Se obtiene el valor de nota
	 * @return El valor de nota
	 */
	@NotNull
	public Long getNota() {
		return nota;
	}

	/**
	 * Asigna el valor de nota
	 * @param nota El valor por establecer para nota
	 */
	public void setNota(Long nota) {
		this.nota = nota;
	}

	/**
	 * Se obtiene el valor de userAccount
	 * @return El valor de userAccount
	 */
	@NotNull
	@ManyToOne
	public Usuario getUserAccount() {
		return userAccount;
	}

	/**
	 * Asigna el valor de userAccount
	 * @param userAccount El valor por establecer para userAccount
	 */
	public void setUserAccount(Usuario userAccount) {
		this.userAccount = userAccount;
	}
	
	/**
	 * Se obtiene el valor de grupoCurso
	 * @return El valor de grupoCurso
	 */
	@NotNull
	@ManyToOne
	public GrupoCurso getGrupoCurso() {
		return grupoCurso;
	}

	/**
	 * Asigna el valor de grupoCurso
	 * @param grupoCurso El valor por establecer para grupoCurso
	 */
	public void setGrupoCurso(GrupoCurso grupoCurso) {
		this.grupoCurso = grupoCurso;
	}
}
