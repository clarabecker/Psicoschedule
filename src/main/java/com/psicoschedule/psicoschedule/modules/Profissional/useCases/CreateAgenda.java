package com.psicoschedule.psicoschedule.modules.Profissional.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicoschedule.psicoschedule.modules.Profissional.entities.AgendaEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.repositories.AgendaRepository;

@Service
public class CreateAgenda {
    @Autowired
    private AgendaRepository agendaRepository;

    public AgendaEntity execute(AgendaEntity agendaEntity) {
        return this.agendaRepository.save(agendaEntity);
    }
}
