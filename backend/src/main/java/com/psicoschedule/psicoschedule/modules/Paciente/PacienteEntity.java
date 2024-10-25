package com.psicoschedule.psicoschedule.modules.Paciente;

import java.time.LocalTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.psicoschedule.psicoschedule.modules.Pessoa.PessoaEntity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity(name = "Paciente")
public class PacienteEntity extends PessoaEntity {
    
    private LocalTime preferenciaHorario;
    private String preferenciaDiaSemana;
    @NotEmpty(message = "Usuário deve infomar a especialidade desejada")
    private String preferenciaEspecialidade;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "paciente_roles", joinColumns = @JoinColumn(name = "paciente_id"))
    @Column(name = "role")
    private Set<String> role;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
