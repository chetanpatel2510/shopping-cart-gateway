/**
 * 
 */
package com.shoppingcart.gateway.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.shoppingcart.gateway.entities.User;
import com.shoppingcart.gateway.entities.UserPrincipal;
import com.shoppingcart.gateway.repository.UserRepository;
import com.shoppingcart.gateway.service.UserService;

/**
 * @author root
 *
 */
@Component
public class UserDetailsServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		UserPrincipal userDetails = null;
		if (user != null) {
			userDetails = new UserPrincipal();
			userDetails.setUsername(user.getUsername());
			userDetails.setAccountNonExpired(user.isAccountNonExpired());
			userDetails.setCredentialsNonExpired(user.isCredentialsNonExpired());
			userDetails.setEnabled(user.isEnabled());
			userDetails.setAccountNonLocked(user.isAccountNonLocked());
			userDetails.setPassword(user.getPassword());
			userDetails.setAuthorities(new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Username " + username + " not found.");
		}
		return userDetails;
	}

	@Override
	public void singup(User user) {
		userRepository.save(user);
	}

}
