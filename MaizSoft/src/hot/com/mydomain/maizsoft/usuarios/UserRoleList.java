package com.mydomain.maizsoft.usuarios;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("userRoleList")
public class UserRoleList extends EntityQuery<UserRole> {

	private static final String EJBQL = "select userRole from UserRole userRole";

	private static final String[] RESTRICTIONS = {"lower(userRole.name) like lower(concat(#{userRoleList.userRole.name},'%'))",};

	private UserRole userRole = new UserRole();

	public UserRoleList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
	}

	public UserRole getUserRole() {
		return userRole;
	}
}
