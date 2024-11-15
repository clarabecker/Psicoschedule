package com.psicoschedule.psicoschedule.modules.Profissional.useCases.Agenda;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicoschedule.psicoschedule.exceptions.UserNotFoundException;
import com.psicoschedule.psicoschedule.modules.Profissional.entities.AgendaEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.repositories.AgendaRepository;
import com.psicoschedule.psicoschedule.modules.Profissional.repositories.ProfissionalRepository;

@Service
public class ListAgendasByProfissional {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    public List<AgendaEntity> execute(String profissionalLogin) {
        
        Optional<ProfissionalEntity> profissionalExistente =
            profissionalRepository.findBylogin(profissionalLogin);

        if (profissionalExistente.isEmpty()) {
            throw new UserNotFoundException();
        }

        return agendaRepository.findByProfissionalEntity(profissionalExistente.get());
    }
}

