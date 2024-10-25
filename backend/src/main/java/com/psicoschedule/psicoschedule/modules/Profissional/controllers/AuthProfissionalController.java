package com.psicoschedule.psicoschedule.modules.Profissional.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicoschedule.psicoschedule.modules.Profissional.DTO.AuthProfissionalDTO;
import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.useCases.AuthProfissional;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/profissional/")
public class AuthProfissionalController {
    
    @Autowired
    private AuthProfissional authProfissional;
    
    @PostMapping("auth")
    public ResponseEntity<String> login(@RequestBody @Validated AuthProfissionalDTO authProfissionalDTO, HttpSession session) {
        ProfissionalEntity profissional = authProfissional.autenticar(authProfissionalDTO.getLogin(), authProfissionalDTO.getSenha());
        if (profissional != null) {
            session.setAttribute("login", profissional.getLogin());
            return ResponseEntity.ok("Login bem-sucedido!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
    }
}
