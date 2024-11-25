package com.psicoschedule.psicoschedule.modules.Paciente.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicoschedule.psicoschedule.modules.Paciente.DTO.AuthPacienteDTO;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteEntity;
import com.psicoschedule.psicoschedule.modules.Paciente.useCases.AuthPaciente;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/paciente/")
public class AuthPacienteController {
    
    private static final Logger logger = LoggerFactory.getLogger(AuthPacienteController.class);

    @Autowired 
    private AuthPaciente authPaciente;
    
    @PostMapping("auth")
    public ResponseEntity<String> login(@RequestBody @Validated AuthPacienteDTO authPacienteDTO, HttpSession session) {
        logger.info("Tentando autenticar o paciente com login: {}", authPacienteDTO.getLogin());
        
        PacienteEntity paciente = authPaciente.autenticar(authPacienteDTO.getLogin(), authPacienteDTO.getSenha());

        if (paciente != null) {
            session.setAttribute("login", paciente.getLogin());
            session.setAttribute("role", paciente.getRole());
            logger.info("Login bem-sucedido para o paciente: {}", paciente.getLogin());
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            logger.warn("Falha na autenticação para o login: {}", authPacienteDTO.getLogin());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
        }
    }

    @PostMapping("logoff")
    public String logoff(HttpServletRequest request) {
        HttpSession session = request.getSession(false); 

        if (session != null) {
            session.invalidate();
            logger.info("Logoff realizado com sucesso.");
            return "Logoff realizado com sucesso!";
        }

        logger.warn("Tentativa de logoff sem sessão ativa.");
        return "Nenhuma sessão ativa para finalizar.";
    }
}
