package com.psicoschedule.psicoschedule.modules.Profissional.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.psicoschedule.psicoschedule.modules.Profissional.entities.AgendaEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.useCases.CreateAgenda;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    @Autowired
    private CreateAgenda createAgenda;

    @PostMapping("/")
    public AgendaEntity create(@Valid @RequestBody AgendaEntity agendaEntity) {
        return this.createAgenda.execute(agendaEntity);
    }
}
