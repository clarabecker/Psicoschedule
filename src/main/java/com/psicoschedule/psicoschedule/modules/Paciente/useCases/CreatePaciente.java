package com.psicoschedule.psicoschedule.modules.Paciente.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.psicoschedule.psicoschedule.exceptions.UserFoundException;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteEntity;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteRepository;

@Service
public class CreatePaciente {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PacienteEntity execute(PacienteEntity pacienteEntity) {
        this.pacienteRepository.findByloginOrCPF(pacienteEntity.getLogin(), pacienteEntity.getCPF())
        .ifPresent((user) -> {
            throw new UserFoundException();
        });
        
        pacienteEntity.setSenha(passwordEncoder.encode(pacienteEntity.getSenha()));
        return this.pacienteRepository.save(pacienteEntity);
    }
    
}
