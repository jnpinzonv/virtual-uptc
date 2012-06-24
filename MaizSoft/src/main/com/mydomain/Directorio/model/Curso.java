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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Size;
import org.jboss.seam.annotations.Name;


/**
* Descripcion: Esta Clase se encarga de gestionar el almacenamiento de datos, 
* en esta clase con lo referente a los cursos, se comunica con la base de datos
* Modulo de Desarrollo :CU- ...
* @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity
@Table(name="curso")
@Name("curso")
@NamedQuery(name="cursosPorEscuela",query="select c from Curso c where c.enteUniversitario.idEnteUniversitario=:parametro")
public class Curso {

	/**
	 * Variable que almacena el código del curso
	 * Tipo de dato Long
	 */
	private Long codigo;
	
	/**
	 * Variable que almacena el nombre de la asignatura
	 * Tipo de dato String
	 */
	private String nombreAsignatura;	
	
	/**
	 * Variable que almacena los grupos de los cursos
	 * Se instancia de la clase GrupoCursos
	 */
	private Set<GrupoCurso> grupoCursos;
	
	/**
	 * Variable que almacena el ente universitario al cual pertenece el curso
	 * Se instancia de la clase EnteUniversitario
	 */
	private EnteUniversitario enteUniversitario;

	/**
	 * Se obtiene el valor de codigo
	 * @return El valor de codigo
	 */
	@Id
	@NotNull	
	@Column(name = "codigo_curso", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(20)")
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * Asigna el valor de codigo
	 * @param codigo El valor por establecer para codigo
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * Se obtiene el valor de nombreAsignatura
	 * @return El valor de nombreAsignatura
	 */
	@NotEmpty
	@Length(max=200)
	@Column(name = "nombre_asignatura", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(200)")
	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	/**
	 * Asigna el valor de nombreAsignatura
	 * @param nombreAsignatura El valor por establecer para nombreAsignatura
	 */
	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	/**
	 * Se obtiene el valor de grupoCursos
	 * @return El valor de grupoCursos
	 */
	@OneToMany(mappedBy="cursoGrupo", cascade=CascadeType.ALL)
	public Set<GrupoCurso> getGrupoCursos() {
		return grupoCursos;
	}

	/**
	 * Asigna el valor de grupoCursos
	 * @param grupoCursos El valor por establecer para grupoCursos
	 */
	public void setGrupoCursos(Set<GrupoCurso> grupoCursos) {
		this.grupoCursos = grupoCursos;
	}

	/**
	 * Se obtiene el valor de enteUniversitario
	 * @return El valor de enteUniversitario
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "ente_universitario", unique = false, nullable = false, insertable = true, updatable = true)
	public EnteUniversitario getEnteUniversitario() {
		return enteUniversitario;
	}

	/**
	 * Asigna el valor de enteUniversitario
	 * @param enteUniversitario El valor por establecer para enteUniversitario
	 */
	public void setEnteUniversitario(EnteUniversitario enteUniversitario) {
		this.enteUniversitario = enteUniversitario;
	}
}
