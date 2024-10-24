package com.psicoschedule.psicoschedule.modules.Profissional.useCases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.repositories.ProfissionalRepository;

@Service
public class AuthProfissional {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ProfissionalEntity autenticar(String login, String senha) {
        Optional<ProfissionalEntity> profissionalOpt = profissionalRepository.findBylogin(login);
        
        if (profissionalOpt.isPresent()) {
            ProfissionalEntity profissional = profissionalOpt.get();
            if (passwordEncoder.matches(senha, profissional.getSenha())) {
                return profissional; 
            }
        }
        
        return null;
    }
}
