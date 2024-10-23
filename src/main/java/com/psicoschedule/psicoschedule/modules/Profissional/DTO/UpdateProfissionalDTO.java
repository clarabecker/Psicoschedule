package com.psicoschedule.psicoschedule.modules.Profissional.DTO;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UpdateProfissionalDTO {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String login;
    private String senha;
    private LocalDate data_nascimento;
    private String genero;
    private String CPF;
    private String foto; 
    private String numeroRegistro;
    private String especialidade;
    private String biografia;
    private String certificados;
    private String metodoAtendimento;

}
