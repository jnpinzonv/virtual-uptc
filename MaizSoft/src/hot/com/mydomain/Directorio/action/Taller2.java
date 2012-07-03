package com.mydomain.Directorio.action;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.security.management.PasswordHash;

import com.mydomain.Directorio.model.EnteUniversitario;
import com.mydomain.Directorio.model.GrupoCurso;
import com.mydomain.Directorio.model.GrupoUsuarios;
import com.mydomain.Directorio.model.Tipo;
import com.mydomain.Directorio.model.UserAccount;
import com.mydomain.Directorio.model.Usuario;

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

	public Long crearResgistro() {

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
				grupoUsuarios.setUserGrupoCurso(entityManager.find(Usuario.class,
						1l));
				grupoUsuarios.setGrupoCurso(entityManager.find(GrupoCurso.class, 1l));		
				entityManager.persist(grupoUsuarios);
		//		grupoUsuarios = new GrupoUsuarios();
		//		grupoUsuarios.setUserGrupoCurso(entityManager.find(UserAccount.class,
		//				2l));
		//		grupoUsuarios.setGrupoCurso(entityManager.find(GrupoCurso.class, 1l));
		//System.out.println(userAction.getUsername()+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		/*Usuario userA = new Usuario();
		userA.setPrimerNombre("primerNombre");
		userA.setCorreoElectronico("correoElectronico@hotmail.co");
		userA.setDocumentoIdentidad(1l);
		userA.setApellidos("apellidos");
		/*	userA.setEnabled(true);
		 userA.setPasswordHash("1");
		 userA.setPassword("1");
		 userA.setConfirm("1");
		 userA.setUsername("nicolas1");*/
		//userA.setRoles(userAction.getRoles());
/*		userA.setEnteUniversitarios(entityManager.find(EnteUniversitario.class,
				1L));
		userA.setTipo(entityManager.find(Tipo.class, 3L));
*/		//entityManager.persist(userA);

		/* entityManager.merge(user);
		 entityManager.merge(user);	*/
		//userAction=userA;
		/*userA.createUser();
		 userA.save();*/
		//entityManager.flush();
/*		PasswordHash nuevo = (PasswordHash) Component
				.getInstance(PasswordHash.class);
		facesMessages.add(nuevo.generateHash(""));
		
		Query q = entityManager
				.createQuery("select t from EnteUniversitario t where t.tipoEnteUniversitario=19");
		List<EnteUniversitario> listaTiposEnteUniversitarios = q.getResultList();
		facesMessages.add(listaTiposEnteUniversitarios.get(0).getClass()+"");
		for (int i = 0; i < 2; i++) {
			facesMessages.add(listaTiposEnteUniversitarios.get(0).getNombreEnteUniversitario());
		}
	
*/
				return 1L;
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
