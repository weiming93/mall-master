package com.emond.mall.common.security.core;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "mall")
public class JWTUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String jwtSecret;
	
	private String jwtExpirationInMs;
	
	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(Base64.getEncoder().encodeToString(jwtSecret.getBytes())).parseClaimsJws(token).getBody();
	}
	
	public Long getUserIdFromToken(String token) {
		return Long.parseLong(getAllClaimsFromToken(token).getSubject());
	}
	
	public Date getExpirationDateFromToken(String token) {
		return getAllClaimsFromToken(token).getExpiration();
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public String generateToken(UserPrincipal userPrincipal) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("role", userPrincipal.getAuthorities());
		return doGenerateToken(claims, userPrincipal.getId());
	}

	private String doGenerateToken(Map<String, Object> claims, Long id) {
		final Date now = new Date();
		final Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(Long.toString(id))
				.setIssuedAt(now)
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(jwtSecret.getBytes()))
				.compact();
	}
	
	public Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}

}
