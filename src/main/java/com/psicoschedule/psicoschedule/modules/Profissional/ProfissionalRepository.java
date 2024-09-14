package com.psicoschedule.psicoschedule.modules.Profissional;

import java.util.UUID;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<ProfissionalEntity, UUID> {
    Optional<ProfissionalEntity> findByloginOrCPF(String login, String CPF);
}
