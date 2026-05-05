package com.autobots.automanager.modelos.atualizador;

import com.autobots.automanager.dto.request.CredencialRequestDTO;
import com.autobots.automanager.entidades.Credencial;
import com.autobots.automanager.entidades.CredencialUsuarioSenha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CredencialAtualizador {

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void atualizar(Credencial credencial, CredencialRequestDTO dto) {
        if (dto == null) return;

        CredencialUsuarioSenha cus = (CredencialUsuarioSenha) credencial;

        if (dto.nomeUsuario() != null && !dto.nomeUsuario().isBlank()) {
            cus.setNomeUsuario(dto.nomeUsuario());
        }
        if (dto.senha() != null && !dto.senha().isBlank()) {
            cus.setSenha(encoder.encode(dto.senha()));
        }
    }

    public void atualizar(Collection<Credencial> credenciais, Collection<CredencialRequestDTO> atualizacoes) {
        if (atualizacoes == null) return;
        for (CredencialRequestDTO dto : atualizacoes) {
            if (dto.id() == null) continue;
            credenciais.stream()
                    .filter(c -> c.getId().equals(dto.id()))
                    .findFirst()
                    .ifPresent(c -> atualizar(c, dto));
        }
    }
}