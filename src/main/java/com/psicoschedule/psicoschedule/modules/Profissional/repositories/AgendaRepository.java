package com.psicoschedule.psicoschedule.modules.Profissional.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psicoschedule.psicoschedule.modules.Profissional.entities.AgendaEntity;

public interface AgendaRepository extends JpaRepository<AgendaEntity, UUID>{
    
}
