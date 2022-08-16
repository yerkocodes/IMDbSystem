package com.imdbsystem.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig {
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests()
		.antMatchers("/admin/**").hasAuthority("ADMIN")
		.antMatchers("/user/**").hasAuthority("USER")
		.antMatchers("/login")
		.permitAll()
		.anyRequest()
		.authenticated();
		
		http
		.formLogin()
		.loginPage("/login")
		.successHandler(authenticationSuccessHandler)
		.failureUrl("/login?error=true")
		.usernameParameter("email")
		.passwordParameter("password");
		
		http
		.exceptionHandling()
		.accessDeniedPage("/error404");
		
		http
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login")
		.deleteCookies("JSESSIONID")
		.invalidateHttpSession(true);
		
		http
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		.invalidSessionUrl("/login");
		
		return http.build();
	}
	
	@Bean
    @Order(0)
    SecurityFilterChain resources(HttpSecurity http) throws Exception {
        http
            .requestMatchers((matchers) -> matchers.antMatchers("/images/**", "/js/**", "/webjars/**","/css/**"))
            .authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll())
            .requestCache().disable()
            .securityContext().disable()
            .sessionManagement().disable();
        return http.build();
    }
	
//	@Bean
//	WebSecurityCustomizer webSecurityCustomizer() {
//		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**", "/css/**");
//	}
	
	// encryptacion de la password mediante BCrypt
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
