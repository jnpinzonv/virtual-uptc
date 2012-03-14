package com.mydomain.Directorio.action;

import javax.ejb.Local;

@Local
public interface Authenticator {

	boolean authenticate();

}
