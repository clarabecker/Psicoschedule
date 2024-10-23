package com.psicoschedule.psicoschedule.modules.Paciente.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicoschedule.psicoschedule.exceptions.UserFoundException;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteEntity;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteRepository;

@Service
public class CreatePaciente {
    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteEntity execute(PacienteEntity pacienteEntity) {
        this.pacienteRepository.findByloginOrCPF(pacienteEntity.getLogin(), pacienteEntity.getCPF())
        .ifPresent((user) -> {
            throw new UserFoundException();
        });
        
        
        return this.pacienteRepository.save(pacienteEntity);
    }
    
}
