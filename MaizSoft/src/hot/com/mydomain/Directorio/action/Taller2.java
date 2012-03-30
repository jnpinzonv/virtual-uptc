package com.mydomain.Directorio.action;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;

import com.mydomain.Directorio.model.Curso;
import com.mydomain.Directorio.model.Escuela;
import com.mydomain.Directorio.model.Facultad;
import com.mydomain.Directorio.model.GrupoCurso;
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
		/*
		 UserAccount userA = new UserAccount();
		 userA.setPrimerNombre("primerNombre");
		 userA.setCorreoElectronico("correoElectronico@hotmail.co");
		 userA.setApellidos("apellidos");
		 userA.setEnabled(true);*/

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
