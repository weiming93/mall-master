package com.emond.mall.common.security.config;



import com.emond.mall.common.security.core.AuthenticationManager;
import com.emond.mall.common.security.core.MallSecurityContextRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@Slf4j
public class WebSecurityConfig {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MallSecurityContextRepository securityContextRepository;


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		return http
				.exceptionHandling()
				.authenticationEntryPoint((swe, e) -> {
					return Mono.fromRunnable(() -> {
						swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
					});
				}).accessDeniedHandler((swe, e) -> {
					return Mono.fromRunnable(() -> {
						swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
					});
				}).and()
				.formLogin().disable()
				.httpBasic(withDefaults())
				.authenticationManager(authenticationManager)
				.securityContextRepository(securityContextRepository)
				.authorizeExchange()
				.pathMatchers("/**").permitAll()
				.anyExchange().authenticated()
				.and().build();
	}


}
