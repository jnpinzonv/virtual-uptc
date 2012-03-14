package com.mydomain.Directorio.action;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("userPermissionList")
public class UserPermissionList extends EntityQuery<UserPermission> {

	private static final String EJBQL = "select userPermission from UserPermission userPermission";

	private static final String[] RESTRICTIONS = {
			"lower(userPermission.action) like lower(concat(#{userPermissionList.userPermission.action},'%'))",
			"lower(userPermission.discriminator) like lower(concat(#{userPermissionList.userPermission.discriminator},'%'))",
			"lower(userPermission.recipient) like lower(concat(#{userPermissionList.userPermission.recipient},'%'))",
			"lower(userPermission.target) like lower(concat(#{userPermissionList.userPermission.target},'%'))",};

	private UserPermission userPermission = new UserPermission();

	public UserPermissionList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public UserPermission getUserPermission() {
		return userPermission;
	}
}
