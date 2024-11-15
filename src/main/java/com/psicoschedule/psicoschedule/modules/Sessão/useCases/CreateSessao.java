package com.psicoschedule.psicoschedule.modules.Sessão.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicoschedule.psicoschedule.modules.Sessão.SessaoEntity;
import com.psicoschedule.psicoschedule.modules.Sessão.SessaoRepository;

@Service
public class CreateSessao {
    @Autowired
    private SessaoRepository sessaoRepository;

    public SessaoEntity execute(SessaoEntity sessaoEntity) {
        return this.sessaoRepository.save(sessaoEntity);
    }
}
