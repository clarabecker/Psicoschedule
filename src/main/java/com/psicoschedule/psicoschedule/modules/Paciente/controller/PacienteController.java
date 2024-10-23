package com.psicoschedule.psicoschedule.modules.Paciente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicoschedule.psicoschedule.exceptions.UserNotFoundException;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteEntity;
import com.psicoschedule.psicoschedule.modules.Paciente.DTO.UpdatePacienteDTO;
import com.psicoschedule.psicoschedule.modules.Paciente.useCases.CreatePaciente;
import com.psicoschedule.psicoschedule.modules.Paciente.useCases.UpdatePaciente;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private CreatePaciente createPaciente;

    @Autowired
    private UpdatePaciente updatePaciente;
    
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

}
