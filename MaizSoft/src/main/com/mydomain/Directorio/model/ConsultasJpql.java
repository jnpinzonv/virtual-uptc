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

	/**
	 * 
	 */
	String LISTA_MENSAJES_USUARIO = "SELECT g FROM ReceptorMensajes r, GestorMensajeria g, CuentasUsuario u, UserAccount ua"
			+ " WHERE u.userAccounts.id = ua.id"
			+ " AND u.usuarios.id = r.userAccount.id"
			+ " AND r.gestorMensajeria.idMensaje = g.idMensaje"
			+ " AND ua.username=:parametro" + " AND g.tipo.idTipo = 9";

	/**
	 * 
	 */
	String LISTA_MENSAJES_ENVIADOS_USUARIO = "SELECT g FROM GestorMensajeria g, CuentasUsuario u, UserAccount ua, Usuario usu"
			+ " where g.deUsuario.id = u.usuarios.id"
			+ " AND u.usuarios.id = usu.id"
			+ " AND u.userAccounts.id = ua.id"
			+ " AND ua.username=:parametro" + " AND g.tipo.idTipo = 9";

	/**
	 * 
	 */
	String USUARIO_POR_USERNAME = "select u from UserAccount ua, Usuario u, CuentasUsuario cu where ua.username =:parametro"
			+ " and ua.id = cu.userAccounts.id" + " and cu.usuarios.id = u.id";

	/**
	 * 
	 */
	String GRUPO_USUARIOS_SELECIONADO = "select t from GrupoUsuarios t where t.grupoCurso.idGrupo=#{cursoActualBean.select()}";

	/**
	 * 
	 */
	String USUARIOS_POR_ROL_Y_ENTEUNIVERSITARIO = "SELECT us FROM UserAccount u JOIN u.roles r,EnteUniversitario e,Usuario us,CuentasUsuario c"
			+ " where u.id = c.id"			
			+ " and c.id = us.id"
			+ " and us.enteUniversitarios.idEnteUniversitario = e.idEnteUniversitario"
			+ " and us.enteUniversitarios.idEnteUniversitario =:escuela";

	/**
	 * 
	 */
	String GRUPOS_CURSOS_POR_USUARIO = "select gr from GrupoUsuarios g , GrupoCurso gr where g.userGrupoCurso.id=:parametro"
			+ " and g.grupoCurso.idGrupo=gr.idGrupo";

	/**
	 * 
	 */
	String CONFIGURACIONES_SISTEMA_POR_PROPIEDAD = "select c from ConfiguracionesSistema c where c.nombrePropiedad=:parametro";

	/**
	 * 
	 */
	String USUARIO_POR_MAIL = "select u from Usuario u where u.correoElectronico=:parametro";

	/**
	 * 
	 */
	String USERACCOUNT_POR_USERNAME = "select u from UserAccount u where u.username=:parametro";

	String ACTIVIADES_POR_DIVISION = "select a from Actividad a, NumeroDivisiones m"
			+ " where m.numeroDivision = #{seccionSeleccionadaBean.seccionSeleccionada}"
			+ " and m.grupoCurso.idGrupo=#{cursoActualBean.select()}"
			+ " and m.actividad.idActividad= a.idActividad"
			+ " and a.tipo.idTipo =:parametro";

	String GRUPO_SELECCIONDADO = "select g from GrupoCurso g where g.idGrupo=#{cursoActualBean.select()}";

	String PORCENTAJE_TOTAL_ACTIVIDAD = "SELECT a.porcentaje*c.nota FROM nota_actividad c, actividad a WHERE c.id_grupo_curso = 13 and a.id_actividad=c.`id_actividad`";
	
	String NOTAS_ACTIVIDAD = "select n from NotaActividad n, CuentasUsuario c, UserAccount u JOIN u.roles r"
			+ " where n.actividad.idActividad=:parametro" +
			" and n.usuario.id = c.usuarios.id" +
			" and c.userAccounts.id = u.id" +			
			" and r.name='estudiante'";

	String NOTA_ESTUDIANTE_ACTIVIDAD = "SELECT n FROM  NotaActividad n,UserAccount u JOIN u.roles r"
			+ " where n.usuario.id=:parametro"
			+ " and  r.name=estudiante"
			+ " and n.grupoCurso.grupoCurso.idGrupo=:parametro2";
	
	String ACTIVIDADES_NO_VENCIDAS_ESTUDIANTE = "select a FROM UserAccount u JOIN u.roles r, Actividad a" +
			" where r.name=estudiante" +			
			" and a.fechaFinalizacion >:parametro";

	
	String MENSAJES_NO_LEIDOS ="select men from GestorMensajeria men, ReceptorMensajes re, CuentasUsuario u, UserAccount ua, Usuario usu" +
								" where re.gestorMensajeria=men.idMensaje" +
								" and re.leido=0" 
								+ " AND re.userAccount.id = u.usuarios.id"
								+ " AND u.usuarios.id =:parametro";
								
	
	String NOTAS_ESTUDIANTE = "SELECT c.nombre_asignatura, sum((n.nota * a.porcentaje)/100)" +
				" FROM cuentas_usuario cu, user_account ua, user_account_role uar, nota_actividad n, actividad a,grupo_curso gc, curso c" +
				" where n.id_usuario = cu.id_usuarios and ua.id_user_account = cu.id_user_account" +
				" and uar.account_id=ua.id_user_account" +
				" and uar.member_of_role= 3" +
				" and gc.id_grupo= n.id_grupo_usuarios" +
				" and gc.id_curso_grupo = c.codigo_curso" +
				" and n.id_actividad = a.id_actividad" +
				" and n.id_usuario=:parametro" +
				" group by c.nombre_asignatura";

	String LISTA_TIPOS_ACTIVIDADES ="select t from Tipo t where t.tipo=10";
	
	String ACTIVIDADES_POR_DIVISION = "select a from Actividad a, NumeroDivisiones m"
			+ " where m.numeroDivision = #{seccionSeleccionadaBean.seccionSeleccionada}"
			+ " and m.grupoCurso.idGrupo=#{cursoActualBean.select()}"
			+ " and m.actividad.idActividad= a.idActividad";
	
	
	String AGREGAR_ACTIVIDAD_PARA_NOTA="select n from NotaActividad n where n.usuario.id=:parametro" +
						" and n.actividad.idActividad=:parametro2";
	
	

	
	String LISTA_FOROS_POR_PARTICIPACION="select m from ReceptorMensajes m, GestorMensajeria gm" 
										+" where m.gestorMensajeria.idMensaje=gm.idMensaje" 
										+" and gm.idMensaje =:parametro" 
										+" and m.leido=true";
	
	String ACTIVIDAD_NOTA_ACTIVIDAD= "select n.gestorMensajeria.idMensaje from NotaActividad n " 
								   +" where n.actividad.idActividad=:parametro";
	
	String ACTIVIDAD_NOTA_ACTIVIDAD_ESTU= "select n from NotaActividad n " 
			   +" where n.actividad.idActividad=:parametro" 
			   +" and n.usuario.id=:parametro2";
	
	String RECEPTOR_FORO="select m from ReceptorMensajes m"
			            +" where m.gestorMensajeria.idMensaje=:parametro" 
			            +" and m.userAccount.id=:parametro2";
			
	
}
