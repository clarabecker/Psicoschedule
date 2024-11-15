package com.psicoschedule.psicoschedule.modules.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

@Data
@MappedSuperclass
public abstract class PessoaEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;
    
    protected String nome;
    protected String endereco;
    protected String telefone;

    @Email(message = "O campo (email) deve contrer um e-mail válido")
    protected String email;

    @Column(unique = true)
    @Pattern(regexp = "\\S+", message = "O campo login não deve conter espaço")
    protected String login;

    @Length(min = 5, max = 100, message= "A senha deve conter entre 5 e 100 cacteres")
    protected String senha;

    @NotNull(message = "A data de nascimento não pode ser nula")
    protected LocalDate data_nascimento;

    protected String genero;

    protected String CPF;

    protected String foto; 

}
