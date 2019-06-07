/**
 * 
 */
package com.shoppingcart.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author root
 *
 */
@Configuration
@EnableWebMvc
public class CORSGlobalConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping( "/**" )
        .allowedOrigins( "http://localhost:4200" )
        .allowedMethods( "GET", "POST", "DELETE" )
        .allowedHeaders("*")
        .allowCredentials( true )
        .exposedHeaders( "Authorization" )
        .maxAge( 3600 );
	}
}
