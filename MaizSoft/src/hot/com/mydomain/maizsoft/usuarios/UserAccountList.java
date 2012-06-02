package com.mydomain.maizsoft.usuarios;

import com.mydomain.Directorio.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("userAccountList")
public class UserAccountList extends EntityQuery<UserAccount> {

	private static final String EJBQL = "select userAccount from UserAccount userAccount";

	private static final String[] RESTRICTIONS = {
			"lower(userAccount.passwordHash) like lower(concat(#{userAccountList.userAccount.passwordHash},'%'))",
			"lower(userAccount.username) like lower(concat(#{userAccountList.userAccount.username},'%'))",};

	private UserAccount userAccount = new UserAccount();

	public UserAccountList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}
}
