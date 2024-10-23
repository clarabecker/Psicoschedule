package com.psicoschedule.psicoschedule.modules.Paciente.useCases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psicoschedule.psicoschedule.exceptions.UserNotFoundException;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteRepository;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteEntity;
import com.psicoschedule.psicoschedule.modules.Sessão.SessaoRepository;

@Service
public class DeleteByLoginPaciente {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired 
    private SessaoRepository sessaoRepository;

    @Transactional
    public void execute(String login) {
    
    Optional<PacienteEntity> pacienteExistente = 
        this.pacienteRepository.findBylogin(login);


    if (pacienteExistente.isEmpty()) {
        throw new UserNotFoundException(); 
    }

    this.sessaoRepository.deleteByPacienteEntity(pacienteExistente.get());

    this.pacienteRepository.delete(pacienteExistente.get());
    }
}
