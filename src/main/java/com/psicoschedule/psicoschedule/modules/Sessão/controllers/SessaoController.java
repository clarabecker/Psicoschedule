package com.psicoschedule.psicoschedule.modules.Sessão.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.psicoschedule.psicoschedule.modules.Sessão.SessaoEntity;
import com.psicoschedule.psicoschedule.modules.Sessão.useCases.CreateSessao;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/sessao")
public class SessaoController {
    @Autowired
    private CreateSessao createSessao;

    @PostMapping("/")
    public SessaoEntity create(@Valid @RequestBody SessaoEntity sessaoEntity) {
        return this.createSessao.execute(sessaoEntity);
    }
   
}
