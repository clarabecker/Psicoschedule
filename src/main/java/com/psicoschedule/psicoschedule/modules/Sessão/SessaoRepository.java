package com.psicoschedule.psicoschedule.modules.Sessão;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<SessaoEntity, UUID>{
    
}
