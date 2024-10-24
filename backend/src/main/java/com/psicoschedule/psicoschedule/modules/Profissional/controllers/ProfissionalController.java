package com.psicoschedule.psicoschedule.modules.Profissional.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.psicoschedule.psicoschedule.exceptions.UserNotFoundException;
import com.psicoschedule.psicoschedule.modules.Profissional.DTO.AuthProfissionalDTO;
import com.psicoschedule.psicoschedule.modules.Profissional.DTO.ProfissionalLoginDTO;
import com.psicoschedule.psicoschedule.modules.Profissional.DTO.UpdateProfissionalDTO;

import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.useCases.AuthProfissional;
import com.psicoschedule.psicoschedule.modules.Profissional.useCases.CreateProfissional;
import com.psicoschedule.psicoschedule.modules.Profissional.useCases.DeleteByLoginProfissional;
import com.psicoschedule.psicoschedule.modules.Profissional.useCases.FindProfissionalByLogin;
import com.psicoschedule.psicoschedule.modules.Profissional.useCases.ListAllProfissional;
import com.psicoschedule.psicoschedule.modules.Profissional.useCases.UpdateProfissional;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {
    @Autowired
    private CreateProfissional createProfissional;

    @Autowired
    private FindProfissionalByLogin findProfissionalByLogin; 

    @Autowired
    private ListAllProfissional listAllProfissional;

    @Autowired 
    private UpdateProfissional updateProfissional;

    @Autowired 
    private DeleteByLoginProfissional deleteByLogin;

    @Autowired
    private AuthProfissional authProfissional;
    
    @PostMapping("/cadastro")
    public ResponseEntity<Object> create(@Valid @RequestBody ProfissionalEntity profissionalEntity) {
        try{
            var result = this.createProfissional.execute(profissionalEntity);  
            return ResponseEntity.ok().body(result);
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

   @PostMapping("/buscarProfissional")
    public ResponseEntity<Object> findProfissional(@Valid @RequestBody ProfissionalLoginDTO profissionalLoginDTO) {
        try {
            var result = this.findProfissionalByLogin.execute(profissionalLoginDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/profiles")
    public List<ProfissionalEntity> listarTodos() {
        return listAllProfissional.listAll(); 
    }

    @PostMapping("/atualizarProfissional/{login}")
    public ResponseEntity<ProfissionalEntity> updateProfissional(@PathVariable String login, @Valid @RequestBody UpdateProfissionalDTO updateProfissionalDTO) { 
        try {
            ProfissionalEntity updatedProfissional = updateProfissional.updateProfissional(login, updateProfissionalDTO);
            return ResponseEntity.ok(updatedProfissional);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

   @DeleteMapping("/deletarProfissional/{login}")
    public ResponseEntity<Object> deleteProfissional(@PathVariable String login) {
        try {
            this.deleteByLogin.execute(login); 
            return ResponseEntity.noContent().build(); 
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); 
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); 
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Validated AuthProfissionalDTO authProfissionalDTO, HttpSession session) {
        ProfissionalEntity profissional = authProfissional.autenticar(authProfissionalDTO.getLogin(), authProfissionalDTO.getSenha());
        if (profissional != null) {
            session.setAttribute("login", profissional.getLogin());
            return ResponseEntity.ok("Login bem-sucedido!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
    }
}