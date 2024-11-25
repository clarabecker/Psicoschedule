package com.psicoschedule.psicoschedule.modules.Paciente.useCases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.psicoschedule.psicoschedule.modules.Paciente.PacienteEntity;
import com.psicoschedule.psicoschedule.modules.Paciente.PacienteRepository;

@Service
public class AuthPaciente {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PacienteEntity autenticar(String login, String senha) {
        Optional<PacienteEntity> pacienteOpt = pacienteRepository.findBylogin(login);
        
        if (pacienteOpt.isPresent()) {
            PacienteEntity paciente = pacienteOpt.get();
            if (passwordEncoder.matches(senha, paciente.getSenha())) {
                return paciente; // Retorna o paciente autenticado
            }
        }
        
        return null; // Retorna null se não encontrar ou senha incorreta
    }
}
