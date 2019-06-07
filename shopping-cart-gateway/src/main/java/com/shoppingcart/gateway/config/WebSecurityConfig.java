/**
 * 
 */
package com.shoppingcart.gateway.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.shoppingcart.gateway.filters.JwtAuthenticationFilter;
import com.shoppingcart.gateway.filters.JwtAuthorizationFilter;

/**
 * @author root
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	/**
	 * Bean for password encoder to encrypt password.
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().csrf().disable().authorizeRequests()
        .antMatchers("/seller-sign-up").permitAll()
        .antMatchers("/customer-sign-up").permitAll()
        .antMatchers("/login").permitAll()
        .antMatchers("**/health/**").permitAll()
        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtTokenProvider))
        .addFilter(new JwtAuthorizationFilter(authenticationManager()));
        
        http.cors();
    }
	
	 @Bean
     public CorsConfigurationSource corsConfigurationSource() {
         final CorsConfiguration configuration = new CorsConfiguration();
         configuration.setAllowedOrigins(Arrays.asList("*"));
         configuration.setAllowedMethods(Arrays.asList("*"));
         configuration.setAllowCredentials(true);
         configuration.setAllowedHeaders(Arrays.asList("*"));
         configuration.setExposedHeaders(Arrays.asList("Authorization"));
         final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
         source.registerCorsConfiguration("/**", configuration);
         return source;
     }
}
