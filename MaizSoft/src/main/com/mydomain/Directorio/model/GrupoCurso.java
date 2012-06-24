package com.mydomain.Directorio.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;


/**
* Descripcion: Esta Clase se encarga de definir las variables relacionadas con los grupos de 
* los cursos de las diferentes asignaturas como lo son: el c�digo del grupo, su n�mero de 
* identificaci�n, la cantidad de cupos con los que cuenta, el n�mero de alumnos inscritos en 
* cada curso, semestre al que pertenece el curso y sus inscritos, el historial de notas de 
* las personas que conforman determinado grupo o curso y la lista de usuarios del mismo.
* Modulo de Desarrollo :CU- ...
* @author Edwin Jose Hernandez Ni�o edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 22/06/2012 
*/
@Entity(name="grupoCurso")
@Table(name= "grupo_curso")
@Name("grupoCurso")
@NamedQueries({ @NamedQuery(name="gruposPorCurso",query="select g from grupoCurso g where g.cursoGrupo.codigo=:parametro")})
public class GrupoCurso {

	/**
	 * Variable encargada de almacenar el c�digo del grupo.
	 */
	private Long codigoGrupo;
	
	/**
	 * Variable encargada de almacenar la identificaci�n del grupo.
	 */
	private Long idGrupo;


	/**
	 * Variable encargada de almacenar la cantidad de cupos
	 * disponibles en determinado grupo.
	 */
	private Integer cupos;
	
	/**
	 * Variable que almacena el n�mero de estudiantes inscritos
	 * en un grupo.
	 */
	private Integer inscritos;
	
	/**
	 * 
	 */
	private Curso cursoGrupo;
	
	/**
	 * Variable que almacena el semestre al que pertenece el grupo de
	 * determinado curso.
	 */
	private String semestre;
	
	/**
	 * Variable que almacena la lista de enlaces externos del grupo.
	 */
	private Integer numeroTotal;
	
	private Set<GestorEnlacesExternos> enlacesExternos;

	/**
	 * Variable encargada de almacenar los usuarios del grupo.
	 */
	private Set<GrupoUsuarios> grupoUsuarios;
	
	/**
	 * Variable encargada de guardar la lista del historial de
	 * calificaciones de los integrantes del grupo.
	 */
	private Set<HistorialNotas> listaHistorialNotas;
	/**
	 * Variable encargada de guardar la lista del n�mero de
	 * divisiones del curso.
	 */
	private Set<NumeroDivisiones> numeroDivisiones;
	
	/**
	 * Se obtiene el valor de codigoGrupo
	 * @return El valor de codigoGrupo
	 */
	@Column(name = "id_codigo_grupo", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "numeric(15)")
	public Long getCodigoGrupo() {
		return codigoGrupo;
	}

	/**
	 * Asigna el valor de codigoGrupo
	 * @param codigoGrupo El valor por establecer para codigoGrupo
	 */
	public void setCodigoGrupo(Long codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}
	
	/**
	 * Se obtiene el valor de idGrupo
	 * @return El valor de idGrupo
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_grupo", unique = false, nullable = false, insertable = true, updatable = true)
	public Long getIdGrupo() {
		return idGrupo;
	}

	/**
	 * Asigna el valor de idGrupo
	 * @param idGrupo El valor por establecer para idGrupo
	 */
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	/**
	 * Se obtiene el valor de cupos
	 * @return El valor de cupos
	 */
	@NotNull
	@Column(name = "cupos", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "numeric(4)")
	public Integer getCupos() {
		return cupos;
	}

	/**
	 * Asigna el valor de cupos
	 * @param cupos El valor por establecer para cupos
	 */
	public void setCupos(Integer cupos) {
		this.cupos = cupos;
	}
	
	/**
	 * Se obtiene el valor de inscritos
	 * @return El valor de inscritos
	 */
	
	@NotNull
	@Column(name = "inscritos", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "numeric(4)")
	public Integer getInscritos() {
		return inscritos;
	}

	/**
	 * Asigna el valor de inscritos
	 * @param inscritos El valor por establecer para inscritos
	 */
	public void setInscritos(Integer inscritos) {
		this.inscritos = inscritos;
	}

	/**
	 * Se obtiene el valor de cursoGrupo
	 * @return El valor de cursoGrupo
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_curso_grupo", unique = false, nullable = false, insertable = true, updatable = true)
	public Curso getCursoGrupo() {
		return cursoGrupo;
	}

	/**
	 * Asigna el valor de cursoGrupo
	 * @param cursoGrupo El valor por establecer para cursoGrupo
	 */
	public void setCursoGrupo(Curso cursoGrupo) {
		this.cursoGrupo = cursoGrupo;
	}
	
	/**
	 * Se obtiene el valor de enlacesExternos
	 * @return El valor de enlacesExternos
	 */
	@OneToMany(mappedBy="grupoCurso",cascade=CascadeType.ALL)
	public Set<GestorEnlacesExternos> getEnlacesExternos() {
		if(enlacesExternos==null){
			return new HashSet<GestorEnlacesExternos>();
		}
		return enlacesExternos;
	}

	/**
	 * Asigna el valor de enlacesExternos
	 * @param enlacesExternos El valor por establecer para enlacesExternos
	 */
	public void setEnlacesExternos(Set<GestorEnlacesExternos> enlacesExternos) {
		this.enlacesExternos = enlacesExternos;
	}

	/**
	 * Se obtiene el valor de listaHistorialNotas
	 * @return El valor de listaHistorialNotas
	 */
	@OneToMany(mappedBy="grupoCurso",cascade=CascadeType.ALL)
	public Set<HistorialNotas> getListaHistorialNotas() {
		if(listaHistorialNotas==null){
			return new HashSet<HistorialNotas>();
		}
		return listaHistorialNotas;
	}

	/**
	 * Asigna el valor de listaHistorialNotas
	 * @param listaHistorialNotas El valor por establecer para listaHistorialNotas
	 */
	public void setListaHistorialNotas(Set<HistorialNotas> listaHistorialNotas) {
		this.listaHistorialNotas = listaHistorialNotas;
	}

	/**
	 * Se obtiene el valor de grupoUsuarios
	 * @return El valor de grupoUsuarios
	 */
	@OneToMany(mappedBy="grupoCurso",cascade=CascadeType.ALL)
	public Set<GrupoUsuarios> getGrupoUsuarios() {
		if(grupoUsuarios==null){
			return new HashSet<GrupoUsuarios>();
		}
		return grupoUsuarios;
	}

	/**
	 * Asigna el valor de grupoUsuarios
	 * @param grupoUsuarios El valor por establecer para grupoUsuarios
	 */
	public void setGrupoUsuarios(Set<GrupoUsuarios> grupoUsuarios) {
		this.grupoUsuarios = grupoUsuarios;
	}

	/**
	 * Se obtiene el valor de semestre
	 * @return El valor de semestre
	 */
	@NotNull
	@Length(max=20)
	@Column(name = "semestre", unique = false, nullable = false, insertable = true, updatable = true, columnDefinition = "varchar(20)")
	public String getSemestre() {
		return semestre;
	}

	/**
	 * Asigna el valor de semestre
	 * @param semestre El valor por establecer para semestre
	 */
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	
	
	/**
	 * @return the numeroTotal
	 */
	@Column(name = "numero_total", unique = false, nullable = true, insertable = true, updatable = true, columnDefinition = "numeric(4)")
	public Integer getNumeroTotal() {
		return numeroTotal;
	}


	/**
	 * @param numeroTotal the numeroTotal to set
	 */
	public void setNumeroTotal(Integer numeroTotal) {
		this.numeroTotal = numeroTotal;
	}

	/**
	 * @return the numeroDivisiones
	 */
	@OneToMany(mappedBy="grupoCurso",cascade=CascadeType.ALL)
	public Set<NumeroDivisiones> getNumeroDivisiones() {
		return numeroDivisiones;
	}

	/**
	 * @param numeroDivisiones the numeroDivisiones to set
	 */
	public void setNumeroDivisiones(Set<NumeroDivisiones> numeroDivisiones) {
		this.numeroDivisiones = numeroDivisiones;
	}
}
