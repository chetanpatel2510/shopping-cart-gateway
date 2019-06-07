/**
 * 
 */
package com.shoppingcart.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.gateway.entities.User;
import com.shoppingcart.gateway.entities.UserModel;
import com.shoppingcart.gateway.service.UserService;

/**
 * @author root
 *
 */
@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/seller-sign-up")
	public void sellerSignup(@RequestBody UserModel userModel) {
		User user = new User();
		user.getRoles().add("Seller");
		user.setUsername(userModel.getUsername());
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		userService.singup(user);
	}
	
	@PostMapping("/customer-sign-up")
	public void customerSignup(@RequestBody UserModel userModel) {
		User user = new User();
		user.getRoles().add("Customer");
		user.setUsername(userModel.getUsername());
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		userService.singup(user);
	}
	
	@GetMapping("/hello") 
	public String hello() {
		return "Hello This is login controller";
	}
	
}
