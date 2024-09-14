package com.psicoschedule.psicoschedule.modules.Profissional.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicoschedule.psicoschedule.exceptions.UserFoundException;
import com.psicoschedule.psicoschedule.modules.Profissional.ProfissionalEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.ProfissionalRepository;

@Service
public class CreateProfissional{
    @Autowired
    private ProfissionalRepository profissionalRepository;

      public ProfissionalEntity execute(ProfissionalEntity profissionalEntity) {
        this.profissionalRepository.findByloginOrCPF(profissionalEntity.getLogin(), profissionalEntity.getCPF())
        .ifPresent((user) -> {
            throw new UserFoundException();
        });
        
        return this.profissionalRepository.save(profissionalEntity);
    }

}
