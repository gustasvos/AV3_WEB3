package com.autobots.automanager.dto.response;

import com.autobots.automanager.dto.DocumentoDTO;
import com.autobots.automanager.dto.EmailDTO;
import com.autobots.automanager.dto.EnderecoDTO;
import com.autobots.automanager.dto.TelefoneDTO;
import com.autobots.automanager.enumeracoes.PerfilUsuario;

import java.util.Set;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String nomeSocial,
        Set<PerfilUsuario> perfis,
        EnderecoDTO endereco,
        Set<DocumentoDTO> documentos,
        Set<TelefoneDTO> telefones,
        Set<EmailDTO> emails,
        Set<CredencialResponseDTO> credenciais
) {}