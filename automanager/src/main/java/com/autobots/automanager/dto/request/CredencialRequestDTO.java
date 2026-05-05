package com.autobots.automanager.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record CredencialRequestDTO(

        Long id,

        @NotBlank(message = "Nome de usuário é obrigatório")
        @Size(min = 3, max = 20, message = "Nome de usuário deve ter entre 3 e 20 caracteres")
        String nomeUsuario,

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
        String senha

) {}