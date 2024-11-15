package com.psicoschedule.psicoschedule.modules.Paciente;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<PacienteEntity, UUID>{
    Optional<PacienteEntity> findByloginOrCPF(String login, String CPF);

    Optional<PacienteEntity> findBylogin(String login);
}
