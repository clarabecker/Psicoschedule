package com.psicoschedule.psicoschedule.modules.Profissional.repositories;

import java.util.UUID;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;

public interface ProfissionalRepository extends JpaRepository<ProfissionalEntity, UUID> {
    Optional<ProfissionalEntity> findByloginOrCPF(String login, String CPF);

    Optional<ProfissionalEntity> findBylogin(String login);
}
