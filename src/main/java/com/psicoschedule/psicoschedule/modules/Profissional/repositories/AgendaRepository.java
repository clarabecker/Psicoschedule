package com.psicoschedule.psicoschedule.modules.Profissional.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psicoschedule.psicoschedule.modules.Profissional.entities.AgendaEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;

public interface AgendaRepository extends JpaRepository<AgendaEntity, UUID>{
    void deleteByProfissionalEntity(ProfissionalEntity profissionalEntity);
    void deleteById(UUID id);
    Optional<AgendaEntity> findById(UUID id);
    List<AgendaEntity> findByProfissionalEntity(ProfissionalEntity profissional);
}
