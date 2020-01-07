package com.blueocean.mall.common.config;


import com.blueocean.mall.common.core.AuthenticationManager;
import com.blueocean.mall.common.core.MallSecurityContextRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import javax.annotation.PostConstruct;

/**
 *
 * @author ard333
 */
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@Slf4j
public class WebSecurityConfig {

	@Value("${spring.config.securityName}")
	private String configName;

	@PostConstruct
	public void init(){
		log.info("******加载security配置:{}******",configName);
	}

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MallSecurityContextRepository securityContextRepository;


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
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
				.httpBasic().disable()
				.authenticationManager(authenticationManager)
				.securityContextRepository(securityContextRepository)
				.authorizeExchange()
				.pathMatchers(HttpMethod.OPTIONS).permitAll()
				.pathMatchers("/api/auth/**").permitAll()
				.pathMatchers("/**").hasRole("admin")
				.anyExchange().authenticated()
				.and().build();
	}


}
