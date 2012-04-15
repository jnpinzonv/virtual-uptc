/*
 *
 * Web Chat Module
 * Copyright (c) 2010 Osama Mohammad Oransa
 *
 */
package com.mydomain.Directorio.chat;

import java.util.Vector;

/**
 * IBO interface the needed method to implement by the Business objects (eg. Data Base BO or File BO)
 * @author Osama Oransa
 * @version 1.0
 * 2010
 */
public interface IBO {
    public Vector<ChatUser> loadUsers();
}
