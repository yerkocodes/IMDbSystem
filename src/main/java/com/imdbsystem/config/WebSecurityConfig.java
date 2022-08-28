package com.imdbsystem.config;

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
		
		http // Configuracion de las rutas y autorizaciones -----------------------------------------------------------------------------------------------
		.authorizeHttpRequests()                                        // Autorizar todos los request que van llegando
		.antMatchers("/admin/**").hasAuthority("ADMIN")                 // Para la ruta /admin/** podran entrar solo los que tengan autoridad ADMIN
		.antMatchers("/user/**").hasAuthority("USER")                   // Para la ruta /user/** podran entrar solo los que tengan autoridad USER
		.antMatchers("/login", "/registration", "/register").permitAll()      // Estas rutas estaran permitidas sin autoridades
		.anyRequest().authenticated();                                  // Cualquier request que llegue sera autenticado
		
		http // Configuracion para la pagina del login ----------------------------------------------------------------------------------------------------
		.formLogin().loginPage("/login")                                // Establecemos la ruta especifica para el login
		.successHandler(authenticationSuccessHandler)                   // En el momento que se valide el usuario, se tenga el inicio mediante la clase customAuthenticationSu...
		.failureUrl("/login?error=true")                                // Establecemos pagina de error del login
		.usernameParameter("email")                                     // Cual sera el username que vamos a ingresar - nombre del parametro en el input
		.passwordParameter("password");                                  // Cual sera el password que vamos a ingresar - nombre del parametro en el input
		
		http // Configuracion de excepciones de error ------------------------------------------------------------------------------------------------------
		.exceptionHandling()                                            // Si la persona accede a un recurso que no tiene permiso
		.accessDeniedPage("/error404");                                 // Definimos una ruta
		
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
	
	@Bean // >>> Definiendo un Bean de recursos para ser autenticadas con la seguridad
    @Order(0) // >>> Nivel de importancia al momento de cargar el Bean
    SecurityFilterChain resources(HttpSecurity http) throws Exception {
        http
            .requestMatchers((matchers) -> matchers.antMatchers("/images/**", "/js/**", "/webjars/**","/css/**"))
            .authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll())
            .requestCache().disable()
            .securityContext().disable()
            .sessionManagement().disable();
        return http.build();
    }
	
	// Encryptacion de la password mediante BCrypt
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
