package com.emond.mall.common.security.core;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {

	@Autowired
	private JWTUtil jwtUtil;

	@Override
	@SuppressWarnings("unchecked")
	public Mono<Authentication> authenticate(Authentication authentication) {
		String authToken = authentication.getCredentials().toString();
		
		Long userId;
		try {
			userId = jwtUtil.getUserIdFromToken(authToken);
		} catch (Exception e) {
			userId = null;
		}
		if (userId != null && jwtUtil.validateToken(authToken)) {
			Claims claims = jwtUtil.getAllClaimsFromToken(authToken);
			List<GrantedAuthority> grantedAuthorities = claims.get("role", List.class);

			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
					userId, null, grantedAuthorities
			);
			SecurityContextHolder.getContext().setAuthentication(auth);
			return Mono.just(auth);
		} else {
			return Mono.empty();
		}
	}
}
