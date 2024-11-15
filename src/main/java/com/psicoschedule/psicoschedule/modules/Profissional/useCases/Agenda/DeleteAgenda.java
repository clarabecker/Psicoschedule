package com.psicoschedule.psicoschedule.modules.Profissional.useCases.Agenda;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicoschedule.psicoschedule.exceptions.AgendaNotFoundException;
import com.psicoschedule.psicoschedule.modules.Profissional.entities.AgendaEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.repositories.AgendaRepository;

@Service
public class DeleteAgenda {
    @Autowired
    private AgendaRepository agendaRepository;

    public void execute(UUID agendaId) {
        
        Optional<AgendaEntity> agendaExistente = this.agendaRepository.findById(agendaId);

        if (agendaExistente.isEmpty()) {
            throw new AgendaNotFoundException("Agenda não encontrada para o ID: " + agendaId);
        }

        this.agendaRepository.deleteById(agendaId);
    }
}
