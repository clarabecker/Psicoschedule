package com.psicoschedule.psicoschedule.filters;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;

@Component
public class FilterAutenticacao implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();


        if (uri.equals("/paciente/cadastro") || uri.equals("/paciente/login")) {
            filterchain.doFilter(request, response);
            return;
        }

        if (uri.equals("/profissional/cadastro") || uri.equals("/profissional/login")) {
            filterchain.doFilter(request, response);
            return;
        }
    
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("login") == null) {
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuário não autenticado");
            return;
        }

        filterchain.doFilter(request, response);
    }
}

