/**
 * 
 */
package com.shoppingcart.gateway.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.shoppingcart.gateway.entities.UserPrincipal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * @author root
 *
 */
@Component
public class JwtTokenProvider {

	@Value("${app.jwtSecret}")
	private String jwtSecret;
	
	@Value("${app.jwtExpirationInMiiliSec}")
	private int jwtExpirationInMilliSec;
	
	public String generateToken(Authentication authentication) {
		UserPrincipal userDetails = (UserPrincipal)authentication.getPrincipal();
		Date now = new Date();
		
		Date expiryDate = new Date(now.getTime() + jwtExpirationInMilliSec);
		
		return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
	}
	
	public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
	
	public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            ex.printStackTrace();
        } catch (MalformedJwtException ex) {
        	 ex.printStackTrace();
        } catch (ExpiredJwtException ex) {
        	 ex.printStackTrace();
        } catch (UnsupportedJwtException ex) {
        	 ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
        	 ex.printStackTrace();
        }
        return false;
    }

}
