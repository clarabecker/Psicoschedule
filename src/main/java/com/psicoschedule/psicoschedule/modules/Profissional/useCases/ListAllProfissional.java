package com.psicoschedule.psicoschedule.modules.Profissional.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.repositories.ProfissionalRepository;

@Service
public class ListAllProfissional {
    
    @Autowired
    private ProfissionalRepository profissionalRepository;

    public List<ProfissionalEntity> listAll() {
        return profissionalRepository.findAll();
    }
}