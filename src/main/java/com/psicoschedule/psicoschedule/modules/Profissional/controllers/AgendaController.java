package com.psicoschedule.psicoschedule.modules.Profissional.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.psicoschedule.psicoschedule.exceptions.AgendaNotFoundException;
import com.psicoschedule.psicoschedule.exceptions.UserNotFoundException;
import com.psicoschedule.psicoschedule.modules.Profissional.entities.AgendaEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.useCases.Agenda.CreateAgenda;
import com.psicoschedule.psicoschedule.modules.Profissional.useCases.Agenda.DeleteAgenda;
import com.psicoschedule.psicoschedule.modules.Profissional.useCases.Agenda.ListAgendasByProfissional;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    @Autowired
    private CreateAgenda createAgenda;

    @Autowired
    private DeleteAgenda deleteAgenda;

    @Autowired
    private ListAgendasByProfissional listAgendasByProfissional;

    @PostMapping("/create")
    public AgendaEntity create(@Valid @RequestBody AgendaEntity agendaEntity) {
        return this.createAgenda.execute(agendaEntity);
    }

    @DeleteMapping("/DeletarAgenda/{agendaId}")
    public ResponseEntity<Void> deleteAgenda(@PathVariable UUID agendaId) {
        try {
            deleteAgenda.execute(agendaId);
            return ResponseEntity.noContent().build(); 
        } catch (AgendaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); 
        }
    }

    @GetMapping("/agendasProfissional/{profissionalLogin}")  // Define a URL da requisição GET
    public ResponseEntity<List<AgendaEntity>> getAgendasByProfissional(@PathVariable String profissionalLogin) {
        try {
            List<AgendaEntity> agendas = listAgendasByProfissional.execute(profissionalLogin);
            return ResponseEntity.ok(agendas);  // Retorna um código HTTP 200 com a lista de agendas
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();  // Retorna um código HTTP 404 caso o profissional não seja encontrado
        }
    }
    
}
