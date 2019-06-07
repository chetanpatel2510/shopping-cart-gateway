/**
 * 
 */
package com.shoppingcart.gateway.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @author root
 *
 */
@Table(value="USERS")
public class User {

	/**
	 * username declaration.
	 */
	@PrimaryKeyColumn(name="USERNAME", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String username;
	
	/**
	 * password declaration.
	 */
	@Column(value = "PASSWORD")
	private String password;
	
	/**
	 * accountNonLocked declaration.
	 */
	@Column(value = "ACCOUNT_NOT_LOCKED")
	private boolean accountNonLocked;
	
	/**
	 * accountNonExpired declaration.
	 */
	@Column(value = "ACCOUNT_NOT_EXPIRED")
	private boolean accountNonExpired;
	
	/**
	 * enabled declaration.
	 */
	@Column(value = "ENABLED")
	private boolean enabled;
	
	/**
	 * credentialsNonExpired declaration.
	 */
	@Column(value = "CREDENTIAL_NOT_EXPIRED")
	private boolean credentialsNonExpired;
	
	/**
	 * roles declaration.
	 */
	@Column(value = "ROLES")
	private Set<String> roles;
	
	/**
	 * Record Created By.
	 */
	@Column(value="CREATED_BY")
	private String createdBy;
	
	/**
	 * Record last updated by.
	 */
	@Column(value = "LAST_UPDATED_BY")
	private String lastUpdatedBy;
	
	/**
	 * Record creation date.
	 */
	@Column(value = "CREATED_ON")
	private Date createdOn;
	
	/**
	 * Record last updated date.
	 */
	@Column(value = "LAST_UPDATED_ON")
	private Date lastUpdatedOn;
	
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
	 * Getter method for roles
	 *
	 * @return the roles
	 */
	public Set<String> getRoles() {
		if (roles == null) {
			roles = new HashSet<>();
		}
		return roles;
	}

	/**
	 * Setter method for roles
	 *
	 * @param roles 
	 *			the roles to set
	 */
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	/**
	 * Getter method for accountNonLocked
	 *
	 * @return the accountNonLocked
	 */
	public boolean isAccountNonLocked() {
		return accountNonLocked;
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
	 * Getter method for accountNonExpired
	 *
	 * @return the accountNonExpired
	 */
	public boolean isAccountNonExpired() {
		return accountNonExpired;
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
	 * Getter method for enabled
	 *
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
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
	 * Getter method for credentialsNonExpired
	 *
	 * @return the credentialsNonExpired
	 */
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
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

	/**
	 * Getter method for createdBy
	 *
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Setter method for createdBy
	 *
	 * @param createdBy 
	 *			the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Getter method for lastUpdatedBy
	 *
	 * @return the lastUpdatedBy
	 */
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * Setter method for lastUpdatedBy
	 *
	 * @param lastUpdatedBy 
	 *			the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 * Getter method for createdOn
	 *
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * Setter method for createdOn
	 *
	 * @param createdOn 
	 *			the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Getter method for lastUpdatedOn
	 *
	 * @return the lastUpdatedOn
	 */
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	/**
	 * Setter method for lastUpdatedOn
	 *
	 * @param lastUpdatedOn 
	 *			the lastUpdatedOn to set
	 */
	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
}
