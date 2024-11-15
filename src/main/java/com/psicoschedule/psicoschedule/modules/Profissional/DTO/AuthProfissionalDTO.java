package com.psicoschedule.psicoschedule.modules.Profissional.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthProfissionalDTO {
    @NotBlank(message = "O campo Login não pode ser vazio")
    private String login;
    @NotBlank(message = "O campo Senha não pode ser vazio")
    private String senha;
}
