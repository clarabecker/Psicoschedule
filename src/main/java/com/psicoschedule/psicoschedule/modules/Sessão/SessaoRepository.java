package com.psicoschedule.psicoschedule.modules.Sessão;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;

public interface SessaoRepository extends JpaRepository<SessaoEntity, UUID>{
      void deleteByProfissionalEntity(ProfissionalEntity profissionalEntity);
}
