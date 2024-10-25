package com.psicoschedule.psicoschedule.modules.Paciente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicoschedule.psicoschedule.exceptions.UserNotFoundException;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteEntity;
import com.psicoschedule.psicoschedule.modules.Paciente.DTO.AuthPacienteDTO;
import com.psicoschedule.psicoschedule.modules.Paciente.DTO.UpdatePacienteDTO;
import com.psicoschedule.psicoschedule.modules.Paciente.useCases.AuthPaciente;
import com.psicoschedule.psicoschedule.modules.Paciente.useCases.CreatePaciente;
import com.psicoschedule.psicoschedule.modules.Paciente.useCases.DeleteByLoginPaciente;
import com.psicoschedule.psicoschedule.modules.Paciente.useCases.UpdatePaciente;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private CreatePaciente createPaciente;

    @Autowired
    private UpdatePaciente updatePaciente;

    @Autowired
    private DeleteByLoginPaciente deleteByLogin;
    
    @PostMapping("/cadastro")
    public ResponseEntity<Object> create(@Valid @RequestBody PacienteEntity pacienteEntity) {
        try{
            var result = this.createPaciente.execute(pacienteEntity);  
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
}

    @PostMapping("/atualizarPaciente/{login}")
    public ResponseEntity<PacienteEntity> updatePaciente(@PathVariable String login, @Valid @RequestBody UpdatePacienteDTO updatePacienteDTO) { 
        try {
            PacienteEntity updatedPaciente = updatePaciente.updatePaciente(login, updatePacienteDTO); // Ajustado para PacienteEntity
            return ResponseEntity.ok(updatedPaciente);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/deletarPaciente/{login}")
    public ResponseEntity<Object> deleteProfissional(@PathVariable String login) {
        try {
            this.deleteByLogin.execute(login); 
            return ResponseEntity.noContent().build(); 
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); 
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); 
        }
    }
}
