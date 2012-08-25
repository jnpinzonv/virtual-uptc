/**
 * 
 */
package com.mydomain.maizsoft.cargaarchivos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.faces.FacesMessages;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.mydomain.Directorio.model.ConfiguracionesSistema;
import com.mydomain.Directorio.model.Curso;
import com.mydomain.Directorio.model.HistorialNotas;
import com.mydomain.Directorio.model.Usuario;
import com.mydomain.Directorio.model.ConsultasJpql;

/**
 * Descripcion: Esta Clase se encarga de ... Modulo de Desarrollo :CU- ...
 * 
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
 * @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com Grupo de
 *         Investigacion Ingenieria Software (GIS) Semillero de Investigacion
 *         Moviles Sabatt (SIMS) Universidad Pedagogica y Tecnologica de
 *         Colombia
 * @version 25/08/2012
 */
@Stateless
@Name("archivoXMLNotasBean")
public class ArchivoXMLNotasBean extends ArchivoXML implements IArchivoXMLNotas {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mydomain.maizsoft.cargaarchivos.IArchivoXMLNotas#write()
	 */
	@PersistenceContext
	EntityManager entityManager;

	public void write() {
		Document document = new Document(crearEstructuraXML());
		try {
			XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
			out.output(document, getArchivo());
			getArchivo().flush();
			close();
		} catch (Exception e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Se produjo un error técnico :(");
		}
	}

	private Element crearXMLUsuario(Usuario usuario) {
		Element element = new Element(ConstantesArchivosXML.PADRE);
		element.addContent(new Element(ConstantesArchivosXML.PADREAPELLIDO)
				.setText(usuario.getApellidos()));
		element.addContent(new Element(ConstantesArchivosXML.PADREPRIMERNOMBRE)
				.setText(usuario.getPrimerNombre()));
		element.addContent(new Element(ConstantesArchivosXML.PADRESEGUNDONOMBRE)
				.setText(usuario.getSegundoNombre()));
		element.addContent(new Element(
				ConstantesArchivosXML.PADRETIPOIDENTIFICACION).setText(usuario
				.getTipo().getNombre()));
		element.addContent(new Element(ConstantesArchivosXML.PADRECODIGO)
				.setText(usuario.getCodigoUsuarios()));
		element.addContent(new Element(ConstantesArchivosXML.PADRECORREO)
				.setText(usuario.getCorreoElectronico()));
		element.addContent(new Element(ConstantesArchivosXML.PADREFACULTAD)
				.setText(usuario.getEnteUniversitarios()
						.getNombreEnteUniversitario()));
		element.addContent(new Element(
				ConstantesArchivosXML.PADREIDENTIFICACION).setText(usuario
				.getDocumentoIdentidad() + ""));

		return element;
	}

	private Element crearXMLCurso(Curso curso, double nota) {

		Element element = new Element(ConstantesArchivosXML.HIJO);
		element.addContent(new Element(ConstantesArchivosXML.HIJOCODIGO)
				.setText(curso.getCodigo().toString()));
		element.addContent(new Element(ConstantesArchivosXML.HIJONOMBRE)
				.setText(curso.getNombreAsignatura()));
		element.addContent(new Element(ConstantesArchivosXML.HIJONOTA)
				.setText(nota + ""));
		element.addContent(new Element(ConstantesArchivosXML.HIJOESCUELA)
				.setText(curso.getEnteUniversitario()
						.getNombreEnteUniversitario()));

		return element;
	}

	private Element crearEstructuraXML() {

		Element historialNotas = new Element(ConstantesArchivosXML.SUPERPADRE);
		Query q = entityManager.createQuery(ConsultasJpql.HISTORIAL_NOTAS_ESTUDIANTES);
		List<Usuario> usuarios = (List<Usuario>)q.getResultList();
		for (Usuario usuario : usuarios) {
			Element usuarioXML = crearXMLUsuario(usuario);
			Query q2 = entityManager.createQuery(ConsultasJpql.HISTORIAL_NOTAS);
			q2.setParameter("parametro", usuario.getId());
			List<HistorialNotas> notasCurso = (List<HistorialNotas>)q2.getResultList();
			for (HistorialNotas curso : notasCurso) {
				Element cursoXML = crearXMLCurso(curso.getGrupoCurso()
						.getCursoGrupo(), curso.getNota());
				usuarioXML.addContent(cursoXML);
			}
			historialNotas.addContent(usuarioXML);
		}
		return historialNotas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mydomain.maizsoft.cargaarchivos.ArchivoXML#read()
	 */
	@Override
	public void read() {

		@SuppressWarnings("deprecation")
		SAXBuilder leer = new SAXBuilder(false);
		try {
			Document document = leer.build(getPath() + getNombre());

			Element raiz = document.getRootElement();
			raiz.getAttributeValue(ConstantesArchivosXML.SUPERPADRE);

			Element raiz2 = document.getRootElement();
			raiz2.getAttributeValue(ConstantesArchivosXML.PADRE);
			@SuppressWarnings("unchecked")
			List<Usuario> usuarios = (List<Usuario>) raiz
					.getChild(ConstantesArchivosXML.HIJO);

			for (Usuario usuario : usuarios) {

			}
		} catch (Exception e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Se produjo un error técnico :(");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mydomain.maizsoft.cargaarchivos.IArchivoXMLNotas#guardarArchivoXml()
	 */
	@Override
	public void guardarArchivoXml() {

		ConfiguracionesSistema path = entityManager.find(
				ConfiguracionesSistema.class, 1l);
		ConfiguracionesSistema pathbackup = entityManager.find(
				ConfiguracionesSistema.class, 20l);
		String pathFinal = path.getDetallesPropiedad() + "//"
				+ pathbackup.getDetallesPropiedad();
		Calendar calendar = Calendar.getInstance();
		setNombre(calendar.getTime() + "_backupNotas");
		setPath(pathFinal);

		try {
			open();
			write();

		} catch (Exception e) {
			FacesMessages mensaje = (FacesMessages) Component
					.getInstance(FacesMessages.class);
			mensaje.add("Se produjo un error técnico :(");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mydomain.maizsoft.cargaarchivos.IArchivoXMLNotas#leerArchivoXMl()
	 */
	@Override
	public void leerArchivoXMl() {

	}
}
