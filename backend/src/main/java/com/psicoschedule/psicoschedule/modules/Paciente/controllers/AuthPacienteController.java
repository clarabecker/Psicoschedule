package com.psicoschedule.psicoschedule.modules.Paciente.controllers;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicoschedule.psicoschedule.modules.Paciente.PacienteEntity;
import com.psicoschedule.psicoschedule.modules.Paciente.DTO.AuthPacienteDTO;
import com.psicoschedule.psicoschedule.modules.Paciente.useCases.AuthPaciente;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/paciente/")
public class AuthPacienteController {
    
    @Autowired 
    private AuthPaciente authPaciente;
    
    @PostMapping("auth")
    public ResponseEntity<String> login(@RequestBody @Validated AuthPacienteDTO authPacienteDTO, HttpSession session) {
        PacienteEntity paciente = authPaciente.autenticar(authPacienteDTO.getLogin(), authPacienteDTO.getSenha());
        
        if (paciente != null) {
            session.setAttribute("login", paciente.getLogin());
            session.setAttribute("role", "PACIENTE");
            return ResponseEntity.ok("Login bem-sucedido!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
    }
}
