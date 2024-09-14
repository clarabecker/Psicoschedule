package com.psicoschedule.psicoschedule.modules.Profissional;

import org.hibernate.annotations.CreationTimestamp;

import com.psicoschedule.psicoschedule.modules.Pessoa.PessoaEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity(name = "Profissional")

public class ProfissionalEntity extends PessoaEntity{
    private String numeroRegistro;
    private String especialidade;
    private String biografia;
    private String certificados;
    private String notaAutorizacao;
    private String metodoAtendimento;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
}
