package com.autobots.automanager.modelos.adicionador;

import com.autobots.automanager.controles.UsuarioControle;
import com.autobots.automanager.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class AdicionadorLinkUsuario implements AdicionadorLink<Usuario> {

    @Autowired
    private AdicionadorLinkDocumento adicionadorLinkDocumento;
    @Autowired
    private AdicionadorLinkTelefone adicionadorLinkTelefone;
    @Autowired
    private AdicionadorLinkEndereco adicionadorLinkEndereco;
    @Autowired
    private AdicionadorLinkEmail adicionadorLinkEmail;

    @Override
    public void adicionarLink(Usuario objeto) {
        Link linkProprio = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(UsuarioControle.class)
                        .obterUsuario(objeto.getId()))
                .withSelfRel();
        objeto.add(linkProprio);

        Link linkColecao = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(UsuarioControle.class)
                        .obterUsuarios())
                .withRel("usuarios");
        objeto.add(linkColecao);

        if (objeto.getDocumentos() != null) {
            adicionadorLinkDocumento.adicionarLink(objeto.getDocumentos());
        }
        if (objeto.getTelefones() != null) {
            adicionadorLinkTelefone.adicionarLink(objeto.getTelefones());
        }
        if (objeto.getEndereco() != null) {
            adicionadorLinkEndereco.adicionarLink(objeto.getEndereco());
        }
        if (objeto.getEmails() != null) {
            adicionadorLinkEmail.adicionarLink(objeto.getEmails());
        }
    }

}
