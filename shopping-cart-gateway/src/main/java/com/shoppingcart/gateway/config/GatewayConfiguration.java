/**
 * 
 */
package com.shoppingcart.gateway.config;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author root
 *
 */
@Configuration
@EnableResourceServer
@EnableConfigurationProperties(SecurityProperties.class)
public class GatewayConfiguration extends ResourceServerConfigurerAdapter {
	
	private SecurityProperties securityProperties;
	
	private TokenStore tokenStore;
	
	public GatewayConfiguration(final SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
	
	@Override
	public void configure(final ResourceServerSecurityConfigurer resources) {
		resources.tokenStore(tokenStore());
	}
	
	@Bean
	public DefaultTokenServices tokenServices(final TokenStore tokenStore) {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore);
		return defaultTokenServices;
	}
	
	@Bean
	public TokenStore tokenStore() {
		if (tokenStore == null) {
			tokenStore = new JwtTokenStore(jwtAccessTokenConverter());
		}
		return tokenStore;
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setVerifierKey(getPublicKeyAsString());
		return jwtAccessTokenConverter;
	}
	
	private String getPublicKeyAsString() {
		String publicKey = null;
		try {
			publicKey = IOUtils.toString(securityProperties.getJwt().getPublicKey().getInputStream());
		} catch (IOException e) {
			throw new RuntimeException("Error in loading public key to validate JWT tokens");
		}
		return publicKey;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/shopping-cart-security/oauth/**").permitAll().antMatchers("/**").authenticated();
	}
	
	
}
