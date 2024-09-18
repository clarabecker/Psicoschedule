package com.psicoschedule.psicoschedule.modules.Profissional.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.useCases.CreateProfissional;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {
    @Autowired
    private CreateProfissional createProfissional;
    
    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody ProfissionalEntity profissionalEntity) {
        try{
            var result = this.createProfissional.execute(profissionalEntity);  
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
}
}