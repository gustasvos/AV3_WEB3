package com.autobots.automanager.modelos.atualizador;

import com.autobots.automanager.dto.request.UsuarioRequestDTO;
import com.autobots.automanager.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioAtualizador {

    @Autowired
    private EnderecoAtualizador enderecoAtualizador;

    @Autowired
    private DocumentoAtualizador documentoAtualizador;

    @Autowired
    private TelefoneAtualizador telefoneAtualizador;

    @Autowired
    private EmailAtualizador emailAtualizador;

    @Autowired
    private CredencialAtualizador credencialAtualizador;

    public void atualizar(Usuario usuario, UsuarioRequestDTO dto) {
        if (dto == null) return;

        if (dto.nome() != null && !dto.nome().isBlank()) {
            usuario.setNome(dto.nome());
        }

        if (dto.nomeSocial() != null && !dto.nomeSocial().isBlank()) {
            usuario.setNomeSocial(dto.nomeSocial());
        }

        if (dto.perfis() != null && !dto.perfis().isEmpty()) {
            usuario.setPerfis(dto.perfis());
        }

        if (dto.endereco() != null) {
            enderecoAtualizador.atualizar(usuario.getEndereco(), dto.endereco());
        }

        if (dto.documentos() != null) {
            documentoAtualizador.atualizar(usuario.getDocumentos(), dto.documentos());
        }

        if (dto.telefones() != null) {
            telefoneAtualizador.atualizar(usuario.getTelefones(), dto.telefones());
        }

        if (dto.emails() != null) {
            emailAtualizador.atualizar(usuario.getEmails(), dto.emails());
        }

        if (dto.credenciais() != null) {
            credencialAtualizador.atualizar(usuario.getCredenciais(), dto.credenciais());
        }
    }

    public void atualizar(List<Usuario> usuarios, List<UsuarioRequestDTO> atualizacoes) {
        if (atualizacoes == null) return;

        for (UsuarioRequestDTO dto : atualizacoes) {
            if (dto.id() == null) continue;
            usuarios.stream()
                    .filter(u -> u.getId().equals(dto.id()))
                    .findFirst()
                    .ifPresent(u -> atualizar(u, dto));
        }
    }
}