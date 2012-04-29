package com.mydomain.Directorio.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;

import com.mydomain.Directorio.model.Curso;

import com.mydomain.Directorio.model.EnteUniversitario;
import com.mydomain.Directorio.model.GestorMensajeria;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.GrupoUsuarios;
import com.mydomain.Directorio.model.Tipo;
import com.mydomain.Directorio.model.UserAccount;

@Name("taller")
@Stateless
public class Taller2 implements Taller {

	/**
	 * FacesMessages
	 */
	@In
	private FacesMessages facesMessages;

	/**
	 * Instancia de Entitymanager
	 */
	@PersistenceContext
	private EntityManager entityManager;

	public void crearResgistro() {

		/*UserAccount userA = new UserAccount();
		 userA.setPrimerNombre("primerNombre");
		 userA.setCorreoElectronico("correoElectronico@hotmail.co");
		 userA.setDocumentoIdentidad(1l);
		 userA.setApellidos("apellidos");
		 userA.setEnabled(true);
		 userA.setPasswordHash("");
		 userA.setUsername("nicolas6");

		 Facultad facultad = new Facultad();
		 facultad.setNombreFacultad("Ingenieria");
		 entityManager.persist(facultad);

		 LinkedList<Escuela> listaEscuelas = new LinkedList<Escuela>();

		 Escuela escuela = new Escuela();
		 escuela.setNombreEscuela("sistemas");
		 escuela.setIdEscuela((long) 71);

		 listaEscuelas.add(escuela);
		 GrupoCurso grupoCurso = new GrupoCurso();
		 LinkedList<Curso> listaCursos = new LinkedList<Curso>();
		 LinkedList<Curso> listaCursos1 = new LinkedList<Curso>();

		 Curso curso = new Curso();
		 curso.setCodigo((long) 81671);
		 curso.setEscuelaCurso(escuela);
		 //curso.set
		 Set<UserAccount> nuevoMensaje = new HashSet<UserAccount>();
		 Set<GestorMensajeria> nuevoM = new HashSet<GestorMensajeria>();

		 GestorMensajeria gestorMensajeria = new GestorMensajeria();
		 gestorMensajeria.setAsunto("hola");
		 gestorMensajeria
		 .setDeUsuario(entityManager.find(UserAccount.class, 1L));
		 nuevoMensaje.add(entityManager.find(UserAccount.class, 3L));
		 nuevoMensaje.add(entityManager.find(UserAccount.class, 4L));
		 // gestorMensajeria.setParaUsuario(nuevoMensaje);
		 gestorMensajeria.setMensaje("hola");

		 nuevoM.add(gestorMensajeria);
		 //entityManager.persist(userA);

		 UserAccount user = entityManager.find(UserAccount.class, 3L);
		 UserAccount user2 = entityManager.find(UserAccount.class, 4L);
		 */

		/*Tipo tipo = new Tipo();
		 tipo.setNombre("facultad");
		 tipo.setTipo(null);
		 entityManager.persist(tipo);
		 tipo = new Tipo();
		 tipo.setNombre("escuela");
		 tipo.setTipo(entityManager.find(Tipo.class, 1l));
		 entityManager.persist(tipo);

		 EnteUniversitario enteUniversitario = new EnteUniversitario();
		 enteUniversitario.setDescripcionEnteUniversitario("FC");
		 enteUniversitario.setNombreEnteUniversitario("Ciencias");
		 enteUniversitario.setTipoEnteUniversitario(entityManager.find(
		 Tipo.class, 1l));
		 enteUniversitario.setEnteUniversitario(null);
		 entityManager.persist(enteUniversitario);

		 enteUniversitario = new EnteUniversitario();
		 enteUniversitario.setDescripcionEnteUniversitario("fisica");
		 enteUniversitario.setNombreEnteUniversitario("fisica");
		 enteUniversitario.setTipoEnteUniversitario(entityManager.find(
		 Tipo.class, 2l));
		 enteUniversitario.setEnteUniversitario(entityManager.find(
		 EnteUniversitario.class, 3l));
		 entityManager.persist(enteUniversitario);
		 */

		GrupoUsuarios grupoUsuarios = new GrupoUsuarios();
		grupoUsuarios.setUserGrupoCurso(entityManager.find(UserAccount.class,
				1l));
		grupoUsuarios.setGrupoCurso(entityManager.find(GrupoCurso.class, 1l));

		entityManager.persist(grupoUsuarios);
		grupoUsuarios = new GrupoUsuarios();
		grupoUsuarios.setUserGrupoCurso(entityManager.find(UserAccount.class,
				2l));
		grupoUsuarios.setGrupoCurso(entityManager.find(GrupoCurso.class, 1l));

		entityManager.persist(grupoUsuarios);

		/* entityManager.merge(user);
		 entityManager.merge(user);	*/
		entityManager.flush();

	}

	public void eliminarResgistro() {

	}

	public void modificarResgistro() {

	}

	public String findResgistroById() {
		// TODO Auto-generated method stub
		return "";
	}

}
