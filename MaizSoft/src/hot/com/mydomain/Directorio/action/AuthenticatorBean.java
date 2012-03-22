package com.mydomain.Directorio.action;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.eclipse.jdt.internal.core.util.WeakHashSet.HashableWeakReference;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;
import org.jboss.seam.security.management.action.UserAction;

import com.mydomain.Directorio.model.UserAccount;
import com.mydomain.Directorio.model.UserRole;

@Stateless
@Name("authenticator")
@Scope(ScopeType.EVENT)
public class AuthenticatorBean implements Authenticator {
	@Logger
	private Log log;

	@In
	Identity identity;
	@In
	Credentials credentials;

	@PersistenceContext
	EntityManager entityManager;

	@In(create = true)
	UserAction userAction;

	public boolean authenticate() {

		//MessageDigest messageDigest;

		//messageDigest = MessageDigest.getInstance("SHA");

		//messageDigest.update(credentials.getUsername().getBytes());

		//String tem=messageDigest.digest()+"" ;

		return true;
	}

}
