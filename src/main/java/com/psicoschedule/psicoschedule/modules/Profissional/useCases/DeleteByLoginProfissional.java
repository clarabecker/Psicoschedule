package com.psicoschedule.psicoschedule.modules.Profissional.useCases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psicoschedule.psicoschedule.exceptions.UserNotFoundException;
import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.repositories.AgendaRepository;
import com.psicoschedule.psicoschedule.modules.Profissional.repositories.ProfissionalRepository;
import com.psicoschedule.psicoschedule.modules.Sessão.SessaoRepository;

@Service
public class DeleteByLoginProfissional {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired 
    private SessaoRepository sessaoRepository;

    @Transactional
    public void execute(String login) {
    
    Optional<ProfissionalEntity> profissionalExistente = 
        this.profissionalRepository.findBylogin(login);


    if (profissionalExistente.isEmpty()) {
        throw new UserNotFoundException(); 
    }

     this.agendaRepository.deleteByProfissionalEntity(profissionalExistente.get());

     // Deletar o profissional da sessao
     this.sessaoRepository.deleteByProfissionalEntity(profissionalExistente.get());

    // Realize a deleção do profissional
    this.profissionalRepository.delete(profissionalExistente.get());
    }
    
}
