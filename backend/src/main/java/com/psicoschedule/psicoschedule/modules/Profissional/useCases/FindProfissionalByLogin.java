package com.psicoschedule.psicoschedule.modules.Profissional.useCases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psicoschedule.psicoschedule.exceptions.UserNotFoundException;
import com.psicoschedule.psicoschedule.modules.Profissional.DTO.ProfissionalLoginDTO;
import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.repositories.ProfissionalRepository;

@Service
public class FindProfissionalByLogin {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Transactional(readOnly = true)
    public ProfissionalEntity execute(ProfissionalLoginDTO profissionalLoginDTO) {
        Optional<ProfissionalEntity> profissionalExistente = 
            this.profissionalRepository.findBylogin(profissionalLoginDTO.getLogin());

        if (profissionalExistente.isEmpty()) {
            throw new UserNotFoundException();
        }

        return profissionalExistente.get();
    }
}
