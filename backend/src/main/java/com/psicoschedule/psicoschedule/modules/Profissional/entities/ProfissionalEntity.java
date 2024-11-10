package com.psicoschedule.psicoschedule.modules.Profissional.entities;

import org.hibernate.annotations.CreationTimestamp;

import com.psicoschedule.psicoschedule.modules.Pessoa.PessoaEntity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "Profissional")
public class ProfissionalEntity extends PessoaEntity{
    private String numeroRegistro;
    private String especialidade;
    private String biografia;
    private String certificados;
    private String notaAutorizacao;
    private String metodoAtendimento;

    private String role;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
}
