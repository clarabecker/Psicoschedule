package com.psicoschedule.psicoschedule.modules.Profissional.entities;

import org.hibernate.annotations.CreationTimestamp;

import com.psicoschedule.psicoschedule.modules.Pessoa.PessoaEntity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity(name = "Profissional")
public class ProfissionalEntity extends PessoaEntity{
    private String numeroRegistro;
    private String especialidade;
    private String biografia;
    private String certificados;
    private String notaAutorizacao;
    private String metodoAtendimento;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "profissional_role", joinColumns = @JoinColumn(name = "profissional_id"))
    @Column(name = "role")
    private Set<String> role;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
}
