package com.psicoschedule.psicoschedule.security;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
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
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();

        // Permitir acesso a rotas públicas (cadastro e autenticação)
        if (uri.equals("/paciente/cadastro") || uri.equals("/paciente/auth") || 
            uri.equals("/profissional/cadastro") || uri.equals("/profissional/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Obtendo a sessão atual, se existir
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("login") == null) {
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usuário não autenticado");
            return;
        }

        // Obtendo a role do usuário da sessão
        String role = (String) session.getAttribute("role");

        // Definindo URIs restritas para cada role
        List<String> pacienteUris = Arrays.asList("/paciente/cadastro", "/paciente/atualizarPaciente/","/paciente/deletarPaciente/", "/profissional/profiles","/profissional/buscarProfissional");
        List<String> profissionalUris = Arrays.asList("/profissional/cadastro", "/profissional/agenda", "/profissional/buscarProfissional");

        // Verificando se a role do usuário permite o acesso à URI solicitada
        if (role.equals("PACIENTE") && pacienteUris.contains(uri)) {
            filterChain.doFilter(request, response);
        } else if (role.equals("PROFISSIONAL") && profissionalUris.contains(uri)) {
            filterChain.doFilter(request, response);
        } else {
            // Acesso negado
            res.sendError(HttpServletResponse.SC_FORBIDDEN, "Acesso negado");
        }
    }
}
