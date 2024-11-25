package com.psicoschedule.psicoschedule.modules.Pessoa;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

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

    protected LocalDate data_nascimento;

    protected String genero;

    protected String CPF;

    protected String foto; 

}
