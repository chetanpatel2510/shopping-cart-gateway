/**
 * 
 */
package com.shoppingcart.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

/**
 * @author root
 *
 */
@ConfigurationProperties("security")
public class SecurityProperties {

	private JwtProperties jwt;
	
	public static class JwtProperties {
		private Resource publicKey;

		/**
		 * Getter method for publicKey
		 *
		 * @return the publicKey
		 */
		public Resource getPublicKey() {
			return publicKey;
		}

		/**
		 * Setter method for publicKey
		 *
		 * @param publicKey 
		 *			the publicKey to set
		 */
		public void setPublicKey(Resource publicKey) {
			this.publicKey = publicKey;
		}
		
	}

	/**
	 * Getter method for jwt
	 *
	 * @return the jwt
	 */
	public JwtProperties getJwt() {
		return jwt;
	}

	/**
	 * Setter method for jwt
	 *
	 * @param jwt 
	 *			the jwt to set
	 */
	public void setJwt(JwtProperties jwt) {
		this.jwt = jwt;
	}
}
