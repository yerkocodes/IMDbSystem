package com.imdbsystem.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

// AuthenticationSuccessHandler  =  manejo exitoso de inicio de sesion

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Override // >>> Metodo responsabilidad de verificar que autoridades existen y que rol tienen estas mismas
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		
		if (roles.contains("ADMIN")) {
			response.sendRedirect("/admin");
		} 

		if (roles.contains("USER")) {
			response.sendRedirect("/user");
		} 

	}

}
