package com.psicoschedule.psicoschedule.modules.Paciente.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psicoschedule.psicoschedule.exceptions.UserNotFoundException;
import com.psicoschedule.psicoschedule.modules.Paciente.DTO.UpdatePacienteDTO;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteEntity;
import com.psicoschedule.psicoschedule.modules.Paciente.useCases.CreatePaciente;
import com.psicoschedule.psicoschedule.modules.Paciente.useCases.DeleteByLoginPaciente;
import com.psicoschedule.psicoschedule.modules.Paciente.useCases.UpdatePaciente;

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
        try {
            // Garantir que o role seja atribuído automaticamente
            pacienteEntity.setRole("PACIENTE");  // Atribui o valor fixo "PACIENTE"

            // Executar a lógica de criação do paciente
            var result = this.createPaciente.execute(pacienteEntity);

            // Certifique-se de que o objeto de resposta inclui 'role'
            return ResponseEntity.ok().body(result);  // O 'result' deve incluir o campo 'role' do paciente
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/atualizarPaciente/{login}")
public ResponseEntity<PacienteEntity> updatePaciente(
        @PathVariable String login, 
        @Valid @RequestBody UpdatePacienteDTO updatePacienteDTO) { 

    // Logger para registrar informações
    Logger logger = LoggerFactory.getLogger(this.getClass());

    try {
        // Log para verificar a entrada
        logger.info("Recebida solicitação de atualização para o login: {}", login);
        logger.info("Dados recebidos para atualização: {}", updatePacienteDTO);

        // Atualiza o paciente com os dados fornecidos
        PacienteEntity updatedPaciente = updatePaciente.updatePaciente(login, updatePacienteDTO); // Ajustado para PacienteEntity

        // Log para confirmar a atualização
        logger.info("Paciente atualizado com sucesso: {}", updatedPaciente);

        return ResponseEntity.ok(updatedPaciente);
    } catch (UserNotFoundException e) {
        logger.error("Paciente com login '{}' não encontrado.", login);
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        logger.error("Erro ao atualizar paciente com login '{}'. Detalhes: {}", login, e.getMessage());
        return ResponseEntity.badRequest().body(null);
    }
}

    @DeleteMapping("/deletarPaciente/{login}")
    public ResponseEntity<Object> deleteProfissional(@PathVariable String login) {
        try {
            // Deleta o paciente com o login fornecido
            this.deleteByLogin.execute(login); 
            return ResponseEntity.noContent().build(); 
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); 
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); 
        }
    }
}
