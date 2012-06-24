package com.mydomain.Directorio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.security.permission.PermissionAction;
import org.jboss.seam.annotations.security.permission.PermissionDiscriminator;
import org.jboss.seam.annotations.security.permission.PermissionRole;
import org.jboss.seam.annotations.security.permission.PermissionTarget;
import org.jboss.seam.annotations.security.permission.PermissionUser;

/**
* Descripcion: Esta Clase se encarga de almacenar información relacionada con
* los permiso de usuario.
* Modulo de Desarrollo :CU- ...
 * @author Edwin Jose Hernandez Niño edwher.123@hotmail.com
* @author Josue Nicolas Pinzon Villamil jnpinzonv@hotmail.com
* Grupo de Investigacion Ingenieria Software (GIS)
* Semillero de Investigacion Moviles Sabatt (SIMS)
* Universidad Pedagogica y Tecnologica de Colombia
* @version 23/06/2012 
*/
@Entity(name="UserPermission")
@Table(name="user_permission")
@Name("userPermission")
public class UserPermission implements Serializable
{
   private static final long serialVersionUID = -5628863031792429938L;
   
   /**
    * Variable encargada de almacenar el identificador
    * de los permisos de usuario.
    */
   private Long id;
  /**
    * Variable encargada de almacenar el nombre del
    * beneficiario de los permisos de usuario.
    */
   private String recipient;
  /**
    * Variable que guarda el objetivo de
    * los permisos.
    */
   private String target;
  /**
    * Variable que almacena el nombre de la
    * acción de los permisos de usuario.
    */
   private String action;
 /**
    * Variable que almacena el nombre del discriminador
    * de los permisos.
    */
   private String discriminator;
   
   /**
    * Se obtiene el valor de id
    * @return El valor de id
    */
   @Id
   @GeneratedValue
   @Column(name = "id_user_permission", unique = false, nullable = true, insertable = true, updatable = true)
   public Long getId() {
   	return id;
   }

   /**
    * Asigna el valor de id
    * @param id El valor por establecer para id
    */
   public void setId(Long id) {
   	this.id = id;
   }
   
    /**
    * Se obtiene el valor de recipient
    * @return El valor de recipient
    */
   @PermissionUser 
   @PermissionRole
   @Column(name = "recipient", unique = false, nullable = true, insertable = true, updatable = true)
   public String getRecipient() {
   	return recipient;
   }

   /**
    * Asigna el valor de recipient
    * @param recipient El valor por establecer para recipient
    */
   public void setRecipient(String recipient) {
   	this.recipient = recipient;
   }
   
    /**
    * Se obtiene el valor de target
    * @return El valor de target
    */
   @PermissionTarget
   @Column(name = "target", unique = false, nullable = true, insertable = true, updatable = true)
   public String getTarget() {
   	return target;
   }

   /**
    * Asigna el valor de target
    * @param target El valor por establecer para target
    */
   public void setTarget(String target) {
   	this.target = target;
   }
   
   /**
    * Se obtiene el valor de action
    * @return El valor de action
    */
   @PermissionAction
   @Column(name = "action", unique = false, nullable = true, insertable = true, updatable = true)
   public String getAction() {
   	return action;
   }

   /**
    * Asigna el valor de action
    * @param action El valor por establecer para action
    */
   public void setAction(String action) {
   	this.action = action;
   }
  /**
   * Se obtiene el valor de discriminator
   * @return El valor de discriminator
   */
   @PermissionDiscriminator
   @Column(name = "discriminator", unique = false, nullable = true, insertable = true, updatable = true)
   public String getDiscriminator() {
	return discriminator;
}

/**
* Asigna el valor de discriminator
* @param discriminator El valor por establecer para discriminator
*/
public void setDiscriminator(String discriminator) {
	this.discriminator = discriminator;
}

}
