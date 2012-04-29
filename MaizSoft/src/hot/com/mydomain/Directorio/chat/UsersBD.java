/*
 *
 * Web Chat Module
 * Copyright (c) 2010 Osama Mohammad Oransa
 *
 */
package com.mydomain.Directorio.chat;

import java.util.Vector;

/**
 * UsersBD Class that handle all needed communication between chat interface and BO to load all chat users.
 * @author Osama Oransa
 * @version 1.0
 * 2010
 */
public class UsersBD implements IBO {
	public static final String FILE_TYPE = "1";
	public static final String DB_TYPE = "2";
	private IBO businessObject;
	public UsersBD(String type) throws Exception {
		if (type == null || type.equals(FILE_TYPE)) {
			businessObject = new FileBO();
		} else if (type.equals(DB_TYPE)) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

	public Vector<ChatUser> loadUsers() {
		return businessObject.loadUsers();
	}
}
