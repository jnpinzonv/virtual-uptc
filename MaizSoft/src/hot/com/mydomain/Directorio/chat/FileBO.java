/*
 *
 * Web Chat Module
 * Copyright (c) 2010 Osama Mohammad Oransa
 *
 */
package com.mydomain.Directorio.chat;

import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

/**
 * FileBO Class is a business object that load from XML file the chat users , xml file is users.xml
 * @author Osama Oransa
 * @version 1.0
 * 2010
 */
public class FileBO implements IBO {

	XMLParser parser1;
	Properties config;
	private static final String SERVER_DATA_FILE_NAME = "users.xml";

	public FileBO() throws Exception {
		loadXMLFile();
	}

	private void loadXMLFile() throws Exception {
		parser1 = new XMLParser(SERVER_DATA_FILE_NAME, false);
	}
	public Vector<ChatUser> loadUsers() {
		//System.out.println("Loading All Users");
		Vector<ChatUser> result = new Vector<ChatUser>(0);
		//load groups
		Vector tempVector = parser1.getProperty("user");
		//System.out.println("All users size=" + tempVector.size());
		for (int i = 0; i < tempVector.size(); i++) {
			ChatUser chatUser = new ChatUser();
			Hashtable hashTemp = (Hashtable) tempVector.get(i);
			chatUser.setId(Integer.parseInt((String) hashTemp.get("id")));
			chatUser.setName((String) hashTemp.get("name"));
			chatUser.setLogin((String) hashTemp.get("login"));
			chatUser.setEmail((String) hashTemp.get("email"));
			chatUser.setPassword((String) hashTemp.get("password"));
			chatUser.setType(Integer.parseInt((String) hashTemp.get("type")));
			chatUser.setStatus(ChatUser.OFFLINE);
			result.add(chatUser);
		}
		System.gc();
		//System.out.println("Finish Loading All Users");
		return result;
	}
}
