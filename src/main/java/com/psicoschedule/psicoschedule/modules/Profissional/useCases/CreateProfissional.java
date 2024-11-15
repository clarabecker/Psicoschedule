package com.psicoschedule.psicoschedule.modules.Profissional.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.psicoschedule.psicoschedule.exceptions.UserFoundException;
import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.repositories.ProfissionalRepository;

@Service
public class CreateProfissional{
    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ProfissionalEntity execute(ProfissionalEntity profissionalEntity) {
        this.profissionalRepository.findByloginOrCPF(profissionalEntity.getLogin(), profissionalEntity.getCPF())
        .ifPresent((user) -> {
            throw new UserFoundException();
        });
        
        profissionalEntity.setSenha(passwordEncoder.encode(profissionalEntity.getSenha()));
        return this.profissionalRepository.save(profissionalEntity);
    }

}
