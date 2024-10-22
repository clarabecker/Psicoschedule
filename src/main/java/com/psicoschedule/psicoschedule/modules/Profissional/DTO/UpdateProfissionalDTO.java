package com.psicoschedule.psicoschedule.modules.Profissional.DTO;

import java.util.UUID;

import lombok.Data;

@Data
public class UpdateProfissionalDTO {
    private UUID id;
    private String nome;
    private String endereco;
    protected String telefone;
    private String numeroRegistro;
    private String especialidade;
    private String biografia;
    private String certificados;
    private String metodoAtendimento;
}
