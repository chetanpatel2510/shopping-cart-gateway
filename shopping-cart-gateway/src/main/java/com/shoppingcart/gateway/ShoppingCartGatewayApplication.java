package com.shoppingcart.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableZuulProxy
@SpringBootApplication
@CrossOrigin
@EnableRedisHttpSession
public class ShoppingCartGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartGatewayApplication.class, args);
	}

}
