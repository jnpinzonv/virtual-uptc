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
	


	public boolean authenticate() {
		try {
			try {
			log.info(
							credentials.getUsername()+" gh "+ credentials.getPassword(),
							credentials.getUsername());
			
			MessageDigest messageDigest;
			
			messageDigest = MessageDigest.getInstance("SHA");
		
		messageDigest.update(credentials.getUsername().getBytes());
			
			
			String tem=messageDigest.digest()+"" ;
			
			
			log.info(tem + 
					'n',
					credentials.getUsername());
			UserAccount user = (UserAccount) entityManager.createQuery(

			"from UserAccount where username = :username and password_hash = :password")
			

			.setParameter("username", credentials.getUsername())

			.setParameter("password",tem )

			.getSingleResult();
		
			
			
			
				
			

			if (user.getRoles() != null) {

				for (UserRole mr : user.getRoles())

					identity.addRole(mr.getName());

			}
			
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			

			return true;

		}

		catch (NoResultException ex) {

			return true;

		}
	}

}
