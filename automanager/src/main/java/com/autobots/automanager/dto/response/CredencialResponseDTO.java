package com.autobots.automanager.dto.response;

import java.time.LocalDateTime;

public record CredencialResponseDTO(
        Long id,
        String nomeUsuario,
        LocalDateTime criacao,
        LocalDateTime ultimoAcesso,
        boolean inativo
) {}