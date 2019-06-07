/**
 * 
 */
package com.shoppingcart.gateway.entities;

/**
 * @author root
 *
 */
public class UserModel {

	private String username;
	
	private String password;

	/**
	 * Getter method for password
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method for password
	 *
	 * @param password 
	 *			the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter method for username
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter method for username
	 *
	 * @param username 
	 *			the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
