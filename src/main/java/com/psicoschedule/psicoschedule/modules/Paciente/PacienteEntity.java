package com.psicoschedule.psicoschedule.modules.Paciente;

import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;

import com.psicoschedule.psicoschedule.modules.Pessoa.PessoaEntity;

import jakarta.persistence.Entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity(name = "Paciente")
public class PacienteEntity extends PessoaEntity {
    
    private LocalTime preferenciaHorario;
    private String preferenciaDiaSemana;

    private String preferenciaEspecialidade;
    
    private String role;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
