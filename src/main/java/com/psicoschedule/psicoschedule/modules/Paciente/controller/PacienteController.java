package com.psicoschedule.psicoschedule.modules.Paciente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicoschedule.psicoschedule.modules.Paciente.PacienteEntity;
import com.psicoschedule.psicoschedule.modules.Paciente.useCases.CreatePaciente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private CreatePaciente createPaciente;
    
    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody PacienteEntity pacienteEntity) {
        try{
            var result = this.createPaciente.execute(pacienteEntity);  
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    
}
}
