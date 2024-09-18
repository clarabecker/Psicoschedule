package com.psicoschedule.psicoschedule.modules.Profissional.entities;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity(name = "Agenda")
public class AgendaEntity {
    
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

    @CreationTimestamp
    private LocalDateTime createdAt;

}
