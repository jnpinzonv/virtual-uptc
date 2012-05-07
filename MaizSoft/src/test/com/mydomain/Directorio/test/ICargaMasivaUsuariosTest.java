package com.mydomain.Directorio.test;

import org.testng.annotations.Test;
import org.jboss.seam.mock.SeamTest;

public class ICargaMasivaUsuariosTest extends SeamTest {

	@Test
	public void test_cargaMasivaUsuarios() throws Exception {
		new FacesRequest("/cargaMasivaUsuarios.xhtml") {
			@Override
			protected void invokeApplication() {
				//call action methods here
				invokeMethod("#{CargaMasivaUsuarios.cargaMasivaUsuarios}");
			}
		}.run();
	}
}
