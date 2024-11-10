package com.psicoschedule.psicoschedule.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

        HttpSession session = request.getSession(false); 
        String uri = request.getRequestURI();

        if (uri.equals("/paciente/cadastro") || uri.equals("/paciente/auth") || 
        uri.equals("/profissional/cadastro") || uri.equals("/profissional/auth")) {
            filterChain.doFilter(request, response);
            return;
        }
        
        if (session != null && session.getAttribute("login") != null) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
