/**
 * 
 */
package com.mydomain.Directorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

/**
* Descripcion: Esta Clase se encarga de ...
* Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity(name="historialNotas")
@Table(name="historial_notas")
@Name("historialNotas")
@NamedQuery(name="NotasPorUsuario", query="select t from historialNotas t where t.userAccount.documentoIdentidad=:parametro")
public class HistorialNotas {

	/**
	 * Variable en donde se almacena el idenificador
	 * del historial de notas de un usuario.
	 */
	private Long idHistorialNotas;
	
	/**
	 * Variable que almacena la nota o calificaci�n obtenida
	 * por un inscrito al curso.
	 */
	private Long nota;
	
	/**
	 * Variable que almacena informaci�n relacionada a los usuarios.
	 * Instancia de la clase Usuario.
	 */
	private Usuario userAccount;
	
	/**
	 * Variable encargada de guardar informaci�n correspondiente a los
	 * grupos de los diferentes cursos.
	 */
	private GrupoCurso grupoCurso;

	/**
	 * Se obtiene el valor de idHistorialNotas
	 * @return El valor de idHistorialNotas
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_historial_notas", unique = false, nullable = false, insertable = true, updatable = true)
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
	@Column(name = "nota", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "numeric(1)")
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
	@JoinColumn(name = "id_usuario", unique = false, nullable = false, insertable = true, updatable = true)
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
	@JoinColumn(name = "id_grupo_curso", unique = false, nullable = false, insertable = true, updatable = true)
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
