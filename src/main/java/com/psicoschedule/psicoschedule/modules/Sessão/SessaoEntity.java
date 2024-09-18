package com.psicoschedule.psicoschedule.modules.Sessão;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.psicoschedule.psicoschedule.modules.Paciente.PacienteEntity;
import com.psicoschedule.psicoschedule.modules.Profissional.entities.ProfissionalEntity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "sessao")
public class SessaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate data;
    private LocalTime horario;
    private String status;

    @ManyToOne()
    @JoinColumn(name = "profissional_id", insertable = false, updatable = false)
    private ProfissionalEntity profissionalEntity;

    @Column(name="profissional_id", nullable = false)
    private UUID profissionalID;

    @ManyToOne()
    @JoinColumn(name = "paciente_id", insertable = false, updatable = false)
    private PacienteEntity pacienteEntity;

    @Column(name="paciente_id", nullable = false)
    private UUID pacienteID;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
