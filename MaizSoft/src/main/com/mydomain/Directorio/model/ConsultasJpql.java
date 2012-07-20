/**
 * 
 */
package com.mydomain.Directorio.model;

/**
 * Descripcion: Esta Clase se encarga de ... Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 08/07/2012
 */
public interface ConsultasJpql {

	String LISTA_MENSAJES_USUARIO = "SELECT g FROM ReceptorMensajes r, GestorMensajeria g, CuentasUsuario u, UserAccount ua"
			+ " WHERE u.userAccounts.id = ua.id"
			+ " AND u.usuarios.id = r.userAccount.id"
			+ " AND r.gestorMensajeria.idMensaje = g.idMensaje"
			+ " AND ua.username=:parametro" +
			" AND g.tipo.idTipo = 9";

	String LISTA_MENSAJES_ENVIADOS_USUARIO = "SELECT g FROM GestorMensajeria g, CuentasUsuario u, UserAccount ua, Usuario usu"
			+ " where g.deUsuario.id = u.usuarios.id" +
			" AND u.usuarios.id = usu.id" +
			" AND u.userAccounts.id = ua.id" +
			" AND ua.username=:parametro" +
			" AND g.tipo.idTipo = 9";

	String USUARIO_POR_USERNAME = "select u from UserAccount ua, Usuario u, CuentasUsuario cu where ua.username =:parametro"
			+ " and ua.id = cu.userAccounts.id" + " and cu.usuarios.id = u.id";

	String GRUPO_USUARIOS_SELECIONADO = "select t from GrupoUsuarios t where t.grupoCurso.idGrupo=#{cursoActualBean.seleccionado.idGrupo}";
	
	
	String USUARIOS_POR_ROL_Y_ENTEUNIVERSITARIO="SELECT us FROM UserAccount u JOIN u.roles r,EnteUniversitario e,Usuario us,CuentasUsuario c"
			+ " where r.name=:roles"
			+ " and u.id = c.id"
			+ " and c.id = us.id"
			+ " and us.enteUniversitarios.idEnteUniversitario = e.idEnteUniversitario"								
			+ " and us.enteUniversitarios.idEnteUniversitario =:escuela";

}
