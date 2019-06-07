/**
 * 
 */
package com.shoppingcart.gateway.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author root
 *
 */
public class UserPrincipal implements UserDetails {

	/**
	 * serialVersionUID declaration.
	 */
	private static final long serialVersionUID = 254450247597861161L;

	/**
	 * username declaration.
	 */
	private String username;
	
	/**
	 * password declaration.
	 */
	private String password;
	
	/**
	 * accountNonLocked declaration.
	 */
	private boolean accountNonLocked;
	
	/**
	 * accountNonExpired declaration.
	 */
	private boolean accountNonExpired;
	
	/**
	 * enabled declaration.
	 */
	private boolean enabled;
	
	/**
	 * credentialsNonExpired declaration.
	 */
	private boolean credentialsNonExpired;
	
	/**
	 * authorities declaration.
	 */
	private Collection<? extends GrantedAuthority> authorities;

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
	 * Getter method for authorities
	 *
	 * @return the authorities
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * Setter method for authorities
	 *
	 * @param authorities 
	 *			the authorities to set
	 */
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
//		return accountNonExpired;
		return true;
	}

	
	@Override
	public boolean isAccountNonLocked() {
//		return accountNonLocked;
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
//		return credentialsNonExpired;
		return true;
	}

	@Override
	public boolean isEnabled() {
//		return enabled;
		return true;
	}

	/**
	 * Setter method for accountNonLocked
	 *
	 * @param accountNonLocked 
	 *			the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * Setter method for accountNonExpired
	 *
	 * @param accountNonExpired 
	 *			the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * Setter method for enabled
	 *
	 * @param enabled 
	 *			the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Setter method for credentialsNonExpired
	 *
	 * @param credentialsNonExpired 
	 *			the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	

}
