/*
 *
 * Web Chat Module
 * Copyright (c) 2010 Osama Mohammad Oransa
 *
 */
package com.mydomain.Directorio.chat;

import java.io.Serializable;

/**
 * ChatUser Class that carry the needed user details for the chat
 * @author Osama Oransa
 * @version 1.0
 * 2010
 */
public class ChatUser implements Serializable {

	public static int OFFLINE = 0;
	public static int ONLINE = 1;
	public static int USER = 0;
	public static int ADMIN = 1;
	public static int SUPPORT = 2;
	private int id = 0;
	private String name = "";
	private String email = "";
	private String login = "";
	private String password = "";
	private int type = 0;
	private int status = 0;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
