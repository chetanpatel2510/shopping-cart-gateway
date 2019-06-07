/**
 * 
 */
package com.shoppingcart.gateway.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.shoppingcart.gateway.entities.User;

/**
 * @author root
 *
 */
public interface UserService extends UserDetailsService {

	void singup(User user);
}
