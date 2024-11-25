package com.psicoschedule.psicoschedule.modules.Paciente;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;



public interface PacienteRepository extends JpaRepository<PacienteEntity, UUID>{
    Optional<PacienteEntity> findByloginOrCPF(String login, String CPF);

    Optional<PacienteEntity> findBylogin(String login);
}
